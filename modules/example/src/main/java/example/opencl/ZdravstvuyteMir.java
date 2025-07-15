package example.opencl;

import club.doki7.ffm.annotation.Unsigned;
import club.doki7.ffm.library.ILibraryLoader;
import club.doki7.ffm.library.ISharedLibrary;
import club.doki7.ffm.ptr.*;
import club.doki7.opencl.CL;
import club.doki7.opencl.handle.*;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public final class ZdravstvuyteMir {
    static void checkError(int error, String message) {
        if (error != CL.SUCCESS) {
            throw new RuntimeException("OpenCL error " + error + " during " + message);
        }
    }

    public static void main(String[] args) throws IOException {
        try (ISharedLibrary libOpenCL = ILibraryLoader.platformLoader().loadLibrary("OpenCL");
             Arena arena = Arena.ofConfined()) {
            CL cl = new CL(libOpenCL);

            @Unsigned IntPtr pNumPlatforms = IntPtr.allocate(arena);
            CLPlatformId.Ptr pPlatformId = CLPlatformId.Ptr.allocate(arena);
            int err = cl.getPlatformIDs(1, pPlatformId, pNumPlatforms);
            checkError(err, "clGetPlatformIDs");
            CLPlatformId ignoredUnusedPlatformId = Objects.requireNonNull(pPlatformId.read());

            CLDeviceId.Ptr pDeviceId = CLDeviceId.Ptr.allocate(arena);
            err = cl.getDeviceIDs(pPlatformId.read(), CL.DEVICE_TYPE_GPU, 1, pDeviceId, null);
            if (err == CL.DEVICE_NOT_FOUND) {
                System.err.println("No GPU device found, trying CPU device instead");
                err = cl.getDeviceIDs(pPlatformId.read(), CL.DEVICE_TYPE_CPU, 1, pDeviceId, null);
            }
            checkError(err, "clGetDeviceIDs");
            CLDeviceId deviceId = Objects.requireNonNull(pDeviceId.read());

            IntPtr pErr = IntPtr.allocate(arena);
            CLContext context = cl.createContext(null, 1, pDeviceId, MemorySegment.NULL, MemorySegment.NULL, pErr);
            checkError(pErr.read(), "clCreateContext");

            CLCommandQueue commandQueue = cl.createCommandQueue(context, deviceId, 0, pErr);
            checkError(pErr.read(), "clCreateCommandQueue");

            String kernelSource = Files.readString(Path.of("example/resc/vector_add.cl"));
            BytePtr pszKernelSource = BytePtr.allocateString(arena, kernelSource);

            CLProgram program = cl.createProgramWithSource(
                    context,
                    1,
                    PointerPtr.allocateV(arena, pszKernelSource),
                    PointerPtr.allocateV(arena, MemorySegment.ofAddress(pszKernelSource.size() - 1)),
                    pErr
            );
            checkError(pErr.read(), "clCreateProgramWithSource");

            err = cl.buildProgram(program, 1, pDeviceId, null, MemorySegment.NULL, MemorySegment.NULL);
            if (err != CL.SUCCESS) {
                PointerPtr pLogSize = PointerPtr.allocate(arena);
                cl.getProgramBuildInfo(program, deviceId, CL.PROGRAM_BUILD_LOG, 0, MemorySegment.NULL, pLogSize);
                long logSize = pLogSize.read().address();

                BytePtr log = BytePtr.allocate(arena, logSize);
                cl.getProgramBuildInfo(program, deviceId, CL.PROGRAM_BUILD_LOG, logSize, log.segment(), null);

                throw new RuntimeException("Failed to build OpenCL program, build log:\n" + log.readStringSafe());
            }

            CLKernel kernel = cl.createKernel(program, BytePtr.allocateString(arena, "vector_add"), pErr);
            checkError(pErr.read(), "clCreateKernel");

            int n = 1024;
            CLMem deviceMemA = Objects.requireNonNull(
                    cl.createBuffer(context, CL.MEM_READ_ONLY, n * Float.BYTES, MemorySegment.NULL, pErr)
            );
            CLMem deviceMemB = Objects.requireNonNull(
                    cl.createBuffer(context, CL.MEM_READ_ONLY, n * Float.BYTES, MemorySegment.NULL, pErr)
            );
            CLMem deviceMemC = Objects.requireNonNull(
                    cl.createBuffer(context, CL.MEM_WRITE_ONLY, n * Float.BYTES, MemorySegment.NULL, pErr)
            );
            checkError(pErr.read(), "clCreateBuffer");

            FloatPtr hostBufferA = FloatPtr.allocate(arena, n);
            FloatPtr hostBufferB = FloatPtr.allocate(arena, n);
            for (int i = 0; i < n; i++) {
                hostBufferA.write(i, (float) i);
                hostBufferB.write(i, (float) (n - i));
            }

            err = cl.enqueueWriteBuffer(
                    commandQueue,
                    deviceMemA,
                    CL.TRUE,
                    0,
                    hostBufferA.size() * Float.BYTES,
                    hostBufferA.segment(),
                    0,
                    null,
                    null
            );
            err |= cl.enqueueWriteBuffer(
                    commandQueue,
                    deviceMemB,
                    CL.TRUE,
                    0,
                    hostBufferB.size() * Float.BYTES,
                    hostBufferB.segment(),
                    0,
                    null,
                    null
            );
            checkError(err, "clEnqueueWriteBuffer");

            long sizeOfCLMem = ValueLayout.ADDRESS.byteSize();
            PointerPtr pDeviceMemory = PointerPtr.allocate(arena);
            pDeviceMemory.write(deviceMemA);
            err = cl.setKernelArg(kernel, 0, sizeOfCLMem, pDeviceMemory.segment());
            pDeviceMemory.write(deviceMemB);
            err |= cl.setKernelArg(kernel, 1, sizeOfCLMem, pDeviceMemory.segment());
            pDeviceMemory.write(deviceMemC);
            err |= cl.setKernelArg(kernel, 2, sizeOfCLMem, pDeviceMemory.segment());
            checkError(err, "clSetKernelArg");

            err = cl.enqueueNDRangeKernel(
                    commandQueue,
                    kernel,
                    1,
                    null,
                    PointerPtr.allocateV(arena, MemorySegment.ofAddress(n)),
                    null,
                    0,
                    null,
                    null
            );
            checkError(err, "clEnqueueNDRangeKernel");

            cl.finish(commandQueue);

            err = cl.enqueueReadBuffer(
                    commandQueue,
                    deviceMemC,
                    CL.TRUE,
                    0,
                    n * Float.BYTES,
                    hostBufferA.segment(),
                    0,
                    null,
                    null
            );
            checkError(err, "clEnqueueReadBuffer");

            for (int i = 0; i < n; i++) {
                float expected = (float) n;
                if (Math.abs(hostBufferA.read(i) - expected) > 1e-5f) {
                    throw new RuntimeException("Validation failed at index " + i + ": expected " + expected + ", got " + hostBufferA.read(i));
                }
            }

            System.out.println("Vector addition completed successfully! First 10 results:");
            for (int i = 0; i < 10; i++) {
                System.out.println("C[" + i + "] = " + hostBufferA.read(i));
            }

            cl.releaseMemObject(deviceMemA);
            cl.releaseMemObject(deviceMemB);
            cl.releaseMemObject(deviceMemC);
            cl.releaseKernel(kernel);
            cl.releaseProgram(program);
            cl.releaseCommandQueue(commandQueue);
            cl.releaseContext(context);
        }
    }
}
