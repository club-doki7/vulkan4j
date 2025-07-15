package club.doki7.opencl;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.RawFunctionLoader;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.opencl.datatype.*;
import club.doki7.opencl.handle.*;
import static club.doki7.opencl.CLFunctionTypes.*;

public final class CL implements CLConstants {
    public CL(RawFunctionLoader loader) {
        SEGMENT$clGetDeviceIDsFromD3D10KHR = loader.apply("clGetDeviceIDsFromD3D10KHR");
        HANDLE$clGetDeviceIDsFromD3D10KHR = RawFunctionLoader.link(SEGMENT$clGetDeviceIDsFromD3D10KHR, Descriptors.DESCRIPTOR$clGetDeviceIDsFromD3D10KHR);
        SEGMENT$clCreateFromD3D10BufferKHR = loader.apply("clCreateFromD3D10BufferKHR");
        HANDLE$clCreateFromD3D10BufferKHR = RawFunctionLoader.link(SEGMENT$clCreateFromD3D10BufferKHR, Descriptors.DESCRIPTOR$clCreateFromD3D10BufferKHR);
        SEGMENT$clCreateFromD3D10Texture2DKHR = loader.apply("clCreateFromD3D10Texture2DKHR");
        HANDLE$clCreateFromD3D10Texture2DKHR = RawFunctionLoader.link(SEGMENT$clCreateFromD3D10Texture2DKHR, Descriptors.DESCRIPTOR$clCreateFromD3D10Texture2DKHR);
        SEGMENT$clCreateFromD3D10Texture3DKHR = loader.apply("clCreateFromD3D10Texture3DKHR");
        HANDLE$clCreateFromD3D10Texture3DKHR = RawFunctionLoader.link(SEGMENT$clCreateFromD3D10Texture3DKHR, Descriptors.DESCRIPTOR$clCreateFromD3D10Texture3DKHR);
        SEGMENT$clEnqueueAcquireD3D10ObjectsKHR = loader.apply("clEnqueueAcquireD3D10ObjectsKHR");
        HANDLE$clEnqueueAcquireD3D10ObjectsKHR = RawFunctionLoader.link(SEGMENT$clEnqueueAcquireD3D10ObjectsKHR, Descriptors.DESCRIPTOR$clEnqueueAcquireD3D10ObjectsKHR);
        SEGMENT$clEnqueueReleaseD3D10ObjectsKHR = loader.apply("clEnqueueReleaseD3D10ObjectsKHR");
        HANDLE$clEnqueueReleaseD3D10ObjectsKHR = RawFunctionLoader.link(SEGMENT$clEnqueueReleaseD3D10ObjectsKHR, Descriptors.DESCRIPTOR$clEnqueueReleaseD3D10ObjectsKHR);
        SEGMENT$clGetDeviceIDsFromD3D11KHR = loader.apply("clGetDeviceIDsFromD3D11KHR");
        HANDLE$clGetDeviceIDsFromD3D11KHR = RawFunctionLoader.link(SEGMENT$clGetDeviceIDsFromD3D11KHR, Descriptors.DESCRIPTOR$clGetDeviceIDsFromD3D11KHR);
        SEGMENT$clCreateFromD3D11BufferKHR = loader.apply("clCreateFromD3D11BufferKHR");
        HANDLE$clCreateFromD3D11BufferKHR = RawFunctionLoader.link(SEGMENT$clCreateFromD3D11BufferKHR, Descriptors.DESCRIPTOR$clCreateFromD3D11BufferKHR);
        SEGMENT$clCreateFromD3D11Texture2DKHR = loader.apply("clCreateFromD3D11Texture2DKHR");
        HANDLE$clCreateFromD3D11Texture2DKHR = RawFunctionLoader.link(SEGMENT$clCreateFromD3D11Texture2DKHR, Descriptors.DESCRIPTOR$clCreateFromD3D11Texture2DKHR);
        SEGMENT$clCreateFromD3D11Texture3DKHR = loader.apply("clCreateFromD3D11Texture3DKHR");
        HANDLE$clCreateFromD3D11Texture3DKHR = RawFunctionLoader.link(SEGMENT$clCreateFromD3D11Texture3DKHR, Descriptors.DESCRIPTOR$clCreateFromD3D11Texture3DKHR);
        SEGMENT$clEnqueueAcquireD3D11ObjectsKHR = loader.apply("clEnqueueAcquireD3D11ObjectsKHR");
        HANDLE$clEnqueueAcquireD3D11ObjectsKHR = RawFunctionLoader.link(SEGMENT$clEnqueueAcquireD3D11ObjectsKHR, Descriptors.DESCRIPTOR$clEnqueueAcquireD3D11ObjectsKHR);
        SEGMENT$clEnqueueReleaseD3D11ObjectsKHR = loader.apply("clEnqueueReleaseD3D11ObjectsKHR");
        HANDLE$clEnqueueReleaseD3D11ObjectsKHR = RawFunctionLoader.link(SEGMENT$clEnqueueReleaseD3D11ObjectsKHR, Descriptors.DESCRIPTOR$clEnqueueReleaseD3D11ObjectsKHR);
        SEGMENT$clGetDeviceIDsFromDX9MediaAdapterKHR = loader.apply("clGetDeviceIDsFromDX9MediaAdapterKHR");
        HANDLE$clGetDeviceIDsFromDX9MediaAdapterKHR = RawFunctionLoader.link(SEGMENT$clGetDeviceIDsFromDX9MediaAdapterKHR, Descriptors.DESCRIPTOR$clGetDeviceIDsFromDX9MediaAdapterKHR);
        SEGMENT$clCreateFromDX9MediaSurfaceKHR = loader.apply("clCreateFromDX9MediaSurfaceKHR");
        HANDLE$clCreateFromDX9MediaSurfaceKHR = RawFunctionLoader.link(SEGMENT$clCreateFromDX9MediaSurfaceKHR, Descriptors.DESCRIPTOR$clCreateFromDX9MediaSurfaceKHR);
        SEGMENT$clEnqueueAcquireDX9MediaSurfacesKHR = loader.apply("clEnqueueAcquireDX9MediaSurfacesKHR");
        HANDLE$clEnqueueAcquireDX9MediaSurfacesKHR = RawFunctionLoader.link(SEGMENT$clEnqueueAcquireDX9MediaSurfacesKHR, Descriptors.DESCRIPTOR$clEnqueueAcquireDX9MediaSurfacesKHR);
        SEGMENT$clEnqueueReleaseDX9MediaSurfacesKHR = loader.apply("clEnqueueReleaseDX9MediaSurfacesKHR");
        HANDLE$clEnqueueReleaseDX9MediaSurfacesKHR = RawFunctionLoader.link(SEGMENT$clEnqueueReleaseDX9MediaSurfacesKHR, Descriptors.DESCRIPTOR$clEnqueueReleaseDX9MediaSurfacesKHR);
        SEGMENT$clGetDeviceIDsFromDX9INTEL = loader.apply("clGetDeviceIDsFromDX9INTEL");
        HANDLE$clGetDeviceIDsFromDX9INTEL = RawFunctionLoader.link(SEGMENT$clGetDeviceIDsFromDX9INTEL, Descriptors.DESCRIPTOR$clGetDeviceIDsFromDX9INTEL);
        SEGMENT$clCreateFromDX9MediaSurfaceINTEL = loader.apply("clCreateFromDX9MediaSurfaceINTEL");
        HANDLE$clCreateFromDX9MediaSurfaceINTEL = RawFunctionLoader.link(SEGMENT$clCreateFromDX9MediaSurfaceINTEL, Descriptors.DESCRIPTOR$clCreateFromDX9MediaSurfaceINTEL);
        SEGMENT$clEnqueueAcquireDX9ObjectsINTEL = loader.apply("clEnqueueAcquireDX9ObjectsINTEL");
        HANDLE$clEnqueueAcquireDX9ObjectsINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueAcquireDX9ObjectsINTEL, Descriptors.DESCRIPTOR$clEnqueueAcquireDX9ObjectsINTEL);
        SEGMENT$clEnqueueReleaseDX9ObjectsINTEL = loader.apply("clEnqueueReleaseDX9ObjectsINTEL");
        HANDLE$clEnqueueReleaseDX9ObjectsINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueReleaseDX9ObjectsINTEL, Descriptors.DESCRIPTOR$clEnqueueReleaseDX9ObjectsINTEL);
        SEGMENT$clCreateEventFromEGLSyncKHR = loader.apply("clCreateEventFromEGLSyncKHR");
        HANDLE$clCreateEventFromEGLSyncKHR = RawFunctionLoader.link(SEGMENT$clCreateEventFromEGLSyncKHR, Descriptors.DESCRIPTOR$clCreateEventFromEGLSyncKHR);
        SEGMENT$clCreateFromEGLImageKHR = loader.apply("clCreateFromEGLImageKHR");
        HANDLE$clCreateFromEGLImageKHR = RawFunctionLoader.link(SEGMENT$clCreateFromEGLImageKHR, Descriptors.DESCRIPTOR$clCreateFromEGLImageKHR);
        SEGMENT$clEnqueueAcquireEGLObjectsKHR = loader.apply("clEnqueueAcquireEGLObjectsKHR");
        HANDLE$clEnqueueAcquireEGLObjectsKHR = RawFunctionLoader.link(SEGMENT$clEnqueueAcquireEGLObjectsKHR, Descriptors.DESCRIPTOR$clEnqueueAcquireEGLObjectsKHR);
        SEGMENT$clEnqueueReleaseEGLObjectsKHR = loader.apply("clEnqueueReleaseEGLObjectsKHR");
        HANDLE$clEnqueueReleaseEGLObjectsKHR = RawFunctionLoader.link(SEGMENT$clEnqueueReleaseEGLObjectsKHR, Descriptors.DESCRIPTOR$clEnqueueReleaseEGLObjectsKHR);
        SEGMENT$clLogMessagesToSystemLogAPPLE = loader.apply("clLogMessagesToSystemLogAPPLE");
        HANDLE$clLogMessagesToSystemLogAPPLE = RawFunctionLoader.link(SEGMENT$clLogMessagesToSystemLogAPPLE, Descriptors.DESCRIPTOR$clLogMessagesToSystemLogAPPLE);
        SEGMENT$clLogMessagesToStdoutAPPLE = loader.apply("clLogMessagesToStdoutAPPLE");
        HANDLE$clLogMessagesToStdoutAPPLE = RawFunctionLoader.link(SEGMENT$clLogMessagesToStdoutAPPLE, Descriptors.DESCRIPTOR$clLogMessagesToStdoutAPPLE);
        SEGMENT$clLogMessagesToStderrAPPLE = loader.apply("clLogMessagesToStderrAPPLE");
        HANDLE$clLogMessagesToStderrAPPLE = RawFunctionLoader.link(SEGMENT$clLogMessagesToStderrAPPLE, Descriptors.DESCRIPTOR$clLogMessagesToStderrAPPLE);
        SEGMENT$clIcdGetPlatformIDsKHR = loader.apply("clIcdGetPlatformIDsKHR");
        HANDLE$clIcdGetPlatformIDsKHR = RawFunctionLoader.link(SEGMENT$clIcdGetPlatformIDsKHR, Descriptors.DESCRIPTOR$clIcdGetPlatformIDsKHR);
        SEGMENT$clIcdGetFunctionAddressForPlatformKHR = loader.apply("clIcdGetFunctionAddressForPlatformKHR");
        HANDLE$clIcdGetFunctionAddressForPlatformKHR = RawFunctionLoader.link(SEGMENT$clIcdGetFunctionAddressForPlatformKHR, Descriptors.DESCRIPTOR$clIcdGetFunctionAddressForPlatformKHR);
        SEGMENT$clIcdSetPlatformDispatchDataKHR = loader.apply("clIcdSetPlatformDispatchDataKHR");
        HANDLE$clIcdSetPlatformDispatchDataKHR = RawFunctionLoader.link(SEGMENT$clIcdSetPlatformDispatchDataKHR, Descriptors.DESCRIPTOR$clIcdSetPlatformDispatchDataKHR);
        SEGMENT$clCreateProgramWithILKHR = loader.apply("clCreateProgramWithILKHR");
        HANDLE$clCreateProgramWithILKHR = RawFunctionLoader.link(SEGMENT$clCreateProgramWithILKHR, Descriptors.DESCRIPTOR$clCreateProgramWithILKHR);
        SEGMENT$clTerminateContextKHR = loader.apply("clTerminateContextKHR");
        HANDLE$clTerminateContextKHR = RawFunctionLoader.link(SEGMENT$clTerminateContextKHR, Descriptors.DESCRIPTOR$clTerminateContextKHR);
        SEGMENT$clCreateCommandQueueWithPropertiesKHR = loader.apply("clCreateCommandQueueWithPropertiesKHR");
        HANDLE$clCreateCommandQueueWithPropertiesKHR = RawFunctionLoader.link(SEGMENT$clCreateCommandQueueWithPropertiesKHR, Descriptors.DESCRIPTOR$clCreateCommandQueueWithPropertiesKHR);
        SEGMENT$clReleaseDeviceEXT = loader.apply("clReleaseDeviceEXT");
        HANDLE$clReleaseDeviceEXT = RawFunctionLoader.link(SEGMENT$clReleaseDeviceEXT, Descriptors.DESCRIPTOR$clReleaseDeviceEXT);
        SEGMENT$clRetainDeviceEXT = loader.apply("clRetainDeviceEXT");
        HANDLE$clRetainDeviceEXT = RawFunctionLoader.link(SEGMENT$clRetainDeviceEXT, Descriptors.DESCRIPTOR$clRetainDeviceEXT);
        SEGMENT$clCreateSubDevicesEXT = loader.apply("clCreateSubDevicesEXT");
        HANDLE$clCreateSubDevicesEXT = RawFunctionLoader.link(SEGMENT$clCreateSubDevicesEXT, Descriptors.DESCRIPTOR$clCreateSubDevicesEXT);
        SEGMENT$clEnqueueMigrateMemObjectEXT = loader.apply("clEnqueueMigrateMemObjectEXT");
        HANDLE$clEnqueueMigrateMemObjectEXT = RawFunctionLoader.link(SEGMENT$clEnqueueMigrateMemObjectEXT, Descriptors.DESCRIPTOR$clEnqueueMigrateMemObjectEXT);
        SEGMENT$clGetDeviceImageInfoQCOM = loader.apply("clGetDeviceImageInfoQCOM");
        HANDLE$clGetDeviceImageInfoQCOM = RawFunctionLoader.link(SEGMENT$clGetDeviceImageInfoQCOM, Descriptors.DESCRIPTOR$clGetDeviceImageInfoQCOM);
        SEGMENT$clEnqueueAcquireGrallocObjectsIMG = loader.apply("clEnqueueAcquireGrallocObjectsIMG");
        HANDLE$clEnqueueAcquireGrallocObjectsIMG = RawFunctionLoader.link(SEGMENT$clEnqueueAcquireGrallocObjectsIMG, Descriptors.DESCRIPTOR$clEnqueueAcquireGrallocObjectsIMG);
        SEGMENT$clEnqueueGenerateMipmapIMG = loader.apply("clEnqueueGenerateMipmapIMG");
        HANDLE$clEnqueueGenerateMipmapIMG = RawFunctionLoader.link(SEGMENT$clEnqueueGenerateMipmapIMG, Descriptors.DESCRIPTOR$clEnqueueGenerateMipmapIMG);
        SEGMENT$clEnqueueReleaseGrallocObjectsIMG = loader.apply("clEnqueueReleaseGrallocObjectsIMG");
        HANDLE$clEnqueueReleaseGrallocObjectsIMG = RawFunctionLoader.link(SEGMENT$clEnqueueReleaseGrallocObjectsIMG, Descriptors.DESCRIPTOR$clEnqueueReleaseGrallocObjectsIMG);
        SEGMENT$clGetKernelSubGroupInfoKHR = loader.apply("clGetKernelSubGroupInfoKHR");
        HANDLE$clGetKernelSubGroupInfoKHR = RawFunctionLoader.link(SEGMENT$clGetKernelSubGroupInfoKHR, Descriptors.DESCRIPTOR$clGetKernelSubGroupInfoKHR);
        SEGMENT$clGetKernelSuggestedLocalWorkSizeKHR = loader.apply("clGetKernelSuggestedLocalWorkSizeKHR");
        HANDLE$clGetKernelSuggestedLocalWorkSizeKHR = RawFunctionLoader.link(SEGMENT$clGetKernelSuggestedLocalWorkSizeKHR, Descriptors.DESCRIPTOR$clGetKernelSuggestedLocalWorkSizeKHR);
        SEGMENT$clCreateSemaphoreWithPropertiesKHR = loader.apply("clCreateSemaphoreWithPropertiesKHR");
        HANDLE$clCreateSemaphoreWithPropertiesKHR = RawFunctionLoader.link(SEGMENT$clCreateSemaphoreWithPropertiesKHR, Descriptors.DESCRIPTOR$clCreateSemaphoreWithPropertiesKHR);
        SEGMENT$clEnqueueWaitSemaphoresKHR = loader.apply("clEnqueueWaitSemaphoresKHR");
        HANDLE$clEnqueueWaitSemaphoresKHR = RawFunctionLoader.link(SEGMENT$clEnqueueWaitSemaphoresKHR, Descriptors.DESCRIPTOR$clEnqueueWaitSemaphoresKHR);
        SEGMENT$clEnqueueSignalSemaphoresKHR = loader.apply("clEnqueueSignalSemaphoresKHR");
        HANDLE$clEnqueueSignalSemaphoresKHR = RawFunctionLoader.link(SEGMENT$clEnqueueSignalSemaphoresKHR, Descriptors.DESCRIPTOR$clEnqueueSignalSemaphoresKHR);
        SEGMENT$clGetSemaphoreInfoKHR = loader.apply("clGetSemaphoreInfoKHR");
        HANDLE$clGetSemaphoreInfoKHR = RawFunctionLoader.link(SEGMENT$clGetSemaphoreInfoKHR, Descriptors.DESCRIPTOR$clGetSemaphoreInfoKHR);
        SEGMENT$clReleaseSemaphoreKHR = loader.apply("clReleaseSemaphoreKHR");
        HANDLE$clReleaseSemaphoreKHR = RawFunctionLoader.link(SEGMENT$clReleaseSemaphoreKHR, Descriptors.DESCRIPTOR$clReleaseSemaphoreKHR);
        SEGMENT$clRetainSemaphoreKHR = loader.apply("clRetainSemaphoreKHR");
        HANDLE$clRetainSemaphoreKHR = RawFunctionLoader.link(SEGMENT$clRetainSemaphoreKHR, Descriptors.DESCRIPTOR$clRetainSemaphoreKHR);
        SEGMENT$clGetSemaphoreHandleForTypeKHR = loader.apply("clGetSemaphoreHandleForTypeKHR");
        HANDLE$clGetSemaphoreHandleForTypeKHR = RawFunctionLoader.link(SEGMENT$clGetSemaphoreHandleForTypeKHR, Descriptors.DESCRIPTOR$clGetSemaphoreHandleForTypeKHR);
        SEGMENT$clReImportSemaphoreSyncFdKHR = loader.apply("clReImportSemaphoreSyncFdKHR");
        HANDLE$clReImportSemaphoreSyncFdKHR = RawFunctionLoader.link(SEGMENT$clReImportSemaphoreSyncFdKHR, Descriptors.DESCRIPTOR$clReImportSemaphoreSyncFdKHR);
        SEGMENT$clEnqueueAcquireExternalMemObjectsKHR = loader.apply("clEnqueueAcquireExternalMemObjectsKHR");
        HANDLE$clEnqueueAcquireExternalMemObjectsKHR = RawFunctionLoader.link(SEGMENT$clEnqueueAcquireExternalMemObjectsKHR, Descriptors.DESCRIPTOR$clEnqueueAcquireExternalMemObjectsKHR);
        SEGMENT$clEnqueueReleaseExternalMemObjectsKHR = loader.apply("clEnqueueReleaseExternalMemObjectsKHR");
        HANDLE$clEnqueueReleaseExternalMemObjectsKHR = RawFunctionLoader.link(SEGMENT$clEnqueueReleaseExternalMemObjectsKHR, Descriptors.DESCRIPTOR$clEnqueueReleaseExternalMemObjectsKHR);
        SEGMENT$clImportMemoryARM = loader.apply("clImportMemoryARM");
        HANDLE$clImportMemoryARM = RawFunctionLoader.link(SEGMENT$clImportMemoryARM, Descriptors.DESCRIPTOR$clImportMemoryARM);
        SEGMENT$clSVMAllocARM = loader.apply("clSVMAllocARM");
        HANDLE$clSVMAllocARM = RawFunctionLoader.link(SEGMENT$clSVMAllocARM, Descriptors.DESCRIPTOR$clSVMAllocARM);
        SEGMENT$clSVMFreeARM = loader.apply("clSVMFreeARM");
        HANDLE$clSVMFreeARM = RawFunctionLoader.link(SEGMENT$clSVMFreeARM, Descriptors.DESCRIPTOR$clSVMFreeARM);
        SEGMENT$clEnqueueSVMFreeARM = loader.apply("clEnqueueSVMFreeARM");
        HANDLE$clEnqueueSVMFreeARM = RawFunctionLoader.link(SEGMENT$clEnqueueSVMFreeARM, Descriptors.DESCRIPTOR$clEnqueueSVMFreeARM);
        SEGMENT$clEnqueueSVMMemcpyARM = loader.apply("clEnqueueSVMMemcpyARM");
        HANDLE$clEnqueueSVMMemcpyARM = RawFunctionLoader.link(SEGMENT$clEnqueueSVMMemcpyARM, Descriptors.DESCRIPTOR$clEnqueueSVMMemcpyARM);
        SEGMENT$clEnqueueSVMMemFillARM = loader.apply("clEnqueueSVMMemFillARM");
        HANDLE$clEnqueueSVMMemFillARM = RawFunctionLoader.link(SEGMENT$clEnqueueSVMMemFillARM, Descriptors.DESCRIPTOR$clEnqueueSVMMemFillARM);
        SEGMENT$clEnqueueSVMMapARM = loader.apply("clEnqueueSVMMapARM");
        HANDLE$clEnqueueSVMMapARM = RawFunctionLoader.link(SEGMENT$clEnqueueSVMMapARM, Descriptors.DESCRIPTOR$clEnqueueSVMMapARM);
        SEGMENT$clEnqueueSVMUnmapARM = loader.apply("clEnqueueSVMUnmapARM");
        HANDLE$clEnqueueSVMUnmapARM = RawFunctionLoader.link(SEGMENT$clEnqueueSVMUnmapARM, Descriptors.DESCRIPTOR$clEnqueueSVMUnmapARM);
        SEGMENT$clSetKernelArgSVMPointerARM = loader.apply("clSetKernelArgSVMPointerARM");
        HANDLE$clSetKernelArgSVMPointerARM = RawFunctionLoader.link(SEGMENT$clSetKernelArgSVMPointerARM, Descriptors.DESCRIPTOR$clSetKernelArgSVMPointerARM);
        SEGMENT$clSetKernelExecInfoARM = loader.apply("clSetKernelExecInfoARM");
        HANDLE$clSetKernelExecInfoARM = RawFunctionLoader.link(SEGMENT$clSetKernelExecInfoARM, Descriptors.DESCRIPTOR$clSetKernelExecInfoARM);
        SEGMENT$clCreateAcceleratorINTEL = loader.apply("clCreateAcceleratorINTEL");
        HANDLE$clCreateAcceleratorINTEL = RawFunctionLoader.link(SEGMENT$clCreateAcceleratorINTEL, Descriptors.DESCRIPTOR$clCreateAcceleratorINTEL);
        SEGMENT$clGetAcceleratorInfoINTEL = loader.apply("clGetAcceleratorInfoINTEL");
        HANDLE$clGetAcceleratorInfoINTEL = RawFunctionLoader.link(SEGMENT$clGetAcceleratorInfoINTEL, Descriptors.DESCRIPTOR$clGetAcceleratorInfoINTEL);
        SEGMENT$clRetainAcceleratorINTEL = loader.apply("clRetainAcceleratorINTEL");
        HANDLE$clRetainAcceleratorINTEL = RawFunctionLoader.link(SEGMENT$clRetainAcceleratorINTEL, Descriptors.DESCRIPTOR$clRetainAcceleratorINTEL);
        SEGMENT$clReleaseAcceleratorINTEL = loader.apply("clReleaseAcceleratorINTEL");
        HANDLE$clReleaseAcceleratorINTEL = RawFunctionLoader.link(SEGMENT$clReleaseAcceleratorINTEL, Descriptors.DESCRIPTOR$clReleaseAcceleratorINTEL);
        SEGMENT$clCreateEventFromGLsyncKHR = loader.apply("clCreateEventFromGLsyncKHR");
        HANDLE$clCreateEventFromGLsyncKHR = RawFunctionLoader.link(SEGMENT$clCreateEventFromGLsyncKHR, Descriptors.DESCRIPTOR$clCreateEventFromGLsyncKHR);
        SEGMENT$clGetGLContextInfoKHR = loader.apply("clGetGLContextInfoKHR");
        HANDLE$clGetGLContextInfoKHR = RawFunctionLoader.link(SEGMENT$clGetGLContextInfoKHR, Descriptors.DESCRIPTOR$clGetGLContextInfoKHR);
        SEGMENT$clCreateFromGLBuffer = loader.apply("clCreateFromGLBuffer");
        HANDLE$clCreateFromGLBuffer = RawFunctionLoader.link(SEGMENT$clCreateFromGLBuffer, Descriptors.DESCRIPTOR$clCreateFromGLBuffer);
        SEGMENT$clCreateFromGLTexture = loader.apply("clCreateFromGLTexture");
        HANDLE$clCreateFromGLTexture = RawFunctionLoader.link(SEGMENT$clCreateFromGLTexture, Descriptors.DESCRIPTOR$clCreateFromGLTexture);
        SEGMENT$clCreateFromGLRenderbuffer = loader.apply("clCreateFromGLRenderbuffer");
        HANDLE$clCreateFromGLRenderbuffer = RawFunctionLoader.link(SEGMENT$clCreateFromGLRenderbuffer, Descriptors.DESCRIPTOR$clCreateFromGLRenderbuffer);
        SEGMENT$clGetGLObjectInfo = loader.apply("clGetGLObjectInfo");
        HANDLE$clGetGLObjectInfo = RawFunctionLoader.link(SEGMENT$clGetGLObjectInfo, Descriptors.DESCRIPTOR$clGetGLObjectInfo);
        SEGMENT$clGetGLTextureInfo = loader.apply("clGetGLTextureInfo");
        HANDLE$clGetGLTextureInfo = RawFunctionLoader.link(SEGMENT$clGetGLTextureInfo, Descriptors.DESCRIPTOR$clGetGLTextureInfo);
        SEGMENT$clEnqueueAcquireGLObjects = loader.apply("clEnqueueAcquireGLObjects");
        HANDLE$clEnqueueAcquireGLObjects = RawFunctionLoader.link(SEGMENT$clEnqueueAcquireGLObjects, Descriptors.DESCRIPTOR$clEnqueueAcquireGLObjects);
        SEGMENT$clEnqueueReleaseGLObjects = loader.apply("clEnqueueReleaseGLObjects");
        HANDLE$clEnqueueReleaseGLObjects = RawFunctionLoader.link(SEGMENT$clEnqueueReleaseGLObjects, Descriptors.DESCRIPTOR$clEnqueueReleaseGLObjects);
        SEGMENT$clCreateFromGLTexture2D = loader.apply("clCreateFromGLTexture2D");
        HANDLE$clCreateFromGLTexture2D = RawFunctionLoader.link(SEGMENT$clCreateFromGLTexture2D, Descriptors.DESCRIPTOR$clCreateFromGLTexture2D);
        SEGMENT$clCreateFromGLTexture3D = loader.apply("clCreateFromGLTexture3D");
        HANDLE$clCreateFromGLTexture3D = RawFunctionLoader.link(SEGMENT$clCreateFromGLTexture3D, Descriptors.DESCRIPTOR$clCreateFromGLTexture3D);
        SEGMENT$clGetDeviceIDsFromVA_APIMediaAdapterINTEL = loader.apply("clGetDeviceIDsFromVA_APIMediaAdapterINTEL");
        HANDLE$clGetDeviceIDsFromVA_APIMediaAdapterINTEL = RawFunctionLoader.link(SEGMENT$clGetDeviceIDsFromVA_APIMediaAdapterINTEL, Descriptors.DESCRIPTOR$clGetDeviceIDsFromVA_APIMediaAdapterINTEL);
        SEGMENT$clCreateFromVA_APIMediaSurfaceINTEL = loader.apply("clCreateFromVA_APIMediaSurfaceINTEL");
        HANDLE$clCreateFromVA_APIMediaSurfaceINTEL = RawFunctionLoader.link(SEGMENT$clCreateFromVA_APIMediaSurfaceINTEL, Descriptors.DESCRIPTOR$clCreateFromVA_APIMediaSurfaceINTEL);
        SEGMENT$clEnqueueAcquireVA_APIMediaSurfacesINTEL = loader.apply("clEnqueueAcquireVA_APIMediaSurfacesINTEL");
        HANDLE$clEnqueueAcquireVA_APIMediaSurfacesINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueAcquireVA_APIMediaSurfacesINTEL, Descriptors.DESCRIPTOR$clEnqueueAcquireVA_APIMediaSurfacesINTEL);
        SEGMENT$clEnqueueReleaseVA_APIMediaSurfacesINTEL = loader.apply("clEnqueueReleaseVA_APIMediaSurfacesINTEL");
        HANDLE$clEnqueueReleaseVA_APIMediaSurfacesINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueReleaseVA_APIMediaSurfacesINTEL, Descriptors.DESCRIPTOR$clEnqueueReleaseVA_APIMediaSurfacesINTEL);
        SEGMENT$clHostMemAllocINTEL = loader.apply("clHostMemAllocINTEL");
        HANDLE$clHostMemAllocINTEL = RawFunctionLoader.link(SEGMENT$clHostMemAllocINTEL, Descriptors.DESCRIPTOR$clHostMemAllocINTEL);
        SEGMENT$clDeviceMemAllocINTEL = loader.apply("clDeviceMemAllocINTEL");
        HANDLE$clDeviceMemAllocINTEL = RawFunctionLoader.link(SEGMENT$clDeviceMemAllocINTEL, Descriptors.DESCRIPTOR$clDeviceMemAllocINTEL);
        SEGMENT$clSharedMemAllocINTEL = loader.apply("clSharedMemAllocINTEL");
        HANDLE$clSharedMemAllocINTEL = RawFunctionLoader.link(SEGMENT$clSharedMemAllocINTEL, Descriptors.DESCRIPTOR$clSharedMemAllocINTEL);
        SEGMENT$clMemFreeINTEL = loader.apply("clMemFreeINTEL");
        HANDLE$clMemFreeINTEL = RawFunctionLoader.link(SEGMENT$clMemFreeINTEL, Descriptors.DESCRIPTOR$clMemFreeINTEL);
        SEGMENT$clMemBlockingFreeINTEL = loader.apply("clMemBlockingFreeINTEL");
        HANDLE$clMemBlockingFreeINTEL = RawFunctionLoader.link(SEGMENT$clMemBlockingFreeINTEL, Descriptors.DESCRIPTOR$clMemBlockingFreeINTEL);
        SEGMENT$clGetMemAllocInfoINTEL = loader.apply("clGetMemAllocInfoINTEL");
        HANDLE$clGetMemAllocInfoINTEL = RawFunctionLoader.link(SEGMENT$clGetMemAllocInfoINTEL, Descriptors.DESCRIPTOR$clGetMemAllocInfoINTEL);
        SEGMENT$clSetKernelArgMemPointerINTEL = loader.apply("clSetKernelArgMemPointerINTEL");
        HANDLE$clSetKernelArgMemPointerINTEL = RawFunctionLoader.link(SEGMENT$clSetKernelArgMemPointerINTEL, Descriptors.DESCRIPTOR$clSetKernelArgMemPointerINTEL);
        SEGMENT$clEnqueueMemsetINTEL = loader.apply("clEnqueueMemsetINTEL");
        HANDLE$clEnqueueMemsetINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueMemsetINTEL, Descriptors.DESCRIPTOR$clEnqueueMemsetINTEL);
        SEGMENT$clEnqueueMemFillINTEL = loader.apply("clEnqueueMemFillINTEL");
        HANDLE$clEnqueueMemFillINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueMemFillINTEL, Descriptors.DESCRIPTOR$clEnqueueMemFillINTEL);
        SEGMENT$clEnqueueMemcpyINTEL = loader.apply("clEnqueueMemcpyINTEL");
        HANDLE$clEnqueueMemcpyINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueMemcpyINTEL, Descriptors.DESCRIPTOR$clEnqueueMemcpyINTEL);
        SEGMENT$clEnqueueMigrateMemINTEL = loader.apply("clEnqueueMigrateMemINTEL");
        HANDLE$clEnqueueMigrateMemINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueMigrateMemINTEL, Descriptors.DESCRIPTOR$clEnqueueMigrateMemINTEL);
        SEGMENT$clEnqueueMemAdviseINTEL = loader.apply("clEnqueueMemAdviseINTEL");
        HANDLE$clEnqueueMemAdviseINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueMemAdviseINTEL, Descriptors.DESCRIPTOR$clEnqueueMemAdviseINTEL);
        SEGMENT$clCreateBufferWithPropertiesINTEL = loader.apply("clCreateBufferWithPropertiesINTEL");
        HANDLE$clCreateBufferWithPropertiesINTEL = RawFunctionLoader.link(SEGMENT$clCreateBufferWithPropertiesINTEL, Descriptors.DESCRIPTOR$clCreateBufferWithPropertiesINTEL);
        SEGMENT$clCreateCommandBufferKHR = loader.apply("clCreateCommandBufferKHR");
        HANDLE$clCreateCommandBufferKHR = RawFunctionLoader.link(SEGMENT$clCreateCommandBufferKHR, Descriptors.DESCRIPTOR$clCreateCommandBufferKHR);
        SEGMENT$clFinalizeCommandBufferKHR = loader.apply("clFinalizeCommandBufferKHR");
        HANDLE$clFinalizeCommandBufferKHR = RawFunctionLoader.link(SEGMENT$clFinalizeCommandBufferKHR, Descriptors.DESCRIPTOR$clFinalizeCommandBufferKHR);
        SEGMENT$clRetainCommandBufferKHR = loader.apply("clRetainCommandBufferKHR");
        HANDLE$clRetainCommandBufferKHR = RawFunctionLoader.link(SEGMENT$clRetainCommandBufferKHR, Descriptors.DESCRIPTOR$clRetainCommandBufferKHR);
        SEGMENT$clReleaseCommandBufferKHR = loader.apply("clReleaseCommandBufferKHR");
        HANDLE$clReleaseCommandBufferKHR = RawFunctionLoader.link(SEGMENT$clReleaseCommandBufferKHR, Descriptors.DESCRIPTOR$clReleaseCommandBufferKHR);
        SEGMENT$clEnqueueCommandBufferKHR = loader.apply("clEnqueueCommandBufferKHR");
        HANDLE$clEnqueueCommandBufferKHR = RawFunctionLoader.link(SEGMENT$clEnqueueCommandBufferKHR, Descriptors.DESCRIPTOR$clEnqueueCommandBufferKHR);
        SEGMENT$clCommandBarrierWithWaitListKHR = loader.apply("clCommandBarrierWithWaitListKHR");
        HANDLE$clCommandBarrierWithWaitListKHR = RawFunctionLoader.link(SEGMENT$clCommandBarrierWithWaitListKHR, Descriptors.DESCRIPTOR$clCommandBarrierWithWaitListKHR);
        SEGMENT$clCommandCopyBufferKHR = loader.apply("clCommandCopyBufferKHR");
        HANDLE$clCommandCopyBufferKHR = RawFunctionLoader.link(SEGMENT$clCommandCopyBufferKHR, Descriptors.DESCRIPTOR$clCommandCopyBufferKHR);
        SEGMENT$clCommandCopyBufferRectKHR = loader.apply("clCommandCopyBufferRectKHR");
        HANDLE$clCommandCopyBufferRectKHR = RawFunctionLoader.link(SEGMENT$clCommandCopyBufferRectKHR, Descriptors.DESCRIPTOR$clCommandCopyBufferRectKHR);
        SEGMENT$clCommandCopyBufferToImageKHR = loader.apply("clCommandCopyBufferToImageKHR");
        HANDLE$clCommandCopyBufferToImageKHR = RawFunctionLoader.link(SEGMENT$clCommandCopyBufferToImageKHR, Descriptors.DESCRIPTOR$clCommandCopyBufferToImageKHR);
        SEGMENT$clCommandCopyImageKHR = loader.apply("clCommandCopyImageKHR");
        HANDLE$clCommandCopyImageKHR = RawFunctionLoader.link(SEGMENT$clCommandCopyImageKHR, Descriptors.DESCRIPTOR$clCommandCopyImageKHR);
        SEGMENT$clCommandCopyImageToBufferKHR = loader.apply("clCommandCopyImageToBufferKHR");
        HANDLE$clCommandCopyImageToBufferKHR = RawFunctionLoader.link(SEGMENT$clCommandCopyImageToBufferKHR, Descriptors.DESCRIPTOR$clCommandCopyImageToBufferKHR);
        SEGMENT$clCommandFillBufferKHR = loader.apply("clCommandFillBufferKHR");
        HANDLE$clCommandFillBufferKHR = RawFunctionLoader.link(SEGMENT$clCommandFillBufferKHR, Descriptors.DESCRIPTOR$clCommandFillBufferKHR);
        SEGMENT$clCommandFillImageKHR = loader.apply("clCommandFillImageKHR");
        HANDLE$clCommandFillImageKHR = RawFunctionLoader.link(SEGMENT$clCommandFillImageKHR, Descriptors.DESCRIPTOR$clCommandFillImageKHR);
        SEGMENT$clCommandNDRangeKernelKHR = loader.apply("clCommandNDRangeKernelKHR");
        HANDLE$clCommandNDRangeKernelKHR = RawFunctionLoader.link(SEGMENT$clCommandNDRangeKernelKHR, Descriptors.DESCRIPTOR$clCommandNDRangeKernelKHR);
        SEGMENT$clCommandSVMMemcpyKHR = loader.apply("clCommandSVMMemcpyKHR");
        HANDLE$clCommandSVMMemcpyKHR = RawFunctionLoader.link(SEGMENT$clCommandSVMMemcpyKHR, Descriptors.DESCRIPTOR$clCommandSVMMemcpyKHR);
        SEGMENT$clCommandSVMMemFillKHR = loader.apply("clCommandSVMMemFillKHR");
        HANDLE$clCommandSVMMemFillKHR = RawFunctionLoader.link(SEGMENT$clCommandSVMMemFillKHR, Descriptors.DESCRIPTOR$clCommandSVMMemFillKHR);
        SEGMENT$clGetCommandBufferInfoKHR = loader.apply("clGetCommandBufferInfoKHR");
        HANDLE$clGetCommandBufferInfoKHR = RawFunctionLoader.link(SEGMENT$clGetCommandBufferInfoKHR, Descriptors.DESCRIPTOR$clGetCommandBufferInfoKHR);
        SEGMENT$clUpdateMutableCommandsKHR = loader.apply("clUpdateMutableCommandsKHR");
        HANDLE$clUpdateMutableCommandsKHR = RawFunctionLoader.link(SEGMENT$clUpdateMutableCommandsKHR, Descriptors.DESCRIPTOR$clUpdateMutableCommandsKHR);
        SEGMENT$clGetMutableCommandInfoKHR = loader.apply("clGetMutableCommandInfoKHR");
        HANDLE$clGetMutableCommandInfoKHR = RawFunctionLoader.link(SEGMENT$clGetMutableCommandInfoKHR, Descriptors.DESCRIPTOR$clGetMutableCommandInfoKHR);
        SEGMENT$clRemapCommandBufferKHR = loader.apply("clRemapCommandBufferKHR");
        HANDLE$clRemapCommandBufferKHR = RawFunctionLoader.link(SEGMENT$clRemapCommandBufferKHR, Descriptors.DESCRIPTOR$clRemapCommandBufferKHR);
        SEGMENT$clSetContentSizeBufferPoCL = loader.apply("clSetContentSizeBufferPoCL");
        HANDLE$clSetContentSizeBufferPoCL = RawFunctionLoader.link(SEGMENT$clSetContentSizeBufferPoCL, Descriptors.DESCRIPTOR$clSetContentSizeBufferPoCL);
        SEGMENT$clGetPlatformIDs = loader.apply("clGetPlatformIDs");
        HANDLE$clGetPlatformIDs = RawFunctionLoader.link(SEGMENT$clGetPlatformIDs, Descriptors.DESCRIPTOR$clGetPlatformIDs);
        SEGMENT$clGetPlatformInfo = loader.apply("clGetPlatformInfo");
        HANDLE$clGetPlatformInfo = RawFunctionLoader.link(SEGMENT$clGetPlatformInfo, Descriptors.DESCRIPTOR$clGetPlatformInfo);
        SEGMENT$clGetDeviceIDs = loader.apply("clGetDeviceIDs");
        HANDLE$clGetDeviceIDs = RawFunctionLoader.link(SEGMENT$clGetDeviceIDs, Descriptors.DESCRIPTOR$clGetDeviceIDs);
        SEGMENT$clGetDeviceInfo = loader.apply("clGetDeviceInfo");
        HANDLE$clGetDeviceInfo = RawFunctionLoader.link(SEGMENT$clGetDeviceInfo, Descriptors.DESCRIPTOR$clGetDeviceInfo);
        SEGMENT$clCreateSubDevices = loader.apply("clCreateSubDevices");
        HANDLE$clCreateSubDevices = RawFunctionLoader.link(SEGMENT$clCreateSubDevices, Descriptors.DESCRIPTOR$clCreateSubDevices);
        SEGMENT$clRetainDevice = loader.apply("clRetainDevice");
        HANDLE$clRetainDevice = RawFunctionLoader.link(SEGMENT$clRetainDevice, Descriptors.DESCRIPTOR$clRetainDevice);
        SEGMENT$clReleaseDevice = loader.apply("clReleaseDevice");
        HANDLE$clReleaseDevice = RawFunctionLoader.link(SEGMENT$clReleaseDevice, Descriptors.DESCRIPTOR$clReleaseDevice);
        SEGMENT$clSetDefaultDeviceCommandQueue = loader.apply("clSetDefaultDeviceCommandQueue");
        HANDLE$clSetDefaultDeviceCommandQueue = RawFunctionLoader.link(SEGMENT$clSetDefaultDeviceCommandQueue, Descriptors.DESCRIPTOR$clSetDefaultDeviceCommandQueue);
        SEGMENT$clGetDeviceAndHostTimer = loader.apply("clGetDeviceAndHostTimer");
        HANDLE$clGetDeviceAndHostTimer = RawFunctionLoader.link(SEGMENT$clGetDeviceAndHostTimer, Descriptors.DESCRIPTOR$clGetDeviceAndHostTimer);
        SEGMENT$clGetHostTimer = loader.apply("clGetHostTimer");
        HANDLE$clGetHostTimer = RawFunctionLoader.link(SEGMENT$clGetHostTimer, Descriptors.DESCRIPTOR$clGetHostTimer);
        SEGMENT$clCreateContext = loader.apply("clCreateContext");
        HANDLE$clCreateContext = RawFunctionLoader.link(SEGMENT$clCreateContext, Descriptors.DESCRIPTOR$clCreateContext);
        SEGMENT$clCreateContextFromType = loader.apply("clCreateContextFromType");
        HANDLE$clCreateContextFromType = RawFunctionLoader.link(SEGMENT$clCreateContextFromType, Descriptors.DESCRIPTOR$clCreateContextFromType);
        SEGMENT$clRetainContext = loader.apply("clRetainContext");
        HANDLE$clRetainContext = RawFunctionLoader.link(SEGMENT$clRetainContext, Descriptors.DESCRIPTOR$clRetainContext);
        SEGMENT$clReleaseContext = loader.apply("clReleaseContext");
        HANDLE$clReleaseContext = RawFunctionLoader.link(SEGMENT$clReleaseContext, Descriptors.DESCRIPTOR$clReleaseContext);
        SEGMENT$clGetContextInfo = loader.apply("clGetContextInfo");
        HANDLE$clGetContextInfo = RawFunctionLoader.link(SEGMENT$clGetContextInfo, Descriptors.DESCRIPTOR$clGetContextInfo);
        SEGMENT$clSetContextDestructorCallback = loader.apply("clSetContextDestructorCallback");
        HANDLE$clSetContextDestructorCallback = RawFunctionLoader.link(SEGMENT$clSetContextDestructorCallback, Descriptors.DESCRIPTOR$clSetContextDestructorCallback);
        SEGMENT$clCreateCommandQueueWithProperties = loader.apply("clCreateCommandQueueWithProperties");
        HANDLE$clCreateCommandQueueWithProperties = RawFunctionLoader.link(SEGMENT$clCreateCommandQueueWithProperties, Descriptors.DESCRIPTOR$clCreateCommandQueueWithProperties);
        SEGMENT$clRetainCommandQueue = loader.apply("clRetainCommandQueue");
        HANDLE$clRetainCommandQueue = RawFunctionLoader.link(SEGMENT$clRetainCommandQueue, Descriptors.DESCRIPTOR$clRetainCommandQueue);
        SEGMENT$clReleaseCommandQueue = loader.apply("clReleaseCommandQueue");
        HANDLE$clReleaseCommandQueue = RawFunctionLoader.link(SEGMENT$clReleaseCommandQueue, Descriptors.DESCRIPTOR$clReleaseCommandQueue);
        SEGMENT$clGetCommandQueueInfo = loader.apply("clGetCommandQueueInfo");
        HANDLE$clGetCommandQueueInfo = RawFunctionLoader.link(SEGMENT$clGetCommandQueueInfo, Descriptors.DESCRIPTOR$clGetCommandQueueInfo);
        SEGMENT$clCreateBuffer = loader.apply("clCreateBuffer");
        HANDLE$clCreateBuffer = RawFunctionLoader.link(SEGMENT$clCreateBuffer, Descriptors.DESCRIPTOR$clCreateBuffer);
        SEGMENT$clCreateBufferWithProperties = loader.apply("clCreateBufferWithProperties");
        HANDLE$clCreateBufferWithProperties = RawFunctionLoader.link(SEGMENT$clCreateBufferWithProperties, Descriptors.DESCRIPTOR$clCreateBufferWithProperties);
        SEGMENT$clCreateSubBuffer = loader.apply("clCreateSubBuffer");
        HANDLE$clCreateSubBuffer = RawFunctionLoader.link(SEGMENT$clCreateSubBuffer, Descriptors.DESCRIPTOR$clCreateSubBuffer);
        SEGMENT$clCreateImage = loader.apply("clCreateImage");
        HANDLE$clCreateImage = RawFunctionLoader.link(SEGMENT$clCreateImage, Descriptors.DESCRIPTOR$clCreateImage);
        SEGMENT$clCreateImageWithProperties = loader.apply("clCreateImageWithProperties");
        HANDLE$clCreateImageWithProperties = RawFunctionLoader.link(SEGMENT$clCreateImageWithProperties, Descriptors.DESCRIPTOR$clCreateImageWithProperties);
        SEGMENT$clCreatePipe = loader.apply("clCreatePipe");
        HANDLE$clCreatePipe = RawFunctionLoader.link(SEGMENT$clCreatePipe, Descriptors.DESCRIPTOR$clCreatePipe);
        SEGMENT$clRetainMemObject = loader.apply("clRetainMemObject");
        HANDLE$clRetainMemObject = RawFunctionLoader.link(SEGMENT$clRetainMemObject, Descriptors.DESCRIPTOR$clRetainMemObject);
        SEGMENT$clReleaseMemObject = loader.apply("clReleaseMemObject");
        HANDLE$clReleaseMemObject = RawFunctionLoader.link(SEGMENT$clReleaseMemObject, Descriptors.DESCRIPTOR$clReleaseMemObject);
        SEGMENT$clGetSupportedImageFormats = loader.apply("clGetSupportedImageFormats");
        HANDLE$clGetSupportedImageFormats = RawFunctionLoader.link(SEGMENT$clGetSupportedImageFormats, Descriptors.DESCRIPTOR$clGetSupportedImageFormats);
        SEGMENT$clGetMemObjectInfo = loader.apply("clGetMemObjectInfo");
        HANDLE$clGetMemObjectInfo = RawFunctionLoader.link(SEGMENT$clGetMemObjectInfo, Descriptors.DESCRIPTOR$clGetMemObjectInfo);
        SEGMENT$clGetImageInfo = loader.apply("clGetImageInfo");
        HANDLE$clGetImageInfo = RawFunctionLoader.link(SEGMENT$clGetImageInfo, Descriptors.DESCRIPTOR$clGetImageInfo);
        SEGMENT$clGetPipeInfo = loader.apply("clGetPipeInfo");
        HANDLE$clGetPipeInfo = RawFunctionLoader.link(SEGMENT$clGetPipeInfo, Descriptors.DESCRIPTOR$clGetPipeInfo);
        SEGMENT$clSetMemObjectDestructorCallback = loader.apply("clSetMemObjectDestructorCallback");
        HANDLE$clSetMemObjectDestructorCallback = RawFunctionLoader.link(SEGMENT$clSetMemObjectDestructorCallback, Descriptors.DESCRIPTOR$clSetMemObjectDestructorCallback);
        SEGMENT$clSetMemObjectDestructorAPPLE = loader.apply("clSetMemObjectDestructorAPPLE");
        HANDLE$clSetMemObjectDestructorAPPLE = RawFunctionLoader.link(SEGMENT$clSetMemObjectDestructorAPPLE, Descriptors.DESCRIPTOR$clSetMemObjectDestructorAPPLE);
        SEGMENT$clSVMAlloc = loader.apply("clSVMAlloc");
        HANDLE$clSVMAlloc = RawFunctionLoader.link(SEGMENT$clSVMAlloc, Descriptors.DESCRIPTOR$clSVMAlloc);
        SEGMENT$clSVMFree = loader.apply("clSVMFree");
        HANDLE$clSVMFree = RawFunctionLoader.link(SEGMENT$clSVMFree, Descriptors.DESCRIPTOR$clSVMFree);
        SEGMENT$clCreateSamplerWithProperties = loader.apply("clCreateSamplerWithProperties");
        HANDLE$clCreateSamplerWithProperties = RawFunctionLoader.link(SEGMENT$clCreateSamplerWithProperties, Descriptors.DESCRIPTOR$clCreateSamplerWithProperties);
        SEGMENT$clRetainSampler = loader.apply("clRetainSampler");
        HANDLE$clRetainSampler = RawFunctionLoader.link(SEGMENT$clRetainSampler, Descriptors.DESCRIPTOR$clRetainSampler);
        SEGMENT$clReleaseSampler = loader.apply("clReleaseSampler");
        HANDLE$clReleaseSampler = RawFunctionLoader.link(SEGMENT$clReleaseSampler, Descriptors.DESCRIPTOR$clReleaseSampler);
        SEGMENT$clGetSamplerInfo = loader.apply("clGetSamplerInfo");
        HANDLE$clGetSamplerInfo = RawFunctionLoader.link(SEGMENT$clGetSamplerInfo, Descriptors.DESCRIPTOR$clGetSamplerInfo);
        SEGMENT$clCreateProgramWithSource = loader.apply("clCreateProgramWithSource");
        HANDLE$clCreateProgramWithSource = RawFunctionLoader.link(SEGMENT$clCreateProgramWithSource, Descriptors.DESCRIPTOR$clCreateProgramWithSource);
        SEGMENT$clCreateProgramWithBinary = loader.apply("clCreateProgramWithBinary");
        HANDLE$clCreateProgramWithBinary = RawFunctionLoader.link(SEGMENT$clCreateProgramWithBinary, Descriptors.DESCRIPTOR$clCreateProgramWithBinary);
        SEGMENT$clCreateProgramWithBuiltInKernels = loader.apply("clCreateProgramWithBuiltInKernels");
        HANDLE$clCreateProgramWithBuiltInKernels = RawFunctionLoader.link(SEGMENT$clCreateProgramWithBuiltInKernels, Descriptors.DESCRIPTOR$clCreateProgramWithBuiltInKernels);
        SEGMENT$clCreateProgramWithIL = loader.apply("clCreateProgramWithIL");
        HANDLE$clCreateProgramWithIL = RawFunctionLoader.link(SEGMENT$clCreateProgramWithIL, Descriptors.DESCRIPTOR$clCreateProgramWithIL);
        SEGMENT$clRetainProgram = loader.apply("clRetainProgram");
        HANDLE$clRetainProgram = RawFunctionLoader.link(SEGMENT$clRetainProgram, Descriptors.DESCRIPTOR$clRetainProgram);
        SEGMENT$clReleaseProgram = loader.apply("clReleaseProgram");
        HANDLE$clReleaseProgram = RawFunctionLoader.link(SEGMENT$clReleaseProgram, Descriptors.DESCRIPTOR$clReleaseProgram);
        SEGMENT$clBuildProgram = loader.apply("clBuildProgram");
        HANDLE$clBuildProgram = RawFunctionLoader.link(SEGMENT$clBuildProgram, Descriptors.DESCRIPTOR$clBuildProgram);
        SEGMENT$clCompileProgram = loader.apply("clCompileProgram");
        HANDLE$clCompileProgram = RawFunctionLoader.link(SEGMENT$clCompileProgram, Descriptors.DESCRIPTOR$clCompileProgram);
        SEGMENT$clLinkProgram = loader.apply("clLinkProgram");
        HANDLE$clLinkProgram = RawFunctionLoader.link(SEGMENT$clLinkProgram, Descriptors.DESCRIPTOR$clLinkProgram);
        SEGMENT$clSetProgramReleaseCallback = loader.apply("clSetProgramReleaseCallback");
        HANDLE$clSetProgramReleaseCallback = RawFunctionLoader.link(SEGMENT$clSetProgramReleaseCallback, Descriptors.DESCRIPTOR$clSetProgramReleaseCallback);
        SEGMENT$clSetProgramSpecializationConstant = loader.apply("clSetProgramSpecializationConstant");
        HANDLE$clSetProgramSpecializationConstant = RawFunctionLoader.link(SEGMENT$clSetProgramSpecializationConstant, Descriptors.DESCRIPTOR$clSetProgramSpecializationConstant);
        SEGMENT$clUnloadPlatformCompiler = loader.apply("clUnloadPlatformCompiler");
        HANDLE$clUnloadPlatformCompiler = RawFunctionLoader.link(SEGMENT$clUnloadPlatformCompiler, Descriptors.DESCRIPTOR$clUnloadPlatformCompiler);
        SEGMENT$clGetProgramInfo = loader.apply("clGetProgramInfo");
        HANDLE$clGetProgramInfo = RawFunctionLoader.link(SEGMENT$clGetProgramInfo, Descriptors.DESCRIPTOR$clGetProgramInfo);
        SEGMENT$clGetProgramBuildInfo = loader.apply("clGetProgramBuildInfo");
        HANDLE$clGetProgramBuildInfo = RawFunctionLoader.link(SEGMENT$clGetProgramBuildInfo, Descriptors.DESCRIPTOR$clGetProgramBuildInfo);
        SEGMENT$clCreateKernel = loader.apply("clCreateKernel");
        HANDLE$clCreateKernel = RawFunctionLoader.link(SEGMENT$clCreateKernel, Descriptors.DESCRIPTOR$clCreateKernel);
        SEGMENT$clCreateKernelsInProgram = loader.apply("clCreateKernelsInProgram");
        HANDLE$clCreateKernelsInProgram = RawFunctionLoader.link(SEGMENT$clCreateKernelsInProgram, Descriptors.DESCRIPTOR$clCreateKernelsInProgram);
        SEGMENT$clCloneKernel = loader.apply("clCloneKernel");
        HANDLE$clCloneKernel = RawFunctionLoader.link(SEGMENT$clCloneKernel, Descriptors.DESCRIPTOR$clCloneKernel);
        SEGMENT$clRetainKernel = loader.apply("clRetainKernel");
        HANDLE$clRetainKernel = RawFunctionLoader.link(SEGMENT$clRetainKernel, Descriptors.DESCRIPTOR$clRetainKernel);
        SEGMENT$clReleaseKernel = loader.apply("clReleaseKernel");
        HANDLE$clReleaseKernel = RawFunctionLoader.link(SEGMENT$clReleaseKernel, Descriptors.DESCRIPTOR$clReleaseKernel);
        SEGMENT$clSetKernelArg = loader.apply("clSetKernelArg");
        HANDLE$clSetKernelArg = RawFunctionLoader.link(SEGMENT$clSetKernelArg, Descriptors.DESCRIPTOR$clSetKernelArg);
        SEGMENT$clSetKernelArgSVMPointer = loader.apply("clSetKernelArgSVMPointer");
        HANDLE$clSetKernelArgSVMPointer = RawFunctionLoader.link(SEGMENT$clSetKernelArgSVMPointer, Descriptors.DESCRIPTOR$clSetKernelArgSVMPointer);
        SEGMENT$clSetKernelArgDevicePointerEXT = loader.apply("clSetKernelArgDevicePointerEXT");
        HANDLE$clSetKernelArgDevicePointerEXT = RawFunctionLoader.link(SEGMENT$clSetKernelArgDevicePointerEXT, Descriptors.DESCRIPTOR$clSetKernelArgDevicePointerEXT);
        SEGMENT$clSetKernelExecInfo = loader.apply("clSetKernelExecInfo");
        HANDLE$clSetKernelExecInfo = RawFunctionLoader.link(SEGMENT$clSetKernelExecInfo, Descriptors.DESCRIPTOR$clSetKernelExecInfo);
        SEGMENT$clGetKernelInfo = loader.apply("clGetKernelInfo");
        HANDLE$clGetKernelInfo = RawFunctionLoader.link(SEGMENT$clGetKernelInfo, Descriptors.DESCRIPTOR$clGetKernelInfo);
        SEGMENT$clGetKernelArgInfo = loader.apply("clGetKernelArgInfo");
        HANDLE$clGetKernelArgInfo = RawFunctionLoader.link(SEGMENT$clGetKernelArgInfo, Descriptors.DESCRIPTOR$clGetKernelArgInfo);
        SEGMENT$clGetKernelWorkGroupInfo = loader.apply("clGetKernelWorkGroupInfo");
        HANDLE$clGetKernelWorkGroupInfo = RawFunctionLoader.link(SEGMENT$clGetKernelWorkGroupInfo, Descriptors.DESCRIPTOR$clGetKernelWorkGroupInfo);
        SEGMENT$clGetKernelSubGroupInfo = loader.apply("clGetKernelSubGroupInfo");
        HANDLE$clGetKernelSubGroupInfo = RawFunctionLoader.link(SEGMENT$clGetKernelSubGroupInfo, Descriptors.DESCRIPTOR$clGetKernelSubGroupInfo);
        SEGMENT$clWaitForEvents = loader.apply("clWaitForEvents");
        HANDLE$clWaitForEvents = RawFunctionLoader.link(SEGMENT$clWaitForEvents, Descriptors.DESCRIPTOR$clWaitForEvents);
        SEGMENT$clGetEventInfo = loader.apply("clGetEventInfo");
        HANDLE$clGetEventInfo = RawFunctionLoader.link(SEGMENT$clGetEventInfo, Descriptors.DESCRIPTOR$clGetEventInfo);
        SEGMENT$clCreateUserEvent = loader.apply("clCreateUserEvent");
        HANDLE$clCreateUserEvent = RawFunctionLoader.link(SEGMENT$clCreateUserEvent, Descriptors.DESCRIPTOR$clCreateUserEvent);
        SEGMENT$clRetainEvent = loader.apply("clRetainEvent");
        HANDLE$clRetainEvent = RawFunctionLoader.link(SEGMENT$clRetainEvent, Descriptors.DESCRIPTOR$clRetainEvent);
        SEGMENT$clReleaseEvent = loader.apply("clReleaseEvent");
        HANDLE$clReleaseEvent = RawFunctionLoader.link(SEGMENT$clReleaseEvent, Descriptors.DESCRIPTOR$clReleaseEvent);
        SEGMENT$clSetUserEventStatus = loader.apply("clSetUserEventStatus");
        HANDLE$clSetUserEventStatus = RawFunctionLoader.link(SEGMENT$clSetUserEventStatus, Descriptors.DESCRIPTOR$clSetUserEventStatus);
        SEGMENT$clSetEventCallback = loader.apply("clSetEventCallback");
        HANDLE$clSetEventCallback = RawFunctionLoader.link(SEGMENT$clSetEventCallback, Descriptors.DESCRIPTOR$clSetEventCallback);
        SEGMENT$clGetEventProfilingInfo = loader.apply("clGetEventProfilingInfo");
        HANDLE$clGetEventProfilingInfo = RawFunctionLoader.link(SEGMENT$clGetEventProfilingInfo, Descriptors.DESCRIPTOR$clGetEventProfilingInfo);
        SEGMENT$clFlush = loader.apply("clFlush");
        HANDLE$clFlush = RawFunctionLoader.link(SEGMENT$clFlush, Descriptors.DESCRIPTOR$clFlush);
        SEGMENT$clFinish = loader.apply("clFinish");
        HANDLE$clFinish = RawFunctionLoader.link(SEGMENT$clFinish, Descriptors.DESCRIPTOR$clFinish);
        SEGMENT$clEnqueueReadBuffer = loader.apply("clEnqueueReadBuffer");
        HANDLE$clEnqueueReadBuffer = RawFunctionLoader.link(SEGMENT$clEnqueueReadBuffer, Descriptors.DESCRIPTOR$clEnqueueReadBuffer);
        SEGMENT$clEnqueueReadBufferRect = loader.apply("clEnqueueReadBufferRect");
        HANDLE$clEnqueueReadBufferRect = RawFunctionLoader.link(SEGMENT$clEnqueueReadBufferRect, Descriptors.DESCRIPTOR$clEnqueueReadBufferRect);
        SEGMENT$clEnqueueWriteBuffer = loader.apply("clEnqueueWriteBuffer");
        HANDLE$clEnqueueWriteBuffer = RawFunctionLoader.link(SEGMENT$clEnqueueWriteBuffer, Descriptors.DESCRIPTOR$clEnqueueWriteBuffer);
        SEGMENT$clEnqueueWriteBufferRect = loader.apply("clEnqueueWriteBufferRect");
        HANDLE$clEnqueueWriteBufferRect = RawFunctionLoader.link(SEGMENT$clEnqueueWriteBufferRect, Descriptors.DESCRIPTOR$clEnqueueWriteBufferRect);
        SEGMENT$clEnqueueFillBuffer = loader.apply("clEnqueueFillBuffer");
        HANDLE$clEnqueueFillBuffer = RawFunctionLoader.link(SEGMENT$clEnqueueFillBuffer, Descriptors.DESCRIPTOR$clEnqueueFillBuffer);
        SEGMENT$clEnqueueCopyBuffer = loader.apply("clEnqueueCopyBuffer");
        HANDLE$clEnqueueCopyBuffer = RawFunctionLoader.link(SEGMENT$clEnqueueCopyBuffer, Descriptors.DESCRIPTOR$clEnqueueCopyBuffer);
        SEGMENT$clEnqueueCopyBufferRect = loader.apply("clEnqueueCopyBufferRect");
        HANDLE$clEnqueueCopyBufferRect = RawFunctionLoader.link(SEGMENT$clEnqueueCopyBufferRect, Descriptors.DESCRIPTOR$clEnqueueCopyBufferRect);
        SEGMENT$clEnqueueReadImage = loader.apply("clEnqueueReadImage");
        HANDLE$clEnqueueReadImage = RawFunctionLoader.link(SEGMENT$clEnqueueReadImage, Descriptors.DESCRIPTOR$clEnqueueReadImage);
        SEGMENT$clEnqueueWriteImage = loader.apply("clEnqueueWriteImage");
        HANDLE$clEnqueueWriteImage = RawFunctionLoader.link(SEGMENT$clEnqueueWriteImage, Descriptors.DESCRIPTOR$clEnqueueWriteImage);
        SEGMENT$clEnqueueFillImage = loader.apply("clEnqueueFillImage");
        HANDLE$clEnqueueFillImage = RawFunctionLoader.link(SEGMENT$clEnqueueFillImage, Descriptors.DESCRIPTOR$clEnqueueFillImage);
        SEGMENT$clEnqueueCopyImage = loader.apply("clEnqueueCopyImage");
        HANDLE$clEnqueueCopyImage = RawFunctionLoader.link(SEGMENT$clEnqueueCopyImage, Descriptors.DESCRIPTOR$clEnqueueCopyImage);
        SEGMENT$clEnqueueCopyImageToBuffer = loader.apply("clEnqueueCopyImageToBuffer");
        HANDLE$clEnqueueCopyImageToBuffer = RawFunctionLoader.link(SEGMENT$clEnqueueCopyImageToBuffer, Descriptors.DESCRIPTOR$clEnqueueCopyImageToBuffer);
        SEGMENT$clEnqueueCopyBufferToImage = loader.apply("clEnqueueCopyBufferToImage");
        HANDLE$clEnqueueCopyBufferToImage = RawFunctionLoader.link(SEGMENT$clEnqueueCopyBufferToImage, Descriptors.DESCRIPTOR$clEnqueueCopyBufferToImage);
        SEGMENT$clEnqueueMapBuffer = loader.apply("clEnqueueMapBuffer");
        HANDLE$clEnqueueMapBuffer = RawFunctionLoader.link(SEGMENT$clEnqueueMapBuffer, Descriptors.DESCRIPTOR$clEnqueueMapBuffer);
        SEGMENT$clEnqueueMapImage = loader.apply("clEnqueueMapImage");
        HANDLE$clEnqueueMapImage = RawFunctionLoader.link(SEGMENT$clEnqueueMapImage, Descriptors.DESCRIPTOR$clEnqueueMapImage);
        SEGMENT$clEnqueueUnmapMemObject = loader.apply("clEnqueueUnmapMemObject");
        HANDLE$clEnqueueUnmapMemObject = RawFunctionLoader.link(SEGMENT$clEnqueueUnmapMemObject, Descriptors.DESCRIPTOR$clEnqueueUnmapMemObject);
        SEGMENT$clEnqueueMigrateMemObjects = loader.apply("clEnqueueMigrateMemObjects");
        HANDLE$clEnqueueMigrateMemObjects = RawFunctionLoader.link(SEGMENT$clEnqueueMigrateMemObjects, Descriptors.DESCRIPTOR$clEnqueueMigrateMemObjects);
        SEGMENT$clEnqueueNDRangeKernel = loader.apply("clEnqueueNDRangeKernel");
        HANDLE$clEnqueueNDRangeKernel = RawFunctionLoader.link(SEGMENT$clEnqueueNDRangeKernel, Descriptors.DESCRIPTOR$clEnqueueNDRangeKernel);
        SEGMENT$clEnqueueNativeKernel = loader.apply("clEnqueueNativeKernel");
        HANDLE$clEnqueueNativeKernel = RawFunctionLoader.link(SEGMENT$clEnqueueNativeKernel, Descriptors.DESCRIPTOR$clEnqueueNativeKernel);
        SEGMENT$clEnqueueMarkerWithWaitList = loader.apply("clEnqueueMarkerWithWaitList");
        HANDLE$clEnqueueMarkerWithWaitList = RawFunctionLoader.link(SEGMENT$clEnqueueMarkerWithWaitList, Descriptors.DESCRIPTOR$clEnqueueMarkerWithWaitList);
        SEGMENT$clEnqueueBarrierWithWaitList = loader.apply("clEnqueueBarrierWithWaitList");
        HANDLE$clEnqueueBarrierWithWaitList = RawFunctionLoader.link(SEGMENT$clEnqueueBarrierWithWaitList, Descriptors.DESCRIPTOR$clEnqueueBarrierWithWaitList);
        SEGMENT$clEnqueueSVMFree = loader.apply("clEnqueueSVMFree");
        HANDLE$clEnqueueSVMFree = RawFunctionLoader.link(SEGMENT$clEnqueueSVMFree, Descriptors.DESCRIPTOR$clEnqueueSVMFree);
        SEGMENT$clEnqueueSVMMemcpy = loader.apply("clEnqueueSVMMemcpy");
        HANDLE$clEnqueueSVMMemcpy = RawFunctionLoader.link(SEGMENT$clEnqueueSVMMemcpy, Descriptors.DESCRIPTOR$clEnqueueSVMMemcpy);
        SEGMENT$clEnqueueSVMMemFill = loader.apply("clEnqueueSVMMemFill");
        HANDLE$clEnqueueSVMMemFill = RawFunctionLoader.link(SEGMENT$clEnqueueSVMMemFill, Descriptors.DESCRIPTOR$clEnqueueSVMMemFill);
        SEGMENT$clEnqueueSVMMap = loader.apply("clEnqueueSVMMap");
        HANDLE$clEnqueueSVMMap = RawFunctionLoader.link(SEGMENT$clEnqueueSVMMap, Descriptors.DESCRIPTOR$clEnqueueSVMMap);
        SEGMENT$clEnqueueSVMUnmap = loader.apply("clEnqueueSVMUnmap");
        HANDLE$clEnqueueSVMUnmap = RawFunctionLoader.link(SEGMENT$clEnqueueSVMUnmap, Descriptors.DESCRIPTOR$clEnqueueSVMUnmap);
        SEGMENT$clEnqueueSVMMigrateMem = loader.apply("clEnqueueSVMMigrateMem");
        HANDLE$clEnqueueSVMMigrateMem = RawFunctionLoader.link(SEGMENT$clEnqueueSVMMigrateMem, Descriptors.DESCRIPTOR$clEnqueueSVMMigrateMem);
        SEGMENT$clGetExtensionFunctionAddressForPlatform = loader.apply("clGetExtensionFunctionAddressForPlatform");
        HANDLE$clGetExtensionFunctionAddressForPlatform = RawFunctionLoader.link(SEGMENT$clGetExtensionFunctionAddressForPlatform, Descriptors.DESCRIPTOR$clGetExtensionFunctionAddressForPlatform);
        SEGMENT$clSetCommandQueueProperty = loader.apply("clSetCommandQueueProperty");
        HANDLE$clSetCommandQueueProperty = RawFunctionLoader.link(SEGMENT$clSetCommandQueueProperty, Descriptors.DESCRIPTOR$clSetCommandQueueProperty);
        SEGMENT$clCreateImage2D = loader.apply("clCreateImage2D");
        HANDLE$clCreateImage2D = RawFunctionLoader.link(SEGMENT$clCreateImage2D, Descriptors.DESCRIPTOR$clCreateImage2D);
        SEGMENT$clCreateImage3D = loader.apply("clCreateImage3D");
        HANDLE$clCreateImage3D = RawFunctionLoader.link(SEGMENT$clCreateImage3D, Descriptors.DESCRIPTOR$clCreateImage3D);
        SEGMENT$clEnqueueMarker = loader.apply("clEnqueueMarker");
        HANDLE$clEnqueueMarker = RawFunctionLoader.link(SEGMENT$clEnqueueMarker, Descriptors.DESCRIPTOR$clEnqueueMarker);
        SEGMENT$clEnqueueWaitForEvents = loader.apply("clEnqueueWaitForEvents");
        HANDLE$clEnqueueWaitForEvents = RawFunctionLoader.link(SEGMENT$clEnqueueWaitForEvents, Descriptors.DESCRIPTOR$clEnqueueWaitForEvents);
        SEGMENT$clEnqueueBarrier = loader.apply("clEnqueueBarrier");
        HANDLE$clEnqueueBarrier = RawFunctionLoader.link(SEGMENT$clEnqueueBarrier, Descriptors.DESCRIPTOR$clEnqueueBarrier);
        SEGMENT$clUnloadCompiler = loader.apply("clUnloadCompiler");
        HANDLE$clUnloadCompiler = RawFunctionLoader.link(SEGMENT$clUnloadCompiler, Descriptors.DESCRIPTOR$clUnloadCompiler);
        SEGMENT$clGetExtensionFunctionAddress = loader.apply("clGetExtensionFunctionAddress");
        HANDLE$clGetExtensionFunctionAddress = RawFunctionLoader.link(SEGMENT$clGetExtensionFunctionAddress, Descriptors.DESCRIPTOR$clGetExtensionFunctionAddress);
        SEGMENT$clCreateCommandQueue = loader.apply("clCreateCommandQueue");
        HANDLE$clCreateCommandQueue = RawFunctionLoader.link(SEGMENT$clCreateCommandQueue, Descriptors.DESCRIPTOR$clCreateCommandQueue);
        SEGMENT$clCreateSampler = loader.apply("clCreateSampler");
        HANDLE$clCreateSampler = RawFunctionLoader.link(SEGMENT$clCreateSampler, Descriptors.DESCRIPTOR$clCreateSampler);
        SEGMENT$clEnqueueTask = loader.apply("clEnqueueTask");
        HANDLE$clEnqueueTask = RawFunctionLoader.link(SEGMENT$clEnqueueTask, Descriptors.DESCRIPTOR$clEnqueueTask);
        SEGMENT$clGetLayerInfo = loader.apply("clGetLayerInfo");
        HANDLE$clGetLayerInfo = RawFunctionLoader.link(SEGMENT$clGetLayerInfo, Descriptors.DESCRIPTOR$clGetLayerInfo);
        SEGMENT$clInitLayer = loader.apply("clInitLayer");
        HANDLE$clInitLayer = RawFunctionLoader.link(SEGMENT$clInitLayer, Descriptors.DESCRIPTOR$clInitLayer);
        SEGMENT$clGetICDLoaderInfoOCLICD = loader.apply("clGetICDLoaderInfoOCLICD");
        HANDLE$clGetICDLoaderInfoOCLICD = RawFunctionLoader.link(SEGMENT$clGetICDLoaderInfoOCLICD, Descriptors.DESCRIPTOR$clGetICDLoaderInfoOCLICD);
        SEGMENT$clGetSupportedGLTextureFormatsINTEL = loader.apply("clGetSupportedGLTextureFormatsINTEL");
        HANDLE$clGetSupportedGLTextureFormatsINTEL = RawFunctionLoader.link(SEGMENT$clGetSupportedGLTextureFormatsINTEL, Descriptors.DESCRIPTOR$clGetSupportedGLTextureFormatsINTEL);
        SEGMENT$clGetSupportedDX9MediaSurfaceFormatsINTEL = loader.apply("clGetSupportedDX9MediaSurfaceFormatsINTEL");
        HANDLE$clGetSupportedDX9MediaSurfaceFormatsINTEL = RawFunctionLoader.link(SEGMENT$clGetSupportedDX9MediaSurfaceFormatsINTEL, Descriptors.DESCRIPTOR$clGetSupportedDX9MediaSurfaceFormatsINTEL);
        SEGMENT$clGetSupportedD3D10TextureFormatsINTEL = loader.apply("clGetSupportedD3D10TextureFormatsINTEL");
        HANDLE$clGetSupportedD3D10TextureFormatsINTEL = RawFunctionLoader.link(SEGMENT$clGetSupportedD3D10TextureFormatsINTEL, Descriptors.DESCRIPTOR$clGetSupportedD3D10TextureFormatsINTEL);
        SEGMENT$clGetSupportedD3D11TextureFormatsINTEL = loader.apply("clGetSupportedD3D11TextureFormatsINTEL");
        HANDLE$clGetSupportedD3D11TextureFormatsINTEL = RawFunctionLoader.link(SEGMENT$clGetSupportedD3D11TextureFormatsINTEL, Descriptors.DESCRIPTOR$clGetSupportedD3D11TextureFormatsINTEL);
        SEGMENT$clGetSupportedVA_APIMediaSurfaceFormatsINTEL = loader.apply("clGetSupportedVA_APIMediaSurfaceFormatsINTEL");
        HANDLE$clGetSupportedVA_APIMediaSurfaceFormatsINTEL = RawFunctionLoader.link(SEGMENT$clGetSupportedVA_APIMediaSurfaceFormatsINTEL, Descriptors.DESCRIPTOR$clGetSupportedVA_APIMediaSurfaceFormatsINTEL);
        SEGMENT$clEnqueueReadHostPipeINTEL = loader.apply("clEnqueueReadHostPipeINTEL");
        HANDLE$clEnqueueReadHostPipeINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueReadHostPipeINTEL, Descriptors.DESCRIPTOR$clEnqueueReadHostPipeINTEL);
        SEGMENT$clEnqueueWriteHostPipeINTEL = loader.apply("clEnqueueWriteHostPipeINTEL");
        HANDLE$clEnqueueWriteHostPipeINTEL = RawFunctionLoader.link(SEGMENT$clEnqueueWriteHostPipeINTEL, Descriptors.DESCRIPTOR$clEnqueueWriteHostPipeINTEL);
        SEGMENT$clGetImageRequirementsInfoEXT = loader.apply("clGetImageRequirementsInfoEXT");
        HANDLE$clGetImageRequirementsInfoEXT = RawFunctionLoader.link(SEGMENT$clGetImageRequirementsInfoEXT, Descriptors.DESCRIPTOR$clGetImageRequirementsInfoEXT);
        SEGMENT$clCancelCommandsIMG = loader.apply("clCancelCommandsIMG");
        HANDLE$clCancelCommandsIMG = RawFunctionLoader.link(SEGMENT$clCancelCommandsIMG, Descriptors.DESCRIPTOR$clCancelCommandsIMG);
        SEGMENT$clSetPerfHintQCOM = loader.apply("clSetPerfHintQCOM");
        HANDLE$clSetPerfHintQCOM = RawFunctionLoader.link(SEGMENT$clSetPerfHintQCOM, Descriptors.DESCRIPTOR$clSetPerfHintQCOM);
    }

    // region command wrappers

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetDeviceIDsFromD3D10KHR.html">clGetDeviceIDsFromD3D10KHR</a>
    public @NativeType("cl_int") int getDeviceIDsFromD3D10KHR(
        @Nullable CLPlatformId platform,
        @NativeType("cl_d3d10_device_source_khr") @Unsigned int d3d_device_source,
        @Pointer(comment="void*") @NotNull MemorySegment d3d_object,
        @NativeType("cl_d3d10_device_set_khr") @Unsigned int d3d_device_set,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLDeviceId.Ptr devices,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_devices
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetDeviceIDsFromD3D10KHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                d3d_device_source,
                d3d_object,
                d3d_device_set,
                num_entries,
                (MemorySegment) (devices != null ? devices.segment() : MemorySegment.NULL),
                (MemorySegment) (num_devices != null ? num_devices.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromD3D10BufferKHR.html">clCreateFromD3D10BufferKHR</a>
    public @Nullable CLMem createFromD3D10BufferKHR(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable PointerPtr resource,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromD3D10BufferKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (resource != null ? resource.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromD3D10Texture2DKHR.html">clCreateFromD3D10Texture2DKHR</a>
    public @Nullable CLMem createFromD3D10Texture2DKHR(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable PointerPtr resource,
        @NativeType("UINT") @Unsigned int subresource,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromD3D10Texture2DKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (resource != null ? resource.segment() : MemorySegment.NULL),
                subresource,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromD3D10Texture3DKHR.html">clCreateFromD3D10Texture3DKHR</a>
    public @Nullable CLMem createFromD3D10Texture3DKHR(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable PointerPtr resource,
        @NativeType("UINT") @Unsigned int subresource,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromD3D10Texture3DKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (resource != null ? resource.segment() : MemorySegment.NULL),
                subresource,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueAcquireD3D10ObjectsKHR.html">clEnqueueAcquireD3D10ObjectsKHR</a>
    public @NativeType("cl_int") int enqueueAcquireD3D10ObjectsKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueAcquireD3D10ObjectsKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReleaseD3D10ObjectsKHR.html">clEnqueueReleaseD3D10ObjectsKHR</a>
    public @NativeType("cl_int") int enqueueReleaseD3D10ObjectsKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReleaseD3D10ObjectsKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetDeviceIDsFromD3D11KHR.html">clGetDeviceIDsFromD3D11KHR</a>
    public @NativeType("cl_int") int getDeviceIDsFromD3D11KHR(
        @Nullable CLPlatformId platform,
        @NativeType("cl_d3d11_device_source_khr") @Unsigned int d3d_device_source,
        @Pointer(comment="void*") @NotNull MemorySegment d3d_object,
        @NativeType("cl_d3d11_device_set_khr") @Unsigned int d3d_device_set,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLDeviceId.Ptr devices,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_devices
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetDeviceIDsFromD3D11KHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                d3d_device_source,
                d3d_object,
                d3d_device_set,
                num_entries,
                (MemorySegment) (devices != null ? devices.segment() : MemorySegment.NULL),
                (MemorySegment) (num_devices != null ? num_devices.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromD3D11BufferKHR.html">clCreateFromD3D11BufferKHR</a>
    public @Nullable CLMem createFromD3D11BufferKHR(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable PointerPtr resource,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromD3D11BufferKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (resource != null ? resource.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromD3D11Texture2DKHR.html">clCreateFromD3D11Texture2DKHR</a>
    public @Nullable CLMem createFromD3D11Texture2DKHR(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable PointerPtr resource,
        @NativeType("UINT") @Unsigned int subresource,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromD3D11Texture2DKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (resource != null ? resource.segment() : MemorySegment.NULL),
                subresource,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromD3D11Texture3DKHR.html">clCreateFromD3D11Texture3DKHR</a>
    public @Nullable CLMem createFromD3D11Texture3DKHR(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable PointerPtr resource,
        @NativeType("UINT") @Unsigned int subresource,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromD3D11Texture3DKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (resource != null ? resource.segment() : MemorySegment.NULL),
                subresource,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueAcquireD3D11ObjectsKHR.html">clEnqueueAcquireD3D11ObjectsKHR</a>
    public @NativeType("cl_int") int enqueueAcquireD3D11ObjectsKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueAcquireD3D11ObjectsKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReleaseD3D11ObjectsKHR.html">clEnqueueReleaseD3D11ObjectsKHR</a>
    public @NativeType("cl_int") int enqueueReleaseD3D11ObjectsKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReleaseD3D11ObjectsKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetDeviceIDsFromDX9MediaAdapterKHR.html">clGetDeviceIDsFromDX9MediaAdapterKHR</a>
    public @NativeType("cl_int") int getDeviceIDsFromDX9MediaAdapterKHR(
        @Nullable CLPlatformId platform,
        @NativeType("cl_uint") @Unsigned int num_media_adapters,
        @Nullable @Pointer(comment="cl_dx9_media_adapter_type_khr") @Unsigned IntPtr media_adapter_type,
        @Pointer(comment="void*") @NotNull MemorySegment media_adapters,
        @NativeType("cl_dx9_media_adapter_set_khr") @Unsigned int media_adapter_set,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLDeviceId.Ptr devices,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_devices
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetDeviceIDsFromDX9MediaAdapterKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                num_media_adapters,
                (MemorySegment) (media_adapter_type != null ? media_adapter_type.segment() : MemorySegment.NULL),
                media_adapters,
                media_adapter_set,
                num_entries,
                (MemorySegment) (devices != null ? devices.segment() : MemorySegment.NULL),
                (MemorySegment) (num_devices != null ? num_devices.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromDX9MediaSurfaceKHR.html">clCreateFromDX9MediaSurfaceKHR</a>
    public @Nullable CLMem createFromDX9MediaSurfaceKHR(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_dx9_media_adapter_type_khr") @Unsigned int adapter_type,
        @Pointer(comment="void*") @NotNull MemorySegment surface_info,
        @NativeType("cl_uint") @Unsigned int plane,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromDX9MediaSurfaceKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                adapter_type,
                surface_info,
                plane,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueAcquireDX9MediaSurfacesKHR.html">clEnqueueAcquireDX9MediaSurfacesKHR</a>
    public @NativeType("cl_int") int enqueueAcquireDX9MediaSurfacesKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueAcquireDX9MediaSurfacesKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReleaseDX9MediaSurfacesKHR.html">clEnqueueReleaseDX9MediaSurfacesKHR</a>
    public @NativeType("cl_int") int enqueueReleaseDX9MediaSurfacesKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReleaseDX9MediaSurfacesKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetDeviceIDsFromDX9INTEL.html">clGetDeviceIDsFromDX9INTEL</a>
    public @NativeType("cl_int") int getDeviceIDsFromDX9INTEL(
        @Nullable CLPlatformId platform,
        @NativeType("cl_dx9_device_source_intel") @Unsigned int dx9_device_source,
        @Pointer(comment="void*") @NotNull MemorySegment dx9_object,
        @NativeType("cl_dx9_device_set_intel") @Unsigned int dx9_device_set,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLDeviceId.Ptr devices,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_devices
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetDeviceIDsFromDX9INTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                dx9_device_source,
                dx9_object,
                dx9_device_set,
                num_entries,
                (MemorySegment) (devices != null ? devices.segment() : MemorySegment.NULL),
                (MemorySegment) (num_devices != null ? num_devices.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromDX9MediaSurfaceINTEL.html">clCreateFromDX9MediaSurfaceINTEL</a>
    public @Nullable CLMem createFromDX9MediaSurfaceINTEL(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable PointerPtr resource,
        @Pointer(comment="HANDLE") @NotNull MemorySegment sharedHandle,
        @NativeType("UINT") @Unsigned int plane,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromDX9MediaSurfaceINTEL);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (resource != null ? resource.segment() : MemorySegment.NULL),
                sharedHandle,
                plane,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueAcquireDX9ObjectsINTEL.html">clEnqueueAcquireDX9ObjectsINTEL</a>
    public @NativeType("cl_int") int enqueueAcquireDX9ObjectsINTEL(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueAcquireDX9ObjectsINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReleaseDX9ObjectsINTEL.html">clEnqueueReleaseDX9ObjectsINTEL</a>
    public @NativeType("cl_int") int enqueueReleaseDX9ObjectsINTEL(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReleaseDX9ObjectsINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateEventFromEGLSyncKHR.html">clCreateEventFromEGLSyncKHR</a>
    public @Nullable CLEvent createEventFromEGLSyncKHR(
        @Nullable CLContext context,
        @Pointer(comment="CLeglSyncKHR") @NotNull MemorySegment sync,
        @Pointer(comment="CLeglDisplayKHR") @NotNull MemorySegment display,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateEventFromEGLSyncKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                sync,
                display,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLEvent(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromEGLImageKHR.html">clCreateFromEGLImageKHR</a>
    public @Nullable CLMem createFromEGLImageKHR(
        @Nullable CLContext context,
        @Pointer(comment="CLeglDisplayKHR") @NotNull MemorySegment egldisplay,
        @Pointer(comment="CLeglImageKHR") @NotNull MemorySegment eglimage,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable @Pointer(comment="cl_egl_image_properties_khr") PointerPtr properties,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromEGLImageKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                egldisplay,
                eglimage,
                flags,
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueAcquireEGLObjectsKHR.html">clEnqueueAcquireEGLObjectsKHR</a>
    public @NativeType("cl_int") int enqueueAcquireEGLObjectsKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueAcquireEGLObjectsKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReleaseEGLObjectsKHR.html">clEnqueueReleaseEGLObjectsKHR</a>
    public @NativeType("cl_int") int enqueueReleaseEGLObjectsKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReleaseEGLObjectsKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clLogMessagesToSystemLogAPPLE.html">clLogMessagesToSystemLogAPPLE</a>
    public void logMessagesToSystemLogAPPLE(
        @Nullable BytePtr errstr,
        @Pointer(comment="void*") @NotNull MemorySegment private_info,
        long cb,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clLogMessagesToSystemLogAPPLE);
        try {
            hFunction.invokeExact(
                (MemorySegment) (errstr != null ? errstr.segment() : MemorySegment.NULL),
                private_info,
                MemorySegment.ofAddress(cb),
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clLogMessagesToStdoutAPPLE.html">clLogMessagesToStdoutAPPLE</a>
    public void logMessagesToStdoutAPPLE(
        @Nullable BytePtr errstr,
        @Pointer(comment="void*") @NotNull MemorySegment private_info,
        long cb,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clLogMessagesToStdoutAPPLE);
        try {
            hFunction.invokeExact(
                (MemorySegment) (errstr != null ? errstr.segment() : MemorySegment.NULL),
                private_info,
                MemorySegment.ofAddress(cb),
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clLogMessagesToStderrAPPLE.html">clLogMessagesToStderrAPPLE</a>
    public void logMessagesToStderrAPPLE(
        @Nullable BytePtr errstr,
        @Pointer(comment="void*") @NotNull MemorySegment private_info,
        long cb,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clLogMessagesToStderrAPPLE);
        try {
            hFunction.invokeExact(
                (MemorySegment) (errstr != null ? errstr.segment() : MemorySegment.NULL),
                private_info,
                MemorySegment.ofAddress(cb),
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clIcdGetPlatformIDsKHR.html">clIcdGetPlatformIDsKHR</a>
    public @NativeType("cl_int") int icdGetPlatformIDsKHR(
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLPlatformId.Ptr platforms,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_platforms
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clIcdGetPlatformIDsKHR);
        try {
            return (int) hFunction.invokeExact(
                num_entries,
                (MemorySegment) (platforms != null ? platforms.segment() : MemorySegment.NULL),
                (MemorySegment) (num_platforms != null ? num_platforms.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clIcdGetFunctionAddressForPlatformKHR.html">clIcdGetFunctionAddressForPlatformKHR</a>
    public @Pointer(comment="void*") @NotNull MemorySegment icdGetFunctionAddressForPlatformKHR(
        @Nullable CLPlatformId platform,
        @Nullable BytePtr func_name
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clIcdGetFunctionAddressForPlatformKHR);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                (MemorySegment) (func_name != null ? func_name.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clIcdSetPlatformDispatchDataKHR.html">clIcdSetPlatformDispatchDataKHR</a>
    public @NativeType("cl_int") int icdSetPlatformDispatchDataKHR(
        @Nullable CLPlatformId platform,
        @Pointer(comment="void*") @NotNull MemorySegment dispatch_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clIcdSetPlatformDispatchDataKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                dispatch_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateProgramWithILKHR.html">clCreateProgramWithILKHR</a>
    public @Nullable CLProgram createProgramWithILKHR(
        @Nullable CLContext context,
        @Pointer(comment="void*") @NotNull MemorySegment il,
        long length,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateProgramWithILKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                il,
                MemorySegment.ofAddress(length),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLProgram(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clTerminateContextKHR.html">clTerminateContextKHR</a>
    public @NativeType("cl_int") int terminateContextKHR(
        @Nullable CLContext context
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clTerminateContextKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateCommandQueueWithPropertiesKHR.html">clCreateCommandQueueWithPropertiesKHR</a>
    public @Nullable CLCommandQueue createCommandQueueWithPropertiesKHR(
        @Nullable CLContext context,
        @Nullable CLDeviceId device,
        @Nullable @Pointer(comment="cl_queue_properties_khr") @Unsigned LongPtr properties,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateCommandQueueWithPropertiesKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLCommandQueue(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseDeviceEXT.html">clReleaseDeviceEXT</a>
    public @NativeType("cl_int") int releaseDeviceEXT(
        @Nullable CLDeviceId device
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseDeviceEXT);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainDeviceEXT.html">clRetainDeviceEXT</a>
    public @NativeType("cl_int") int retainDeviceEXT(
        @Nullable CLDeviceId device
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainDeviceEXT);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateSubDevicesEXT.html">clCreateSubDevicesEXT</a>
    public @NativeType("cl_int") int createSubDevicesEXT(
        @Nullable CLDeviceId in_device,
        @Nullable @Pointer(comment="cl_device_partition_property_ext") @Unsigned LongPtr properties,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLDeviceId.Ptr out_devices,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_devices
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateSubDevicesEXT);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (in_device != null ? in_device.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                num_entries,
                (MemorySegment) (out_devices != null ? out_devices.segment() : MemorySegment.NULL),
                (MemorySegment) (num_devices != null ? num_devices.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMigrateMemObjectEXT.html">clEnqueueMigrateMemObjectEXT</a>
    public @NativeType("cl_int") int enqueueMigrateMemObjectEXT(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_mem_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_mem_migration_flags_ext") @Unsigned long flags,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMigrateMemObjectEXT);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_mem_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                flags,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetDeviceImageInfoQCOM.html">clGetDeviceImageInfoQCOM</a>
    public @NativeType("cl_int") int getDeviceImageInfoQCOM(
        @Nullable CLDeviceId device,
        long imageWidth,
        long imageHeight,
        @Nullable @Pointer CLImageFormat image_format,
        @NativeType("cl_image_pitch_info_qcom") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetDeviceImageInfoQCOM);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(imageWidth),
                MemorySegment.ofAddress(imageHeight),
                (MemorySegment) (image_format != null ? image_format.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueAcquireGrallocObjectsIMG.html">clEnqueueAcquireGrallocObjectsIMG</a>
    public @NativeType("cl_int") int enqueueAcquireGrallocObjectsIMG(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueAcquireGrallocObjectsIMG);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueGenerateMipmapIMG.html">clEnqueueGenerateMipmapIMG</a>
    public @NativeType("cl_int") int enqueueGenerateMipmapIMG(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem src_image,
        @Nullable CLMem dst_image,
        @NativeType("cl_mipmap_filter_mode_img") @Unsigned int mipmap_filter_mode,
        @Nullable PointerPtr array_region,
        @Nullable PointerPtr mip_region,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueGenerateMipmapIMG);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (src_image != null ? src_image.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_image != null ? dst_image.segment() : MemorySegment.NULL),
                mipmap_filter_mode,
                (MemorySegment) (array_region != null ? array_region.segment() : MemorySegment.NULL),
                (MemorySegment) (mip_region != null ? mip_region.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReleaseGrallocObjectsIMG.html">clEnqueueReleaseGrallocObjectsIMG</a>
    public @NativeType("cl_int") int enqueueReleaseGrallocObjectsIMG(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReleaseGrallocObjectsIMG);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetKernelSubGroupInfoKHR.html">clGetKernelSubGroupInfoKHR</a>
    public @NativeType("cl_int") int getKernelSubGroupInfoKHR(
        @Nullable CLKernel in_kernel,
        @Nullable CLDeviceId in_device,
        @NativeType("cl_kernel_sub_group_info") @Unsigned int paramName,
        long input_value_size,
        @Pointer(comment="void*") @NotNull MemorySegment input_value,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetKernelSubGroupInfoKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (in_kernel != null ? in_kernel.segment() : MemorySegment.NULL),
                (MemorySegment) (in_device != null ? in_device.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(input_value_size),
                input_value,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetKernelSuggestedLocalWorkSizeKHR.html">clGetKernelSuggestedLocalWorkSizeKHR</a>
    public @NativeType("cl_int") int getKernelSuggestedLocalWorkSizeKHR(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int workDim,
        @Nullable PointerPtr globalWorkOffset,
        @Nullable PointerPtr globalWorkSize,
        @Nullable PointerPtr suggested_local_work_size
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetKernelSuggestedLocalWorkSizeKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                workDim,
                (MemorySegment) (globalWorkOffset != null ? globalWorkOffset.segment() : MemorySegment.NULL),
                (MemorySegment) (globalWorkSize != null ? globalWorkSize.segment() : MemorySegment.NULL),
                (MemorySegment) (suggested_local_work_size != null ? suggested_local_work_size.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateSemaphoreWithPropertiesKHR.html">clCreateSemaphoreWithPropertiesKHR</a>
    public @Nullable CLSemaphoreKhr createSemaphoreWithPropertiesKHR(
        @Nullable CLContext context,
        @Nullable @Pointer(comment="cl_semaphore_properties_khr") @Unsigned LongPtr sema_props,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateSemaphoreWithPropertiesKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (sema_props != null ? sema_props.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLSemaphoreKhr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueWaitSemaphoresKHR.html">clEnqueueWaitSemaphoresKHR</a>
    public @NativeType("cl_int") int enqueueWaitSemaphoresKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_sema_objects,
        @Nullable @Pointer CLSemaphoreKhr.Ptr sema_objects,
        @Nullable @Pointer(comment="cl_semaphore_payload_khr") @Unsigned LongPtr sema_payload_list,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueWaitSemaphoresKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_sema_objects,
                (MemorySegment) (sema_objects != null ? sema_objects.segment() : MemorySegment.NULL),
                (MemorySegment) (sema_payload_list != null ? sema_payload_list.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSignalSemaphoresKHR.html">clEnqueueSignalSemaphoresKHR</a>
    public @NativeType("cl_int") int enqueueSignalSemaphoresKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_sema_objects,
        @Nullable @Pointer CLSemaphoreKhr.Ptr sema_objects,
        @Nullable @Pointer(comment="cl_semaphore_payload_khr") @Unsigned LongPtr sema_payload_list,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSignalSemaphoresKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_sema_objects,
                (MemorySegment) (sema_objects != null ? sema_objects.segment() : MemorySegment.NULL),
                (MemorySegment) (sema_payload_list != null ? sema_payload_list.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetSemaphoreInfoKHR.html">clGetSemaphoreInfoKHR</a>
    public @NativeType("cl_int") int getSemaphoreInfoKHR(
        @Nullable CLSemaphoreKhr sema_object,
        @NativeType("cl_semaphore_info_khr") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetSemaphoreInfoKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (sema_object != null ? sema_object.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseSemaphoreKHR.html">clReleaseSemaphoreKHR</a>
    public @NativeType("cl_int") int releaseSemaphoreKHR(
        @Nullable CLSemaphoreKhr sema_object
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseSemaphoreKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (sema_object != null ? sema_object.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainSemaphoreKHR.html">clRetainSemaphoreKHR</a>
    public @NativeType("cl_int") int retainSemaphoreKHR(
        @Nullable CLSemaphoreKhr sema_object
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainSemaphoreKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (sema_object != null ? sema_object.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetSemaphoreHandleForTypeKHR.html">clGetSemaphoreHandleForTypeKHR</a>
    public @NativeType("cl_int") int getSemaphoreHandleForTypeKHR(
        @Nullable CLSemaphoreKhr sema_object,
        @Nullable CLDeviceId device,
        @NativeType("cl_external_semaphore_handle_type_khr") @Unsigned int handle_type,
        long handle_size,
        @Pointer(comment="void*") @NotNull MemorySegment handle_ptr,
        @Nullable PointerPtr handle_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetSemaphoreHandleForTypeKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (sema_object != null ? sema_object.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                handle_type,
                MemorySegment.ofAddress(handle_size),
                handle_ptr,
                (MemorySegment) (handle_size_ret != null ? handle_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReImportSemaphoreSyncFdKHR.html">clReImportSemaphoreSyncFdKHR</a>
    public @NativeType("cl_int") int reImportSemaphoreSyncFdKHR(
        @Nullable CLSemaphoreKhr sema_object,
        @Nullable @Pointer(comment="cl_semaphore_reimport_properties_khr") @Unsigned LongPtr reimport_props,
        int fd
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReImportSemaphoreSyncFdKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (sema_object != null ? sema_object.segment() : MemorySegment.NULL),
                (MemorySegment) (reimport_props != null ? reimport_props.segment() : MemorySegment.NULL),
                fd
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueAcquireExternalMemObjectsKHR.html">clEnqueueAcquireExternalMemObjectsKHR</a>
    public @NativeType("cl_int") int enqueueAcquireExternalMemObjectsKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_mem_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueAcquireExternalMemObjectsKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_mem_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReleaseExternalMemObjectsKHR.html">clEnqueueReleaseExternalMemObjectsKHR</a>
    public @NativeType("cl_int") int enqueueReleaseExternalMemObjectsKHR(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_mem_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReleaseExternalMemObjectsKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_mem_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clImportMemoryARM.html">clImportMemoryARM</a>
    public @Nullable CLMem importMemoryARM(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable @Pointer(comment="cl_import_properties_arm") PointerPtr properties,
        @Pointer(comment="void*") @NotNull MemorySegment memory,
        long size,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clImportMemoryARM);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                memory,
                MemorySegment.ofAddress(size),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSVMAllocARM.html">clSVMAllocARM</a>
    public @Pointer(comment="void*") @NotNull MemorySegment SVMAllocARM(
        @Nullable CLContext context,
        @NativeType("cl_svm_mem_flags_arm") @Unsigned long flags,
        long size,
        @NativeType("cl_uint") @Unsigned int alignment
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSVMAllocARM);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                MemorySegment.ofAddress(size),
                alignment
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSVMFreeARM.html">clSVMFreeARM</a>
    public void SVMFreeARM(
        @Nullable CLContext context,
        @Pointer(comment="void*") @NotNull MemorySegment svm_pointer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSVMFreeARM);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                svm_pointer
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMFreeARM.html">clEnqueueSVMFreeARM</a>
    public @NativeType("cl_int") int enqueueSVMFreeARM(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_svm_pointers,
        @Pointer(comment="void*") @NotNull MemorySegment svm_pointers,
        @Pointer(comment="pfn_free_func_0") @NotNull MemorySegment pfn_free_func,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMFreeARM);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_svm_pointers,
                svm_pointers,
                pfn_free_func,
                user_data,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int enqueueSVMFreeARM(
        Arena arena,
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_svm_pointers,
        @Pointer(comment="void*") @NotNull MemorySegment svm_pointers,
        Ipfn_free_func_0 pfn_free_func,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        return enqueueSVMFreeARM(
            command_queue,
            num_svm_pointers,
            svm_pointers,
            Ipfn_free_func_0.ofNative(arena, pfn_free_func),
            user_data,
            num_events_in_wait_list,
            event_wait_list,
            event
        );
    }

    public @NativeType("cl_int") int enqueueSVMFreeARM(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_svm_pointers,
        @Pointer(comment="void*") @NotNull MemorySegment svm_pointers,
        Ipfn_free_func_0 pfn_free_func,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        return enqueueSVMFreeARM(
            Arena.global(),
            command_queue,
            num_svm_pointers,
            svm_pointers,
            pfn_free_func,
            user_data,
            num_events_in_wait_list,
            event_wait_list,
            event
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMMemcpyARM.html">clEnqueueSVMMemcpyARM</a>
    public @NativeType("cl_int") int enqueueSVMMemcpyARM(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_bool") @Unsigned int blocking_copy,
        @Pointer(comment="void*") @NotNull MemorySegment dst_ptr,
        @Pointer(comment="void*") @NotNull MemorySegment src_ptr,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMMemcpyARM);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                blocking_copy,
                dst_ptr,
                src_ptr,
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMMemFillARM.html">clEnqueueSVMMemFillARM</a>
    public @NativeType("cl_int") int enqueueSVMMemFillARM(
        @Nullable CLCommandQueue command_queue,
        @Pointer(comment="void*") @NotNull MemorySegment svm_ptr,
        @Pointer(comment="void*") @NotNull MemorySegment pattern,
        long pattern_size,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMMemFillARM);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                svm_ptr,
                pattern,
                MemorySegment.ofAddress(pattern_size),
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMMapARM.html">clEnqueueSVMMapARM</a>
    public @NativeType("cl_int") int enqueueSVMMapARM(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_bool") @Unsigned int blocking_map,
        @NativeType("cl_map_flags") @Unsigned long flags,
        @Pointer(comment="void*") @NotNull MemorySegment svm_ptr,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMMapARM);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                blocking_map,
                flags,
                svm_ptr,
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMUnmapARM.html">clEnqueueSVMUnmapARM</a>
    public @NativeType("cl_int") int enqueueSVMUnmapARM(
        @Nullable CLCommandQueue command_queue,
        @Pointer(comment="void*") @NotNull MemorySegment svm_ptr,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMUnmapARM);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                svm_ptr,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetKernelArgSVMPointerARM.html">clSetKernelArgSVMPointerARM</a>
    public @NativeType("cl_int") int setKernelArgSVMPointerARM(
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int argIndex,
        @Pointer(comment="void*") @NotNull MemorySegment argValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetKernelArgSVMPointerARM);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                argIndex,
                argValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetKernelExecInfoARM.html">clSetKernelExecInfoARM</a>
    public @NativeType("cl_int") int setKernelExecInfoARM(
        @Nullable CLKernel kernel,
        @NativeType("cl_kernel_exec_info_arm") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetKernelExecInfoARM);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateAcceleratorINTEL.html">clCreateAcceleratorINTEL</a>
    public @Nullable CLAcceleratorIntel createAcceleratorINTEL(
        @Nullable CLContext context,
        @NativeType("cl_accelerator_type_intel") @Unsigned int accelerator_type,
        long descriptor_size,
        @Pointer(comment="void*") @NotNull MemorySegment descriptor,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateAcceleratorINTEL);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                accelerator_type,
                MemorySegment.ofAddress(descriptor_size),
                descriptor,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLAcceleratorIntel(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetAcceleratorInfoINTEL.html">clGetAcceleratorInfoINTEL</a>
    public @NativeType("cl_int") int getAcceleratorInfoINTEL(
        @Nullable CLAcceleratorIntel accelerator,
        @NativeType("cl_accelerator_info_intel") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetAcceleratorInfoINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (accelerator != null ? accelerator.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainAcceleratorINTEL.html">clRetainAcceleratorINTEL</a>
    public @NativeType("cl_int") int retainAcceleratorINTEL(
        @Nullable CLAcceleratorIntel accelerator
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainAcceleratorINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (accelerator != null ? accelerator.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseAcceleratorINTEL.html">clReleaseAcceleratorINTEL</a>
    public @NativeType("cl_int") int releaseAcceleratorINTEL(
        @Nullable CLAcceleratorIntel accelerator
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseAcceleratorINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (accelerator != null ? accelerator.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateEventFromGLsyncKHR.html">clCreateEventFromGLsyncKHR</a>
    public @Nullable CLEvent createEventFromGLsyncKHR(
        @Nullable CLContext context,
        @Nullable CLGLsync sync,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateEventFromGLsyncKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (sync != null ? sync.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLEvent(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetGLContextInfoKHR.html">clGetGLContextInfoKHR</a>
    public @NativeType("cl_int") int getGLContextInfoKHR(
        @Nullable @Pointer(comment="cl_context_properties") PointerPtr properties,
        @NativeType("cl_gl_context_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetGLContextInfoKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromGLBuffer.html">clCreateFromGLBuffer</a>
    public @Nullable CLMem createFromGLBuffer(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_GLuint") @Unsigned int bufobj,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromGLBuffer);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                bufobj,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromGLTexture.html">clCreateFromGLTexture</a>
    public @Nullable CLMem createFromGLTexture(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_GLenum") @Unsigned int target,
        @NativeType("cl_GLint") int miplevel,
        @NativeType("cl_GLuint") @Unsigned int texture,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromGLTexture);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                target,
                miplevel,
                texture,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromGLRenderbuffer.html">clCreateFromGLRenderbuffer</a>
    public @Nullable CLMem createFromGLRenderbuffer(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_GLuint") @Unsigned int renderbuffer,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromGLRenderbuffer);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                renderbuffer,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetGLObjectInfo.html">clGetGLObjectInfo</a>
    public @NativeType("cl_int") int getGLObjectInfo(
        @Nullable CLMem memobj,
        @Nullable @Pointer(comment="cl_gl_object_type") @Unsigned IntPtr gl_object_type,
        @Nullable @Pointer(comment="cl_GLuint") @Unsigned IntPtr gl_object_name
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetGLObjectInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (memobj != null ? memobj.segment() : MemorySegment.NULL),
                (MemorySegment) (gl_object_type != null ? gl_object_type.segment() : MemorySegment.NULL),
                (MemorySegment) (gl_object_name != null ? gl_object_name.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetGLTextureInfo.html">clGetGLTextureInfo</a>
    public @NativeType("cl_int") int getGLTextureInfo(
        @Nullable CLMem memobj,
        @NativeType("cl_gl_texture_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetGLTextureInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (memobj != null ? memobj.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueAcquireGLObjects.html">clEnqueueAcquireGLObjects</a>
    public @NativeType("cl_int") int enqueueAcquireGLObjects(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueAcquireGLObjects);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReleaseGLObjects.html">clEnqueueReleaseGLObjects</a>
    public @NativeType("cl_int") int enqueueReleaseGLObjects(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReleaseGLObjects);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromGLTexture2D.html">clCreateFromGLTexture2D</a>
    public @Nullable CLMem createFromGLTexture2D(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_GLenum") @Unsigned int target,
        @NativeType("cl_GLint") int miplevel,
        @NativeType("cl_GLuint") @Unsigned int texture,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromGLTexture2D);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                target,
                miplevel,
                texture,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromGLTexture3D.html">clCreateFromGLTexture3D</a>
    public @Nullable CLMem createFromGLTexture3D(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_GLenum") @Unsigned int target,
        @NativeType("cl_GLint") int miplevel,
        @NativeType("cl_GLuint") @Unsigned int texture,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromGLTexture3D);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                target,
                miplevel,
                texture,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetDeviceIDsFromVA_APIMediaAdapterINTEL.html">clGetDeviceIDsFromVA_APIMediaAdapterINTEL</a>
    public @NativeType("cl_int") int getDeviceIDsFromVA_APIMediaAdapterINTEL(
        @Nullable CLPlatformId platform,
        @NativeType("cl_va_api_device_source_intel") @Unsigned int media_adapter_type,
        @Pointer(comment="void*") @NotNull MemorySegment media_adapter,
        @NativeType("cl_va_api_device_set_intel") @Unsigned int media_adapter_set,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLDeviceId.Ptr devices,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_devices
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetDeviceIDsFromVA_APIMediaAdapterINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                media_adapter_type,
                media_adapter,
                media_adapter_set,
                num_entries,
                (MemorySegment) (devices != null ? devices.segment() : MemorySegment.NULL),
                (MemorySegment) (num_devices != null ? num_devices.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateFromVA_APIMediaSurfaceINTEL.html">clCreateFromVA_APIMediaSurfaceINTEL</a>
    public @Nullable CLMem createFromVA_APIMediaSurfaceINTEL(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable @Pointer(comment="VASurfaceID") @Unsigned IntPtr surface,
        @NativeType("cl_uint") @Unsigned int plane,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateFromVA_APIMediaSurfaceINTEL);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (surface != null ? surface.segment() : MemorySegment.NULL),
                plane,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueAcquireVA_APIMediaSurfacesINTEL.html">clEnqueueAcquireVA_APIMediaSurfacesINTEL</a>
    public @NativeType("cl_int") int enqueueAcquireVA_APIMediaSurfacesINTEL(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueAcquireVA_APIMediaSurfacesINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReleaseVA_APIMediaSurfacesINTEL.html">clEnqueueReleaseVA_APIMediaSurfacesINTEL</a>
    public @NativeType("cl_int") int enqueueReleaseVA_APIMediaSurfacesINTEL(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReleaseVA_APIMediaSurfacesINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clHostMemAllocINTEL.html">clHostMemAllocINTEL</a>
    public @Pointer(comment="void*") @NotNull MemorySegment hostMemAllocINTEL(
        @Nullable CLContext context,
        @Nullable @Pointer(comment="cl_mem_properties_intel") @Unsigned LongPtr properties,
        long size,
        @NativeType("cl_uint") @Unsigned int alignment,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clHostMemAllocINTEL);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(size),
                alignment,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clDeviceMemAllocINTEL.html">clDeviceMemAllocINTEL</a>
    public @Pointer(comment="void*") @NotNull MemorySegment deviceMemAllocINTEL(
        @Nullable CLContext context,
        @Nullable CLDeviceId device,
        @Nullable @Pointer(comment="cl_mem_properties_intel") @Unsigned LongPtr properties,
        long size,
        @NativeType("cl_uint") @Unsigned int alignment,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clDeviceMemAllocINTEL);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(size),
                alignment,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSharedMemAllocINTEL.html">clSharedMemAllocINTEL</a>
    public @Pointer(comment="void*") @NotNull MemorySegment sharedMemAllocINTEL(
        @Nullable CLContext context,
        @Nullable CLDeviceId device,
        @Nullable @Pointer(comment="cl_mem_properties_intel") @Unsigned LongPtr properties,
        long size,
        @NativeType("cl_uint") @Unsigned int alignment,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSharedMemAllocINTEL);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(size),
                alignment,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clMemFreeINTEL.html">clMemFreeINTEL</a>
    public @NativeType("cl_int") int memFreeINTEL(
        @Nullable CLContext context,
        @Pointer(comment="void*") @NotNull MemorySegment ptr
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clMemFreeINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                ptr
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clMemBlockingFreeINTEL.html">clMemBlockingFreeINTEL</a>
    public @NativeType("cl_int") int memBlockingFreeINTEL(
        @Nullable CLContext context,
        @Pointer(comment="void*") @NotNull MemorySegment ptr
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clMemBlockingFreeINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                ptr
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetMemAllocInfoINTEL.html">clGetMemAllocInfoINTEL</a>
    public @NativeType("cl_int") int getMemAllocInfoINTEL(
        @Nullable CLContext context,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        @NativeType("cl_mem_info_intel") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetMemAllocInfoINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                ptr,
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetKernelArgMemPointerINTEL.html">clSetKernelArgMemPointerINTEL</a>
    public @NativeType("cl_int") int setKernelArgMemPointerINTEL(
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int argIndex,
        @Pointer(comment="void*") @NotNull MemorySegment argValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetKernelArgMemPointerINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                argIndex,
                argValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMemsetINTEL.html">clEnqueueMemsetINTEL</a>
    public @NativeType("cl_int") int enqueueMemsetINTEL(
        @Nullable CLCommandQueue command_queue,
        @Pointer(comment="void*") @NotNull MemorySegment dst_ptr,
        @NativeType("cl_int") int value,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMemsetINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                dst_ptr,
                value,
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMemFillINTEL.html">clEnqueueMemFillINTEL</a>
    public @NativeType("cl_int") int enqueueMemFillINTEL(
        @Nullable CLCommandQueue command_queue,
        @Pointer(comment="void*") @NotNull MemorySegment dst_ptr,
        @Pointer(comment="void*") @NotNull MemorySegment pattern,
        long pattern_size,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMemFillINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                dst_ptr,
                pattern,
                MemorySegment.ofAddress(pattern_size),
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMemcpyINTEL.html">clEnqueueMemcpyINTEL</a>
    public @NativeType("cl_int") int enqueueMemcpyINTEL(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_bool") @Unsigned int blocking,
        @Pointer(comment="void*") @NotNull MemorySegment dst_ptr,
        @Pointer(comment="void*") @NotNull MemorySegment src_ptr,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMemcpyINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                blocking,
                dst_ptr,
                src_ptr,
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMigrateMemINTEL.html">clEnqueueMigrateMemINTEL</a>
    public @NativeType("cl_int") int enqueueMigrateMemINTEL(
        @Nullable CLCommandQueue command_queue,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        long size,
        @NativeType("cl_mem_migration_flags") @Unsigned long flags,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMigrateMemINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                ptr,
                MemorySegment.ofAddress(size),
                flags,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMemAdviseINTEL.html">clEnqueueMemAdviseINTEL</a>
    public @NativeType("cl_int") int enqueueMemAdviseINTEL(
        @Nullable CLCommandQueue command_queue,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        long size,
        @NativeType("cl_mem_advice_intel") @Unsigned int advice,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMemAdviseINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                ptr,
                MemorySegment.ofAddress(size),
                advice,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateBufferWithPropertiesINTEL.html">clCreateBufferWithPropertiesINTEL</a>
    public @Nullable CLMem createBufferWithPropertiesINTEL(
        @Nullable CLContext context,
        @Nullable @Pointer(comment="cl_mem_properties_intel") @Unsigned LongPtr properties,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        long size,
        @Pointer(comment="void*") @NotNull MemorySegment host_ptr,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateBufferWithPropertiesINTEL);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                flags,
                MemorySegment.ofAddress(size),
                host_ptr,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateCommandBufferKHR.html">clCreateCommandBufferKHR</a>
    public @Nullable CLCommandBufferKhr createCommandBufferKHR(
        @NativeType("cl_uint") @Unsigned int num_queues,
        @Nullable @Pointer CLCommandQueue.Ptr queues,
        @Nullable @Pointer(comment="cl_command_buffer_properties_khr") @Unsigned LongPtr properties,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateCommandBufferKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                num_queues,
                (MemorySegment) (queues != null ? queues.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLCommandBufferKhr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clFinalizeCommandBufferKHR.html">clFinalizeCommandBufferKHR</a>
    public @NativeType("cl_int") int finalizeCommandBufferKHR(
        @Nullable CLCommandBufferKhr command_buffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clFinalizeCommandBufferKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainCommandBufferKHR.html">clRetainCommandBufferKHR</a>
    public @NativeType("cl_int") int retainCommandBufferKHR(
        @Nullable CLCommandBufferKhr command_buffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainCommandBufferKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseCommandBufferKHR.html">clReleaseCommandBufferKHR</a>
    public @NativeType("cl_int") int releaseCommandBufferKHR(
        @Nullable CLCommandBufferKhr command_buffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseCommandBufferKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueCommandBufferKHR.html">clEnqueueCommandBufferKHR</a>
    public @NativeType("cl_int") int enqueueCommandBufferKHR(
        @NativeType("cl_uint") @Unsigned int num_queues,
        @Nullable @Pointer CLCommandQueue.Ptr queues,
        @Nullable CLCommandBufferKhr command_buffer,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueCommandBufferKHR);
        try {
            return (int) hFunction.invokeExact(
                num_queues,
                (MemorySegment) (queues != null ? queues.segment() : MemorySegment.NULL),
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandBarrierWithWaitListKHR.html">clCommandBarrierWithWaitListKHR</a>
    public @NativeType("cl_int") int commandBarrierWithWaitListKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandBarrierWithWaitListKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandCopyBufferKHR.html">clCommandCopyBufferKHR</a>
    public @NativeType("cl_int") int commandCopyBufferKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Nullable CLMem src_buffer,
        @Nullable CLMem dst_buffer,
        long src_offset,
        long dst_offset,
        long size,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandCopyBufferKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (src_buffer != null ? src_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_buffer != null ? dst_buffer.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(src_offset),
                MemorySegment.ofAddress(dst_offset),
                MemorySegment.ofAddress(size),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandCopyBufferRectKHR.html">clCommandCopyBufferRectKHR</a>
    public @NativeType("cl_int") int commandCopyBufferRectKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Nullable CLMem src_buffer,
        @Nullable CLMem dst_buffer,
        @Nullable PointerPtr src_origin,
        @Nullable PointerPtr dst_origin,
        @Nullable PointerPtr region,
        long src_row_pitch,
        long src_slice_pitch,
        long dst_row_pitch,
        long dst_slice_pitch,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandCopyBufferRectKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (src_buffer != null ? src_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_buffer != null ? dst_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (src_origin != null ? src_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_origin != null ? dst_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(src_row_pitch),
                MemorySegment.ofAddress(src_slice_pitch),
                MemorySegment.ofAddress(dst_row_pitch),
                MemorySegment.ofAddress(dst_slice_pitch),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandCopyBufferToImageKHR.html">clCommandCopyBufferToImageKHR</a>
    public @NativeType("cl_int") int commandCopyBufferToImageKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Nullable CLMem src_buffer,
        @Nullable CLMem dst_image,
        long src_offset,
        @Nullable PointerPtr dst_origin,
        @Nullable PointerPtr region,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandCopyBufferToImageKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (src_buffer != null ? src_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_image != null ? dst_image.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(src_offset),
                (MemorySegment) (dst_origin != null ? dst_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandCopyImageKHR.html">clCommandCopyImageKHR</a>
    public @NativeType("cl_int") int commandCopyImageKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Nullable CLMem src_image,
        @Nullable CLMem dst_image,
        @Nullable PointerPtr src_origin,
        @Nullable PointerPtr dst_origin,
        @Nullable PointerPtr region,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandCopyImageKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (src_image != null ? src_image.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_image != null ? dst_image.segment() : MemorySegment.NULL),
                (MemorySegment) (src_origin != null ? src_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_origin != null ? dst_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandCopyImageToBufferKHR.html">clCommandCopyImageToBufferKHR</a>
    public @NativeType("cl_int") int commandCopyImageToBufferKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Nullable CLMem src_image,
        @Nullable CLMem dst_buffer,
        @Nullable PointerPtr src_origin,
        @Nullable PointerPtr region,
        long dst_offset,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandCopyImageToBufferKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (src_image != null ? src_image.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_buffer != null ? dst_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (src_origin != null ? src_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(dst_offset),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandFillBufferKHR.html">clCommandFillBufferKHR</a>
    public @NativeType("cl_int") int commandFillBufferKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Nullable CLMem buffer,
        @Pointer(comment="void*") @NotNull MemorySegment pattern,
        long pattern_size,
        long offset,
        long size,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandFillBufferKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                pattern,
                MemorySegment.ofAddress(pattern_size),
                MemorySegment.ofAddress(offset),
                MemorySegment.ofAddress(size),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandFillImageKHR.html">clCommandFillImageKHR</a>
    public @NativeType("cl_int") int commandFillImageKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Nullable CLMem image,
        @Pointer(comment="void*") @NotNull MemorySegment fill_color,
        @Nullable PointerPtr origin,
        @Nullable PointerPtr region,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandFillImageKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (image != null ? image.segment() : MemorySegment.NULL),
                fill_color,
                (MemorySegment) (origin != null ? origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandNDRangeKernelKHR.html">clCommandNDRangeKernelKHR</a>
    public @NativeType("cl_int") int commandNDRangeKernelKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int workDim,
        @Nullable PointerPtr globalWorkOffset,
        @Nullable PointerPtr globalWorkSize,
        @Nullable PointerPtr localWorkSize,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandNDRangeKernelKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                workDim,
                (MemorySegment) (globalWorkOffset != null ? globalWorkOffset.segment() : MemorySegment.NULL),
                (MemorySegment) (globalWorkSize != null ? globalWorkSize.segment() : MemorySegment.NULL),
                (MemorySegment) (localWorkSize != null ? localWorkSize.segment() : MemorySegment.NULL),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandSVMMemcpyKHR.html">clCommandSVMMemcpyKHR</a>
    public @NativeType("cl_int") int commandSVMMemcpyKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Pointer(comment="void*") @NotNull MemorySegment dst_ptr,
        @Pointer(comment="void*") @NotNull MemorySegment src_ptr,
        long size,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandSVMMemcpyKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                dst_ptr,
                src_ptr,
                MemorySegment.ofAddress(size),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCommandSVMMemFillKHR.html">clCommandSVMMemFillKHR</a>
    public @NativeType("cl_int") int commandSVMMemFillKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer(comment="cl_command_properties_khr") @Unsigned LongPtr properties,
        @Pointer(comment="void*") @NotNull MemorySegment svm_ptr,
        @Pointer(comment="void*") @NotNull MemorySegment pattern,
        long pattern_size,
        long size,
        @NativeType("cl_uint") @Unsigned int num_sync_points_in_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point_wait_list,
        @Nullable @Pointer(comment="cl_sync_point_khr") @Unsigned IntPtr sync_point,
        @Nullable @Pointer CLMutableCommandKhr.Ptr mutable_handle
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCommandSVMMemFillKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                svm_ptr,
                pattern,
                MemorySegment.ofAddress(pattern_size),
                MemorySegment.ofAddress(size),
                num_sync_points_in_wait_list,
                (MemorySegment) (sync_point_wait_list != null ? sync_point_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (sync_point != null ? sync_point.segment() : MemorySegment.NULL),
                (MemorySegment) (mutable_handle != null ? mutable_handle.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetCommandBufferInfoKHR.html">clGetCommandBufferInfoKHR</a>
    public @NativeType("cl_int") int getCommandBufferInfoKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @NativeType("cl_command_buffer_info_khr") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetCommandBufferInfoKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clUpdateMutableCommandsKHR.html">clUpdateMutableCommandsKHR</a>
    public @NativeType("cl_int") int updateMutableCommandsKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @NativeType("cl_uint") @Unsigned int num_configs,
        @Nullable @Pointer(comment="cl_command_buffer_update_type_khr") @Unsigned IntPtr config_types,
        @Nullable PointerPtr configs
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clUpdateMutableCommandsKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                num_configs,
                (MemorySegment) (config_types != null ? config_types.segment() : MemorySegment.NULL),
                (MemorySegment) (configs != null ? configs.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetMutableCommandInfoKHR.html">clGetMutableCommandInfoKHR</a>
    public @NativeType("cl_int") int getMutableCommandInfoKHR(
        @Nullable CLMutableCommandKhr command,
        @NativeType("cl_mutable_command_info_khr") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetMutableCommandInfoKHR);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command != null ? command.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRemapCommandBufferKHR.html">clRemapCommandBufferKHR</a>
    public @Nullable CLCommandBufferKhr remapCommandBufferKHR(
        @Nullable CLCommandBufferKhr command_buffer,
        @NativeType("cl_bool") @Unsigned int automatic,
        @NativeType("cl_uint") @Unsigned int num_queues,
        @Nullable @Pointer CLCommandQueue.Ptr queues,
        @NativeType("cl_uint") @Unsigned int num_handles,
        @Nullable @Pointer CLMutableCommandKhr.Ptr handles,
        @Nullable @Pointer CLMutableCommandKhr.Ptr handles_ret,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRemapCommandBufferKHR);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (command_buffer != null ? command_buffer.segment() : MemorySegment.NULL),
                automatic,
                num_queues,
                (MemorySegment) (queues != null ? queues.segment() : MemorySegment.NULL),
                num_handles,
                (MemorySegment) (handles != null ? handles.segment() : MemorySegment.NULL),
                (MemorySegment) (handles_ret != null ? handles_ret.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLCommandBufferKhr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetContentSizeBufferPoCL.html">clSetContentSizeBufferPoCL</a>
    public @NativeType("cl_int") int setContentSizeBufferPoCL(
        @Nullable CLMem buffer,
        @Nullable CLMem content_size_buffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetContentSizeBufferPoCL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (content_size_buffer != null ? content_size_buffer.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetPlatformIDs.html">clGetPlatformIDs</a>
    public @NativeType("cl_int") int getPlatformIDs(
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLPlatformId.Ptr platforms,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_platforms
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetPlatformIDs);
        try {
            return (int) hFunction.invokeExact(
                num_entries,
                (MemorySegment) (platforms != null ? platforms.segment() : MemorySegment.NULL),
                (MemorySegment) (num_platforms != null ? num_platforms.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetPlatformInfo.html">clGetPlatformInfo</a>
    public @NativeType("cl_int") int getPlatformInfo(
        @Nullable CLPlatformId platform,
        @NativeType("cl_platform_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetPlatformInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetDeviceIDs.html">clGetDeviceIDs</a>
    public @NativeType("cl_int") int getDeviceIDs(
        @Nullable CLPlatformId platform,
        @NativeType("cl_device_type") @Unsigned long device_type,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLDeviceId.Ptr devices,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_devices
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetDeviceIDs);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                device_type,
                num_entries,
                (MemorySegment) (devices != null ? devices.segment() : MemorySegment.NULL),
                (MemorySegment) (num_devices != null ? num_devices.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetDeviceInfo.html">clGetDeviceInfo</a>
    public @NativeType("cl_int") int getDeviceInfo(
        @Nullable CLDeviceId device,
        @NativeType("cl_device_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetDeviceInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateSubDevices.html">clCreateSubDevices</a>
    public @NativeType("cl_int") int createSubDevices(
        @Nullable CLDeviceId in_device,
        @Nullable @Pointer(comment="cl_device_partition_property") PointerPtr properties,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr out_devices,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_devices_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateSubDevices);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (in_device != null ? in_device.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                num_devices,
                (MemorySegment) (out_devices != null ? out_devices.segment() : MemorySegment.NULL),
                (MemorySegment) (num_devices_ret != null ? num_devices_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainDevice.html">clRetainDevice</a>
    public @NativeType("cl_int") int retainDevice(
        @Nullable CLDeviceId device
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainDevice);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseDevice.html">clReleaseDevice</a>
    public @NativeType("cl_int") int releaseDevice(
        @Nullable CLDeviceId device
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseDevice);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetDefaultDeviceCommandQueue.html">clSetDefaultDeviceCommandQueue</a>
    public @NativeType("cl_int") int setDefaultDeviceCommandQueue(
        @Nullable CLContext context,
        @Nullable CLDeviceId device,
        @Nullable CLCommandQueue command_queue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetDefaultDeviceCommandQueue);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetDeviceAndHostTimer.html">clGetDeviceAndHostTimer</a>
    public @NativeType("cl_int") int getDeviceAndHostTimer(
        @Nullable CLDeviceId device,
        @Nullable @Pointer(comment="cl_ulong") @Unsigned LongPtr device_timestamp,
        @Nullable @Pointer(comment="cl_ulong") @Unsigned LongPtr host_timestamp
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetDeviceAndHostTimer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                (MemorySegment) (device_timestamp != null ? device_timestamp.segment() : MemorySegment.NULL),
                (MemorySegment) (host_timestamp != null ? host_timestamp.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetHostTimer.html">clGetHostTimer</a>
    public @NativeType("cl_int") int getHostTimer(
        @Nullable CLDeviceId device,
        @Nullable @Pointer(comment="cl_ulong") @Unsigned LongPtr host_timestamp
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetHostTimer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                (MemorySegment) (host_timestamp != null ? host_timestamp.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateContext.html">clCreateContext</a>
    public @Nullable CLContext createContext(
        @Nullable @Pointer(comment="cl_context_properties") PointerPtr properties,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr devices,
        @Pointer(comment="pfn_notify_0") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateContext);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                num_devices,
                (MemorySegment) (devices != null ? devices.segment() : MemorySegment.NULL),
                pfn_notify,
                user_data,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLContext(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable CLContext createContext(
        Arena arena,
        @Nullable @Pointer(comment="cl_context_properties") PointerPtr properties,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr devices,
        Ipfn_notify_0 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        return createContext(
            properties,
            num_devices,
            devices,
            Ipfn_notify_0.ofNative(arena, pfn_notify),
            user_data,
            errcode_ret
        );
    }

    public @Nullable CLContext createContext(
        @Nullable @Pointer(comment="cl_context_properties") PointerPtr properties,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr devices,
        Ipfn_notify_0 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        return createContext(
            Arena.global(),
            properties,
            num_devices,
            devices,
            pfn_notify,
            user_data,
            errcode_ret
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateContextFromType.html">clCreateContextFromType</a>
    public @Nullable CLContext createContextFromType(
        @Nullable @Pointer(comment="cl_context_properties") PointerPtr properties,
        @NativeType("cl_device_type") @Unsigned long device_type,
        @Pointer(comment="pfn_notify_1") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateContextFromType);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                device_type,
                pfn_notify,
                user_data,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLContext(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable CLContext createContextFromType(
        Arena arena,
        @Nullable @Pointer(comment="cl_context_properties") PointerPtr properties,
        @NativeType("cl_device_type") @Unsigned long device_type,
        Ipfn_notify_1 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        return createContextFromType(
            properties,
            device_type,
            Ipfn_notify_1.ofNative(arena, pfn_notify),
            user_data,
            errcode_ret
        );
    }

    public @Nullable CLContext createContextFromType(
        @Nullable @Pointer(comment="cl_context_properties") PointerPtr properties,
        @NativeType("cl_device_type") @Unsigned long device_type,
        Ipfn_notify_1 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        return createContextFromType(
            Arena.global(),
            properties,
            device_type,
            pfn_notify,
            user_data,
            errcode_ret
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainContext.html">clRetainContext</a>
    public @NativeType("cl_int") int retainContext(
        @Nullable CLContext context
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainContext);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseContext.html">clReleaseContext</a>
    public @NativeType("cl_int") int releaseContext(
        @Nullable CLContext context
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseContext);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetContextInfo.html">clGetContextInfo</a>
    public @NativeType("cl_int") int getContextInfo(
        @Nullable CLContext context,
        @NativeType("cl_context_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetContextInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetContextDestructorCallback.html">clSetContextDestructorCallback</a>
    public @NativeType("cl_int") int setContextDestructorCallback(
        @Nullable CLContext context,
        @Pointer(comment="pfn_notify_2") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetContextDestructorCallback);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                pfn_notify,
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int setContextDestructorCallback(
        Arena arena,
        @Nullable CLContext context,
        Ipfn_notify_2 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setContextDestructorCallback(
            context,
            Ipfn_notify_2.ofNative(arena, pfn_notify),
            user_data
        );
    }

    public @NativeType("cl_int") int setContextDestructorCallback(
        @Nullable CLContext context,
        Ipfn_notify_2 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setContextDestructorCallback(
            Arena.global(),
            context,
            pfn_notify,
            user_data
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateCommandQueueWithProperties.html">clCreateCommandQueueWithProperties</a>
    public @Nullable CLCommandQueue createCommandQueueWithProperties(
        @Nullable CLContext context,
        @Nullable CLDeviceId device,
        @Nullable @Pointer(comment="cl_queue_properties") @Unsigned LongPtr properties,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateCommandQueueWithProperties);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLCommandQueue(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainCommandQueue.html">clRetainCommandQueue</a>
    public @NativeType("cl_int") int retainCommandQueue(
        @Nullable CLCommandQueue command_queue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainCommandQueue);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseCommandQueue.html">clReleaseCommandQueue</a>
    public @NativeType("cl_int") int releaseCommandQueue(
        @Nullable CLCommandQueue command_queue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseCommandQueue);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetCommandQueueInfo.html">clGetCommandQueueInfo</a>
    public @NativeType("cl_int") int getCommandQueueInfo(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_command_queue_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetCommandQueueInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateBuffer.html">clCreateBuffer</a>
    public @Nullable CLMem createBuffer(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        long size,
        @Pointer(comment="void*") @NotNull MemorySegment host_ptr,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateBuffer);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                MemorySegment.ofAddress(size),
                host_ptr,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateBufferWithProperties.html">clCreateBufferWithProperties</a>
    public @Nullable CLMem createBufferWithProperties(
        @Nullable CLContext context,
        @Nullable @Pointer(comment="cl_mem_properties") @Unsigned LongPtr properties,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        long size,
        @Pointer(comment="void*") @NotNull MemorySegment host_ptr,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateBufferWithProperties);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                flags,
                MemorySegment.ofAddress(size),
                host_ptr,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateSubBuffer.html">clCreateSubBuffer</a>
    public @Nullable CLMem createSubBuffer(
        @Nullable CLMem buffer,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_buffer_create_type") @Unsigned int buffer_create_type,
        @Pointer(comment="void*") @NotNull MemorySegment buffer_create_info,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateSubBuffer);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                flags,
                buffer_create_type,
                buffer_create_info,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateImage.html">clCreateImage</a>
    public @Nullable CLMem createImage(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable @Pointer CLImageFormat image_format,
        @Nullable @Pointer CLImageDesc image_desc,
        @Pointer(comment="void*") @NotNull MemorySegment host_ptr,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateImage);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (image_format != null ? image_format.segment() : MemorySegment.NULL),
                (MemorySegment) (image_desc != null ? image_desc.segment() : MemorySegment.NULL),
                host_ptr,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateImageWithProperties.html">clCreateImageWithProperties</a>
    public @Nullable CLMem createImageWithProperties(
        @Nullable CLContext context,
        @Nullable @Pointer(comment="cl_mem_properties") @Unsigned LongPtr properties,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable @Pointer CLImageFormat image_format,
        @Nullable @Pointer CLImageDesc image_desc,
        @Pointer(comment="void*") @NotNull MemorySegment host_ptr,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateImageWithProperties);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (image_format != null ? image_format.segment() : MemorySegment.NULL),
                (MemorySegment) (image_desc != null ? image_desc.segment() : MemorySegment.NULL),
                host_ptr,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreatePipe.html">clCreatePipe</a>
    public @Nullable CLMem createPipe(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_uint") @Unsigned int pipe_packet_size,
        @NativeType("cl_uint") @Unsigned int pipe_max_packets,
        @Nullable @Pointer(comment="cl_pipe_properties") PointerPtr properties,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreatePipe);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                pipe_packet_size,
                pipe_max_packets,
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainMemObject.html">clRetainMemObject</a>
    public @NativeType("cl_int") int retainMemObject(
        @Nullable CLMem memobj
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainMemObject);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (memobj != null ? memobj.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseMemObject.html">clReleaseMemObject</a>
    public @NativeType("cl_int") int releaseMemObject(
        @Nullable CLMem memobj
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseMemObject);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (memobj != null ? memobj.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetSupportedImageFormats.html">clGetSupportedImageFormats</a>
    public @NativeType("cl_int") int getSupportedImageFormats(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_mem_object_type") @Unsigned int imageType,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer CLImageFormat image_formats,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_image_formats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetSupportedImageFormats);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                imageType,
                num_entries,
                (MemorySegment) (image_formats != null ? image_formats.segment() : MemorySegment.NULL),
                (MemorySegment) (num_image_formats != null ? num_image_formats.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetMemObjectInfo.html">clGetMemObjectInfo</a>
    public @NativeType("cl_int") int getMemObjectInfo(
        @Nullable CLMem memobj,
        @NativeType("cl_mem_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetMemObjectInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (memobj != null ? memobj.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetImageInfo.html">clGetImageInfo</a>
    public @NativeType("cl_int") int getImageInfo(
        @Nullable CLMem image,
        @NativeType("cl_image_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetImageInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (image != null ? image.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetPipeInfo.html">clGetPipeInfo</a>
    public @NativeType("cl_int") int getPipeInfo(
        @Nullable CLMem pipe,
        @NativeType("cl_pipe_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetPipeInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (pipe != null ? pipe.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetMemObjectDestructorCallback.html">clSetMemObjectDestructorCallback</a>
    public @NativeType("cl_int") int setMemObjectDestructorCallback(
        @Nullable CLMem memobj,
        @Pointer(comment="pfn_notify_3") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetMemObjectDestructorCallback);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (memobj != null ? memobj.segment() : MemorySegment.NULL),
                pfn_notify,
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int setMemObjectDestructorCallback(
        Arena arena,
        @Nullable CLMem memobj,
        Ipfn_notify_3 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setMemObjectDestructorCallback(
            memobj,
            Ipfn_notify_3.ofNative(arena, pfn_notify),
            user_data
        );
    }

    public @NativeType("cl_int") int setMemObjectDestructorCallback(
        @Nullable CLMem memobj,
        Ipfn_notify_3 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setMemObjectDestructorCallback(
            Arena.global(),
            memobj,
            pfn_notify,
            user_data
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetMemObjectDestructorAPPLE.html">clSetMemObjectDestructorAPPLE</a>
    public @NativeType("cl_int") int setMemObjectDestructorAPPLE(
        @Nullable CLMem memobj,
        @Pointer(comment="pfn_notify_4") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetMemObjectDestructorAPPLE);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (memobj != null ? memobj.segment() : MemorySegment.NULL),
                pfn_notify,
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int setMemObjectDestructorAPPLE(
        Arena arena,
        @Nullable CLMem memobj,
        Ipfn_notify_4 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setMemObjectDestructorAPPLE(
            memobj,
            Ipfn_notify_4.ofNative(arena, pfn_notify),
            user_data
        );
    }

    public @NativeType("cl_int") int setMemObjectDestructorAPPLE(
        @Nullable CLMem memobj,
        Ipfn_notify_4 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setMemObjectDestructorAPPLE(
            Arena.global(),
            memobj,
            pfn_notify,
            user_data
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSVMAlloc.html">clSVMAlloc</a>
    public @Pointer(comment="void*") @NotNull MemorySegment SVMAlloc(
        @Nullable CLContext context,
        @NativeType("cl_svm_mem_flags") @Unsigned long flags,
        long size,
        @NativeType("cl_uint") @Unsigned int alignment
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSVMAlloc);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                MemorySegment.ofAddress(size),
                alignment
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSVMFree.html">clSVMFree</a>
    public void SVMFree(
        @Nullable CLContext context,
        @Pointer(comment="void*") @NotNull MemorySegment svm_pointer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSVMFree);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                svm_pointer
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateSamplerWithProperties.html">clCreateSamplerWithProperties</a>
    public @Nullable CLSampler createSamplerWithProperties(
        @Nullable CLContext context,
        @Nullable @Pointer(comment="cl_sampler_properties") @Unsigned LongPtr sampler_properties,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateSamplerWithProperties);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (sampler_properties != null ? sampler_properties.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLSampler(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainSampler.html">clRetainSampler</a>
    public @NativeType("cl_int") int retainSampler(
        @Nullable CLSampler sampler
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainSampler);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (sampler != null ? sampler.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseSampler.html">clReleaseSampler</a>
    public @NativeType("cl_int") int releaseSampler(
        @Nullable CLSampler sampler
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseSampler);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (sampler != null ? sampler.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetSamplerInfo.html">clGetSamplerInfo</a>
    public @NativeType("cl_int") int getSamplerInfo(
        @Nullable CLSampler sampler,
        @NativeType("cl_sampler_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetSamplerInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (sampler != null ? sampler.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateProgramWithSource.html">clCreateProgramWithSource</a>
    public @Nullable CLProgram createProgramWithSource(
        @Nullable CLContext context,
        @NativeType("cl_uint") @Unsigned int count,
        @Nullable PointerPtr strings,
        @Nullable PointerPtr lengths,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateProgramWithSource);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                count,
                (MemorySegment) (strings != null ? strings.segment() : MemorySegment.NULL),
                (MemorySegment) (lengths != null ? lengths.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLProgram(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateProgramWithBinary.html">clCreateProgramWithBinary</a>
    public @Nullable CLProgram createProgramWithBinary(
        @Nullable CLContext context,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable PointerPtr lengths,
        @Nullable PointerPtr binaries,
        @Nullable @Pointer(comment="cl_int") IntPtr binary_status,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateProgramWithBinary);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                num_devices,
                (MemorySegment) (device_list != null ? device_list.segment() : MemorySegment.NULL),
                (MemorySegment) (lengths != null ? lengths.segment() : MemorySegment.NULL),
                (MemorySegment) (binaries != null ? binaries.segment() : MemorySegment.NULL),
                (MemorySegment) (binary_status != null ? binary_status.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLProgram(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateProgramWithBuiltInKernels.html">clCreateProgramWithBuiltInKernels</a>
    public @Nullable CLProgram createProgramWithBuiltInKernels(
        @Nullable CLContext context,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr kernel_names,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateProgramWithBuiltInKernels);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                num_devices,
                (MemorySegment) (device_list != null ? device_list.segment() : MemorySegment.NULL),
                (MemorySegment) (kernel_names != null ? kernel_names.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLProgram(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateProgramWithIL.html">clCreateProgramWithIL</a>
    public @Nullable CLProgram createProgramWithIL(
        @Nullable CLContext context,
        @Pointer(comment="void*") @NotNull MemorySegment il,
        long length,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateProgramWithIL);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                il,
                MemorySegment.ofAddress(length),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLProgram(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainProgram.html">clRetainProgram</a>
    public @NativeType("cl_int") int retainProgram(
        @Nullable CLProgram program
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainProgram);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseProgram.html">clReleaseProgram</a>
    public @NativeType("cl_int") int releaseProgram(
        @Nullable CLProgram program
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseProgram);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clBuildProgram.html">clBuildProgram</a>
    public @NativeType("cl_int") int buildProgram(
        @Nullable CLProgram program,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr options,
        @Pointer(comment="pfn_notify_5") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clBuildProgram);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                num_devices,
                (MemorySegment) (device_list != null ? device_list.segment() : MemorySegment.NULL),
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                pfn_notify,
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int buildProgram(
        Arena arena,
        @Nullable CLProgram program,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr options,
        Ipfn_notify_5 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return buildProgram(
            program,
            num_devices,
            device_list,
            options,
            Ipfn_notify_5.ofNative(arena, pfn_notify),
            user_data
        );
    }

    public @NativeType("cl_int") int buildProgram(
        @Nullable CLProgram program,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr options,
        Ipfn_notify_5 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return buildProgram(
            Arena.global(),
            program,
            num_devices,
            device_list,
            options,
            pfn_notify,
            user_data
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCompileProgram.html">clCompileProgram</a>
    public @NativeType("cl_int") int compileProgram(
        @Nullable CLProgram program,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr options,
        @NativeType("cl_uint") @Unsigned int num_input_headers,
        @Nullable @Pointer CLProgram.Ptr input_headers,
        @Nullable PointerPtr header_include_names,
        @Pointer(comment="pfn_notify_6") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCompileProgram);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                num_devices,
                (MemorySegment) (device_list != null ? device_list.segment() : MemorySegment.NULL),
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                num_input_headers,
                (MemorySegment) (input_headers != null ? input_headers.segment() : MemorySegment.NULL),
                (MemorySegment) (header_include_names != null ? header_include_names.segment() : MemorySegment.NULL),
                pfn_notify,
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int compileProgram(
        Arena arena,
        @Nullable CLProgram program,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr options,
        @NativeType("cl_uint") @Unsigned int num_input_headers,
        @Nullable @Pointer CLProgram.Ptr input_headers,
        @Nullable PointerPtr header_include_names,
        Ipfn_notify_6 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return compileProgram(
            program,
            num_devices,
            device_list,
            options,
            num_input_headers,
            input_headers,
            header_include_names,
            Ipfn_notify_6.ofNative(arena, pfn_notify),
            user_data
        );
    }

    public @NativeType("cl_int") int compileProgram(
        @Nullable CLProgram program,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr options,
        @NativeType("cl_uint") @Unsigned int num_input_headers,
        @Nullable @Pointer CLProgram.Ptr input_headers,
        @Nullable PointerPtr header_include_names,
        Ipfn_notify_6 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return compileProgram(
            Arena.global(),
            program,
            num_devices,
            device_list,
            options,
            num_input_headers,
            input_headers,
            header_include_names,
            pfn_notify,
            user_data
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clLinkProgram.html">clLinkProgram</a>
    public @Nullable CLProgram linkProgram(
        @Nullable CLContext context,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr options,
        @NativeType("cl_uint") @Unsigned int num_input_programs,
        @Nullable @Pointer CLProgram.Ptr input_programs,
        @Pointer(comment="pfn_notify_7") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clLinkProgram);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                num_devices,
                (MemorySegment) (device_list != null ? device_list.segment() : MemorySegment.NULL),
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                num_input_programs,
                (MemorySegment) (input_programs != null ? input_programs.segment() : MemorySegment.NULL),
                pfn_notify,
                user_data,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLProgram(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable CLProgram linkProgram(
        Arena arena,
        @Nullable CLContext context,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr options,
        @NativeType("cl_uint") @Unsigned int num_input_programs,
        @Nullable @Pointer CLProgram.Ptr input_programs,
        Ipfn_notify_7 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        return linkProgram(
            context,
            num_devices,
            device_list,
            options,
            num_input_programs,
            input_programs,
            Ipfn_notify_7.ofNative(arena, pfn_notify),
            user_data,
            errcode_ret
        );
    }

    public @Nullable CLProgram linkProgram(
        @Nullable CLContext context,
        @NativeType("cl_uint") @Unsigned int num_devices,
        @Nullable @Pointer CLDeviceId.Ptr device_list,
        @Nullable BytePtr options,
        @NativeType("cl_uint") @Unsigned int num_input_programs,
        @Nullable @Pointer CLProgram.Ptr input_programs,
        Ipfn_notify_7 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        return linkProgram(
            Arena.global(),
            context,
            num_devices,
            device_list,
            options,
            num_input_programs,
            input_programs,
            pfn_notify,
            user_data,
            errcode_ret
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetProgramReleaseCallback.html">clSetProgramReleaseCallback</a>
    public @NativeType("cl_int") int setProgramReleaseCallback(
        @Nullable CLProgram program,
        @Pointer(comment="pfn_notify_8") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetProgramReleaseCallback);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                pfn_notify,
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int setProgramReleaseCallback(
        Arena arena,
        @Nullable CLProgram program,
        Ipfn_notify_8 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setProgramReleaseCallback(
            program,
            Ipfn_notify_8.ofNative(arena, pfn_notify),
            user_data
        );
    }

    public @NativeType("cl_int") int setProgramReleaseCallback(
        @Nullable CLProgram program,
        Ipfn_notify_8 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setProgramReleaseCallback(
            Arena.global(),
            program,
            pfn_notify,
            user_data
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetProgramSpecializationConstant.html">clSetProgramSpecializationConstant</a>
    public @NativeType("cl_int") int setProgramSpecializationConstant(
        @Nullable CLProgram program,
        @NativeType("cl_uint") @Unsigned int spec_id,
        long spec_size,
        @Pointer(comment="void*") @NotNull MemorySegment spec_value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetProgramSpecializationConstant);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                spec_id,
                MemorySegment.ofAddress(spec_size),
                spec_value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clUnloadPlatformCompiler.html">clUnloadPlatformCompiler</a>
    public @NativeType("cl_int") int unloadPlatformCompiler(
        @Nullable CLPlatformId platform
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clUnloadPlatformCompiler);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetProgramInfo.html">clGetProgramInfo</a>
    public @NativeType("cl_int") int getProgramInfo(
        @Nullable CLProgram program,
        @NativeType("cl_program_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetProgramInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetProgramBuildInfo.html">clGetProgramBuildInfo</a>
    public @NativeType("cl_int") int getProgramBuildInfo(
        @Nullable CLProgram program,
        @Nullable CLDeviceId device,
        @NativeType("cl_program_build_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetProgramBuildInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateKernel.html">clCreateKernel</a>
    public @Nullable CLKernel createKernel(
        @Nullable CLProgram program,
        @Nullable BytePtr kernel_name,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateKernel);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                (MemorySegment) (kernel_name != null ? kernel_name.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLKernel(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateKernelsInProgram.html">clCreateKernelsInProgram</a>
    public @NativeType("cl_int") int createKernelsInProgram(
        @Nullable CLProgram program,
        @NativeType("cl_uint") @Unsigned int num_kernels,
        @Nullable @Pointer CLKernel.Ptr kernels,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_kernels_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateKernelsInProgram);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                num_kernels,
                (MemorySegment) (kernels != null ? kernels.segment() : MemorySegment.NULL),
                (MemorySegment) (num_kernels_ret != null ? num_kernels_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCloneKernel.html">clCloneKernel</a>
    public @Nullable CLKernel cloneKernel(
        @Nullable CLKernel source_kernel,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCloneKernel);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (source_kernel != null ? source_kernel.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLKernel(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainKernel.html">clRetainKernel</a>
    public @NativeType("cl_int") int retainKernel(
        @Nullable CLKernel kernel
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainKernel);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseKernel.html">clReleaseKernel</a>
    public @NativeType("cl_int") int releaseKernel(
        @Nullable CLKernel kernel
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseKernel);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetKernelArg.html">clSetKernelArg</a>
    public @NativeType("cl_int") int setKernelArg(
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int argIndex,
        long argSize,
        @Pointer(comment="void*") @NotNull MemorySegment argValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetKernelArg);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                argIndex,
                MemorySegment.ofAddress(argSize),
                argValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetKernelArgSVMPointer.html">clSetKernelArgSVMPointer</a>
    public @NativeType("cl_int") int setKernelArgSVMPointer(
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int argIndex,
        @Pointer(comment="void*") @NotNull MemorySegment argValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetKernelArgSVMPointer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                argIndex,
                argValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetKernelArgDevicePointerEXT.html">clSetKernelArgDevicePointerEXT</a>
    public @NativeType("cl_int") int setKernelArgDevicePointerEXT(
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int argIndex,
        @NativeType("cl_mem_device_address_ext") @Unsigned long argValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetKernelArgDevicePointerEXT);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                argIndex,
                argValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetKernelExecInfo.html">clSetKernelExecInfo</a>
    public @NativeType("cl_int") int setKernelExecInfo(
        @Nullable CLKernel kernel,
        @NativeType("cl_kernel_exec_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetKernelExecInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetKernelInfo.html">clGetKernelInfo</a>
    public @NativeType("cl_int") int getKernelInfo(
        @Nullable CLKernel kernel,
        @NativeType("cl_kernel_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetKernelInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetKernelArgInfo.html">clGetKernelArgInfo</a>
    public @NativeType("cl_int") int getKernelArgInfo(
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int argIndex,
        @NativeType("cl_kernel_arg_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetKernelArgInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                argIndex,
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetKernelWorkGroupInfo.html">clGetKernelWorkGroupInfo</a>
    public @NativeType("cl_int") int getKernelWorkGroupInfo(
        @Nullable CLKernel kernel,
        @Nullable CLDeviceId device,
        @NativeType("cl_kernel_work_group_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetKernelWorkGroupInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetKernelSubGroupInfo.html">clGetKernelSubGroupInfo</a>
    public @NativeType("cl_int") int getKernelSubGroupInfo(
        @Nullable CLKernel kernel,
        @Nullable CLDeviceId device,
        @NativeType("cl_kernel_sub_group_info") @Unsigned int paramName,
        long input_value_size,
        @Pointer(comment="void*") @NotNull MemorySegment input_value,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetKernelSubGroupInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(input_value_size),
                input_value,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clWaitForEvents.html">clWaitForEvents</a>
    public @NativeType("cl_int") int waitForEvents(
        @NativeType("cl_uint") @Unsigned int num_events,
        @Nullable @Pointer CLEvent.Ptr event_list
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clWaitForEvents);
        try {
            return (int) hFunction.invokeExact(
                num_events,
                (MemorySegment) (event_list != null ? event_list.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetEventInfo.html">clGetEventInfo</a>
    public @NativeType("cl_int") int getEventInfo(
        @Nullable CLEvent event,
        @NativeType("cl_event_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetEventInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateUserEvent.html">clCreateUserEvent</a>
    public @Nullable CLEvent createUserEvent(
        @Nullable CLContext context,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateUserEvent);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLEvent(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clRetainEvent.html">clRetainEvent</a>
    public @NativeType("cl_int") int retainEvent(
        @Nullable CLEvent event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clRetainEvent);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clReleaseEvent.html">clReleaseEvent</a>
    public @NativeType("cl_int") int releaseEvent(
        @Nullable CLEvent event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clReleaseEvent);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetUserEventStatus.html">clSetUserEventStatus</a>
    public @NativeType("cl_int") int setUserEventStatus(
        @Nullable CLEvent event,
        @NativeType("cl_int") int execution_status
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetUserEventStatus);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL),
                execution_status
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetEventCallback.html">clSetEventCallback</a>
    public @NativeType("cl_int") int setEventCallback(
        @Nullable CLEvent event,
        @NativeType("cl_int") int command_exec_callback_type,
        @Pointer(comment="pfn_notify_9") @NotNull MemorySegment pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetEventCallback);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL),
                command_exec_callback_type,
                pfn_notify,
                user_data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int setEventCallback(
        Arena arena,
        @Nullable CLEvent event,
        @NativeType("cl_int") int command_exec_callback_type,
        Ipfn_notify_9 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setEventCallback(
            event,
            command_exec_callback_type,
            Ipfn_notify_9.ofNative(arena, pfn_notify),
            user_data
        );
    }

    public @NativeType("cl_int") int setEventCallback(
        @Nullable CLEvent event,
        @NativeType("cl_int") int command_exec_callback_type,
        Ipfn_notify_9 pfn_notify,
        @Pointer(comment="void*") @NotNull MemorySegment user_data
    ) {
        return setEventCallback(
            Arena.global(),
            event,
            command_exec_callback_type,
            pfn_notify,
            user_data
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetEventProfilingInfo.html">clGetEventProfilingInfo</a>
    public @NativeType("cl_int") int getEventProfilingInfo(
        @Nullable CLEvent event,
        @NativeType("cl_profiling_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetEventProfilingInfo);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clFlush.html">clFlush</a>
    public @NativeType("cl_int") int flush(
        @Nullable CLCommandQueue command_queue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clFlush);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clFinish.html">clFinish</a>
    public @NativeType("cl_int") int finish(
        @Nullable CLCommandQueue command_queue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clFinish);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReadBuffer.html">clEnqueueReadBuffer</a>
    public @NativeType("cl_int") int enqueueReadBuffer(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem buffer,
        @NativeType("cl_bool") @Unsigned int blocking_read,
        long offset,
        long size,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReadBuffer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                blocking_read,
                MemorySegment.ofAddress(offset),
                MemorySegment.ofAddress(size),
                ptr,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReadBufferRect.html">clEnqueueReadBufferRect</a>
    public @NativeType("cl_int") int enqueueReadBufferRect(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem buffer,
        @NativeType("cl_bool") @Unsigned int blocking_read,
        @Nullable PointerPtr buffer_origin,
        @Nullable PointerPtr host_origin,
        @Nullable PointerPtr region,
        long buffer_row_pitch,
        long buffer_slice_pitch,
        long host_row_pitch,
        long host_slice_pitch,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReadBufferRect);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                blocking_read,
                (MemorySegment) (buffer_origin != null ? buffer_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (host_origin != null ? host_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(buffer_row_pitch),
                MemorySegment.ofAddress(buffer_slice_pitch),
                MemorySegment.ofAddress(host_row_pitch),
                MemorySegment.ofAddress(host_slice_pitch),
                ptr,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueWriteBuffer.html">clEnqueueWriteBuffer</a>
    public @NativeType("cl_int") int enqueueWriteBuffer(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem buffer,
        @NativeType("cl_bool") @Unsigned int blocking_write,
        long offset,
        long size,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueWriteBuffer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                blocking_write,
                MemorySegment.ofAddress(offset),
                MemorySegment.ofAddress(size),
                ptr,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueWriteBufferRect.html">clEnqueueWriteBufferRect</a>
    public @NativeType("cl_int") int enqueueWriteBufferRect(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem buffer,
        @NativeType("cl_bool") @Unsigned int blocking_write,
        @Nullable PointerPtr buffer_origin,
        @Nullable PointerPtr host_origin,
        @Nullable PointerPtr region,
        long buffer_row_pitch,
        long buffer_slice_pitch,
        long host_row_pitch,
        long host_slice_pitch,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueWriteBufferRect);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                blocking_write,
                (MemorySegment) (buffer_origin != null ? buffer_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (host_origin != null ? host_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(buffer_row_pitch),
                MemorySegment.ofAddress(buffer_slice_pitch),
                MemorySegment.ofAddress(host_row_pitch),
                MemorySegment.ofAddress(host_slice_pitch),
                ptr,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueFillBuffer.html">clEnqueueFillBuffer</a>
    public @NativeType("cl_int") int enqueueFillBuffer(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem buffer,
        @Pointer(comment="void*") @NotNull MemorySegment pattern,
        long pattern_size,
        long offset,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueFillBuffer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                pattern,
                MemorySegment.ofAddress(pattern_size),
                MemorySegment.ofAddress(offset),
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueCopyBuffer.html">clEnqueueCopyBuffer</a>
    public @NativeType("cl_int") int enqueueCopyBuffer(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem src_buffer,
        @Nullable CLMem dst_buffer,
        long src_offset,
        long dst_offset,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueCopyBuffer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (src_buffer != null ? src_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_buffer != null ? dst_buffer.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(src_offset),
                MemorySegment.ofAddress(dst_offset),
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueCopyBufferRect.html">clEnqueueCopyBufferRect</a>
    public @NativeType("cl_int") int enqueueCopyBufferRect(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem src_buffer,
        @Nullable CLMem dst_buffer,
        @Nullable PointerPtr src_origin,
        @Nullable PointerPtr dst_origin,
        @Nullable PointerPtr region,
        long src_row_pitch,
        long src_slice_pitch,
        long dst_row_pitch,
        long dst_slice_pitch,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueCopyBufferRect);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (src_buffer != null ? src_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_buffer != null ? dst_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (src_origin != null ? src_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_origin != null ? dst_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(src_row_pitch),
                MemorySegment.ofAddress(src_slice_pitch),
                MemorySegment.ofAddress(dst_row_pitch),
                MemorySegment.ofAddress(dst_slice_pitch),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReadImage.html">clEnqueueReadImage</a>
    public @NativeType("cl_int") int enqueueReadImage(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem image,
        @NativeType("cl_bool") @Unsigned int blocking_read,
        @Nullable PointerPtr origin,
        @Nullable PointerPtr region,
        long row_pitch,
        long slice_pitch,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReadImage);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (image != null ? image.segment() : MemorySegment.NULL),
                blocking_read,
                (MemorySegment) (origin != null ? origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(row_pitch),
                MemorySegment.ofAddress(slice_pitch),
                ptr,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueWriteImage.html">clEnqueueWriteImage</a>
    public @NativeType("cl_int") int enqueueWriteImage(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem image,
        @NativeType("cl_bool") @Unsigned int blocking_write,
        @Nullable PointerPtr origin,
        @Nullable PointerPtr region,
        long input_row_pitch,
        long input_slice_pitch,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueWriteImage);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (image != null ? image.segment() : MemorySegment.NULL),
                blocking_write,
                (MemorySegment) (origin != null ? origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(input_row_pitch),
                MemorySegment.ofAddress(input_slice_pitch),
                ptr,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueFillImage.html">clEnqueueFillImage</a>
    public @NativeType("cl_int") int enqueueFillImage(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem image,
        @Pointer(comment="void*") @NotNull MemorySegment fill_color,
        @Nullable PointerPtr origin,
        @Nullable PointerPtr region,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueFillImage);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (image != null ? image.segment() : MemorySegment.NULL),
                fill_color,
                (MemorySegment) (origin != null ? origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueCopyImage.html">clEnqueueCopyImage</a>
    public @NativeType("cl_int") int enqueueCopyImage(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem src_image,
        @Nullable CLMem dst_image,
        @Nullable PointerPtr src_origin,
        @Nullable PointerPtr dst_origin,
        @Nullable PointerPtr region,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueCopyImage);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (src_image != null ? src_image.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_image != null ? dst_image.segment() : MemorySegment.NULL),
                (MemorySegment) (src_origin != null ? src_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_origin != null ? dst_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueCopyImageToBuffer.html">clEnqueueCopyImageToBuffer</a>
    public @NativeType("cl_int") int enqueueCopyImageToBuffer(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem src_image,
        @Nullable CLMem dst_buffer,
        @Nullable PointerPtr src_origin,
        @Nullable PointerPtr region,
        long dst_offset,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueCopyImageToBuffer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (src_image != null ? src_image.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_buffer != null ? dst_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (src_origin != null ? src_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(dst_offset),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueCopyBufferToImage.html">clEnqueueCopyBufferToImage</a>
    public @NativeType("cl_int") int enqueueCopyBufferToImage(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem src_buffer,
        @Nullable CLMem dst_image,
        long src_offset,
        @Nullable PointerPtr dst_origin,
        @Nullable PointerPtr region,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueCopyBufferToImage);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (src_buffer != null ? src_buffer.segment() : MemorySegment.NULL),
                (MemorySegment) (dst_image != null ? dst_image.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(src_offset),
                (MemorySegment) (dst_origin != null ? dst_origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMapBuffer.html">clEnqueueMapBuffer</a>
    public @Pointer(comment="void*") @NotNull MemorySegment enqueueMapBuffer(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem buffer,
        @NativeType("cl_bool") @Unsigned int blocking_map,
        @NativeType("cl_map_flags") @Unsigned long map_flags,
        long offset,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMapBuffer);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                blocking_map,
                map_flags,
                MemorySegment.ofAddress(offset),
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMapImage.html">clEnqueueMapImage</a>
    public @Pointer(comment="void*") @NotNull MemorySegment enqueueMapImage(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem image,
        @NativeType("cl_bool") @Unsigned int blocking_map,
        @NativeType("cl_map_flags") @Unsigned long map_flags,
        @Nullable PointerPtr origin,
        @Nullable PointerPtr region,
        @Nullable PointerPtr imageRowPitch,
        @Nullable PointerPtr imageSlicePitch,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMapImage);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (image != null ? image.segment() : MemorySegment.NULL),
                blocking_map,
                map_flags,
                (MemorySegment) (origin != null ? origin.segment() : MemorySegment.NULL),
                (MemorySegment) (region != null ? region.segment() : MemorySegment.NULL),
                (MemorySegment) (imageRowPitch != null ? imageRowPitch.segment() : MemorySegment.NULL),
                (MemorySegment) (imageSlicePitch != null ? imageSlicePitch.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL),
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueUnmapMemObject.html">clEnqueueUnmapMemObject</a>
    public @NativeType("cl_int") int enqueueUnmapMemObject(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLMem memobj,
        @Pointer(comment="void*") @NotNull MemorySegment mapped_ptr,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueUnmapMemObject);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (memobj != null ? memobj.segment() : MemorySegment.NULL),
                mapped_ptr,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMigrateMemObjects.html">clEnqueueMigrateMemObjects</a>
    public @NativeType("cl_int") int enqueueMigrateMemObjects(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_mem_objects,
        @Nullable @Pointer CLMem.Ptr mem_objects,
        @NativeType("cl_mem_migration_flags") @Unsigned long flags,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMigrateMemObjects);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_mem_objects,
                (MemorySegment) (mem_objects != null ? mem_objects.segment() : MemorySegment.NULL),
                flags,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueNDRangeKernel.html">clEnqueueNDRangeKernel</a>
    public @NativeType("cl_int") int enqueueNDRangeKernel(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int workDim,
        @Nullable PointerPtr globalWorkOffset,
        @Nullable PointerPtr globalWorkSize,
        @Nullable PointerPtr localWorkSize,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueNDRangeKernel);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                workDim,
                (MemorySegment) (globalWorkOffset != null ? globalWorkOffset.segment() : MemorySegment.NULL),
                (MemorySegment) (globalWorkSize != null ? globalWorkSize.segment() : MemorySegment.NULL),
                (MemorySegment) (localWorkSize != null ? localWorkSize.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueNativeKernel.html">clEnqueueNativeKernel</a>
    public @NativeType("cl_int") int enqueueNativeKernel(
        @Nullable CLCommandQueue command_queue,
        @Pointer(comment="user_func_0") @NotNull MemorySegment user_func,
        @Pointer(comment="void*") @NotNull MemorySegment args,
        long cb_args,
        @NativeType("cl_uint") @Unsigned int num_mem_objects,
        @Nullable @Pointer CLMem.Ptr mem_list,
        @Nullable PointerPtr args_mem_loc,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueNativeKernel);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                user_func,
                args,
                MemorySegment.ofAddress(cb_args),
                num_mem_objects,
                (MemorySegment) (mem_list != null ? mem_list.segment() : MemorySegment.NULL),
                (MemorySegment) (args_mem_loc != null ? args_mem_loc.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int enqueueNativeKernel(
        Arena arena,
        @Nullable CLCommandQueue command_queue,
        Iuser_func_0 user_func,
        @Pointer(comment="void*") @NotNull MemorySegment args,
        long cb_args,
        @NativeType("cl_uint") @Unsigned int num_mem_objects,
        @Nullable @Pointer CLMem.Ptr mem_list,
        @Nullable PointerPtr args_mem_loc,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        return enqueueNativeKernel(
            command_queue,
            Iuser_func_0.ofNative(arena, user_func),
            args,
            cb_args,
            num_mem_objects,
            mem_list,
            args_mem_loc,
            num_events_in_wait_list,
            event_wait_list,
            event
        );
    }

    public @NativeType("cl_int") int enqueueNativeKernel(
        @Nullable CLCommandQueue command_queue,
        Iuser_func_0 user_func,
        @Pointer(comment="void*") @NotNull MemorySegment args,
        long cb_args,
        @NativeType("cl_uint") @Unsigned int num_mem_objects,
        @Nullable @Pointer CLMem.Ptr mem_list,
        @Nullable PointerPtr args_mem_loc,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        return enqueueNativeKernel(
            Arena.global(),
            command_queue,
            user_func,
            args,
            cb_args,
            num_mem_objects,
            mem_list,
            args_mem_loc,
            num_events_in_wait_list,
            event_wait_list,
            event
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMarkerWithWaitList.html">clEnqueueMarkerWithWaitList</a>
    public @NativeType("cl_int") int enqueueMarkerWithWaitList(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMarkerWithWaitList);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueBarrierWithWaitList.html">clEnqueueBarrierWithWaitList</a>
    public @NativeType("cl_int") int enqueueBarrierWithWaitList(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueBarrierWithWaitList);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMFree.html">clEnqueueSVMFree</a>
    public @NativeType("cl_int") int enqueueSVMFree(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_svm_pointers,
        @Pointer(comment="void*") @NotNull MemorySegment svm_pointers,
        @Pointer(comment="pfn_free_func_1") @NotNull MemorySegment pfn_free_func,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMFree);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_svm_pointers,
                svm_pointers,
                pfn_free_func,
                user_data,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("cl_int") int enqueueSVMFree(
        Arena arena,
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_svm_pointers,
        @Pointer(comment="void*") @NotNull MemorySegment svm_pointers,
        Ipfn_free_func_1 pfn_free_func,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        return enqueueSVMFree(
            command_queue,
            num_svm_pointers,
            svm_pointers,
            Ipfn_free_func_1.ofNative(arena, pfn_free_func),
            user_data,
            num_events_in_wait_list,
            event_wait_list,
            event
        );
    }

    public @NativeType("cl_int") int enqueueSVMFree(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_svm_pointers,
        @Pointer(comment="void*") @NotNull MemorySegment svm_pointers,
        Ipfn_free_func_1 pfn_free_func,
        @Pointer(comment="void*") @NotNull MemorySegment user_data,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        return enqueueSVMFree(
            Arena.global(),
            command_queue,
            num_svm_pointers,
            svm_pointers,
            pfn_free_func,
            user_data,
            num_events_in_wait_list,
            event_wait_list,
            event
        );
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMMemcpy.html">clEnqueueSVMMemcpy</a>
    public @NativeType("cl_int") int enqueueSVMMemcpy(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_bool") @Unsigned int blocking_copy,
        @Pointer(comment="void*") @NotNull MemorySegment dst_ptr,
        @Pointer(comment="void*") @NotNull MemorySegment src_ptr,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMMemcpy);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                blocking_copy,
                dst_ptr,
                src_ptr,
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMMemFill.html">clEnqueueSVMMemFill</a>
    public @NativeType("cl_int") int enqueueSVMMemFill(
        @Nullable CLCommandQueue command_queue,
        @Pointer(comment="void*") @NotNull MemorySegment svm_ptr,
        @Pointer(comment="void*") @NotNull MemorySegment pattern,
        long pattern_size,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMMemFill);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                svm_ptr,
                pattern,
                MemorySegment.ofAddress(pattern_size),
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMMap.html">clEnqueueSVMMap</a>
    public @NativeType("cl_int") int enqueueSVMMap(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_bool") @Unsigned int blocking_map,
        @NativeType("cl_map_flags") @Unsigned long flags,
        @Pointer(comment="void*") @NotNull MemorySegment svm_ptr,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMMap);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                blocking_map,
                flags,
                svm_ptr,
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMUnmap.html">clEnqueueSVMUnmap</a>
    public @NativeType("cl_int") int enqueueSVMUnmap(
        @Nullable CLCommandQueue command_queue,
        @Pointer(comment="void*") @NotNull MemorySegment svm_ptr,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMUnmap);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                svm_ptr,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueSVMMigrateMem.html">clEnqueueSVMMigrateMem</a>
    public @NativeType("cl_int") int enqueueSVMMigrateMem(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_svm_pointers,
        @Nullable PointerPtr svm_pointers,
        @Nullable PointerPtr sizes,
        @NativeType("cl_mem_migration_flags") @Unsigned long flags,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueSVMMigrateMem);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_svm_pointers,
                (MemorySegment) (svm_pointers != null ? svm_pointers.segment() : MemorySegment.NULL),
                (MemorySegment) (sizes != null ? sizes.segment() : MemorySegment.NULL),
                flags,
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetExtensionFunctionAddressForPlatform.html">clGetExtensionFunctionAddressForPlatform</a>
    public @Pointer(comment="void*") @NotNull MemorySegment getExtensionFunctionAddressForPlatform(
        @Nullable CLPlatformId platform,
        @Nullable BytePtr func_name
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetExtensionFunctionAddressForPlatform);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (platform != null ? platform.segment() : MemorySegment.NULL),
                (MemorySegment) (func_name != null ? func_name.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetCommandQueueProperty.html">clSetCommandQueueProperty</a>
    public @NativeType("cl_int") int setCommandQueueProperty(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_command_queue_properties") @Unsigned long properties,
        @NativeType("cl_bool") @Unsigned int enable,
        @Nullable @Pointer(comment="cl_command_queue_properties") @Unsigned LongPtr old_properties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetCommandQueueProperty);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                properties,
                enable,
                (MemorySegment) (old_properties != null ? old_properties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateImage2D.html">clCreateImage2D</a>
    public @Nullable CLMem createImage2D(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable @Pointer CLImageFormat image_format,
        long imageWidth,
        long imageHeight,
        long imageRowPitch,
        @Pointer(comment="void*") @NotNull MemorySegment host_ptr,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateImage2D);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (image_format != null ? image_format.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(imageWidth),
                MemorySegment.ofAddress(imageHeight),
                MemorySegment.ofAddress(imageRowPitch),
                host_ptr,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateImage3D.html">clCreateImage3D</a>
    public @Nullable CLMem createImage3D(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable @Pointer CLImageFormat image_format,
        long imageWidth,
        long imageHeight,
        long imageDepth,
        long imageRowPitch,
        long imageSlicePitch,
        @Pointer(comment="void*") @NotNull MemorySegment host_ptr,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateImage3D);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (image_format != null ? image_format.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(imageWidth),
                MemorySegment.ofAddress(imageHeight),
                MemorySegment.ofAddress(imageDepth),
                MemorySegment.ofAddress(imageRowPitch),
                MemorySegment.ofAddress(imageSlicePitch),
                host_ptr,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLMem(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueMarker.html">clEnqueueMarker</a>
    public @NativeType("cl_int") int enqueueMarker(
        @Nullable CLCommandQueue command_queue,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueMarker);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueWaitForEvents.html">clEnqueueWaitForEvents</a>
    public @NativeType("cl_int") int enqueueWaitForEvents(
        @Nullable CLCommandQueue command_queue,
        @NativeType("cl_uint") @Unsigned int num_events,
        @Nullable @Pointer CLEvent.Ptr event_list
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueWaitForEvents);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                num_events,
                (MemorySegment) (event_list != null ? event_list.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueBarrier.html">clEnqueueBarrier</a>
    public @NativeType("cl_int") int enqueueBarrier(
        @Nullable CLCommandQueue command_queue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueBarrier);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clUnloadCompiler.html">clUnloadCompiler</a>
    public @NativeType("cl_int") int unloadCompiler() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clUnloadCompiler);
        try {
            return (int) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetExtensionFunctionAddress.html">clGetExtensionFunctionAddress</a>
    public @Pointer(comment="void*") @NotNull MemorySegment getExtensionFunctionAddress(
        @Nullable BytePtr func_name
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetExtensionFunctionAddress);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (func_name != null ? func_name.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateCommandQueue.html">clCreateCommandQueue</a>
    public @Nullable CLCommandQueue createCommandQueue(
        @Nullable CLContext context,
        @Nullable CLDeviceId device,
        @NativeType("cl_command_queue_properties") @Unsigned long properties,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateCommandQueue);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                properties,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLCommandQueue(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCreateSampler.html">clCreateSampler</a>
    public @Nullable CLSampler createSampler(
        @Nullable CLContext context,
        @NativeType("cl_bool") @Unsigned int normalized_coords,
        @NativeType("cl_addressing_mode") @Unsigned int addressing_mode,
        @NativeType("cl_filter_mode") @Unsigned int filter_mode,
        @Nullable @Pointer(comment="cl_int") IntPtr errcode_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCreateSampler);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                normalized_coords,
                addressing_mode,
                filter_mode,
                (MemorySegment) (errcode_ret != null ? errcode_ret.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new CLSampler(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueTask.html">clEnqueueTask</a>
    public @NativeType("cl_int") int enqueueTask(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLKernel kernel,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueTask);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (kernel != null ? kernel.segment() : MemorySegment.NULL),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetLayerInfo.html">clGetLayerInfo</a>
    public @NativeType("cl_int") int getLayerInfo(
        @NativeType("cl_layer_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetLayerInfo);
        try {
            return (int) hFunction.invokeExact(
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clInitLayer.html">clInitLayer</a>
    public @NativeType("cl_int") int initLayer(
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable CLIcdDispatch target_dispatch,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_entries_ret,
        @Nullable @Pointer CLIcdDispatch.Ptr layer_dispatch_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clInitLayer);
        try {
            return (int) hFunction.invokeExact(
                num_entries,
                (MemorySegment) (target_dispatch != null ? target_dispatch.segment() : MemorySegment.NULL),
                (MemorySegment) (num_entries_ret != null ? num_entries_ret.segment() : MemorySegment.NULL),
                (MemorySegment) (layer_dispatch_ret != null ? layer_dispatch_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetICDLoaderInfoOCLICD.html">clGetICDLoaderInfoOCLICD</a>
    public @NativeType("cl_int") int getICDLoaderInfoOCLICD(
        @NativeType("cl_icdl_info") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetICDLoaderInfoOCLICD);
        try {
            return (int) hFunction.invokeExact(
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetSupportedGLTextureFormatsINTEL.html">clGetSupportedGLTextureFormatsINTEL</a>
    public @NativeType("cl_int") int getSupportedGLTextureFormatsINTEL(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_mem_object_type") @Unsigned int imageType,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer(comment="cl_GLenum") @Unsigned IntPtr gl_formats,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_texture_formats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetSupportedGLTextureFormatsINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                imageType,
                num_entries,
                (MemorySegment) (gl_formats != null ? gl_formats.segment() : MemorySegment.NULL),
                (MemorySegment) (num_texture_formats != null ? num_texture_formats.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetSupportedDX9MediaSurfaceFormatsINTEL.html">clGetSupportedDX9MediaSurfaceFormatsINTEL</a>
    public @NativeType("cl_int") int getSupportedDX9MediaSurfaceFormatsINTEL(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_mem_object_type") @Unsigned int imageType,
        @NativeType("cl_uint") @Unsigned int plane,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer(comment="D3DFORMAT") @Unsigned IntPtr dx9_formats,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_surface_formats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetSupportedDX9MediaSurfaceFormatsINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                imageType,
                plane,
                num_entries,
                (MemorySegment) (dx9_formats != null ? dx9_formats.segment() : MemorySegment.NULL),
                (MemorySegment) (num_surface_formats != null ? num_surface_formats.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetSupportedD3D10TextureFormatsINTEL.html">clGetSupportedD3D10TextureFormatsINTEL</a>
    public @NativeType("cl_int") int getSupportedD3D10TextureFormatsINTEL(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_mem_object_type") @Unsigned int imageType,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer(comment="DXGI_FORMAT") @Unsigned IntPtr d3d10_formats,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_texture_formats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetSupportedD3D10TextureFormatsINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                imageType,
                num_entries,
                (MemorySegment) (d3d10_formats != null ? d3d10_formats.segment() : MemorySegment.NULL),
                (MemorySegment) (num_texture_formats != null ? num_texture_formats.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetSupportedD3D11TextureFormatsINTEL.html">clGetSupportedD3D11TextureFormatsINTEL</a>
    public @NativeType("cl_int") int getSupportedD3D11TextureFormatsINTEL(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_mem_object_type") @Unsigned int imageType,
        @NativeType("cl_uint") @Unsigned int plane,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer(comment="DXGI_FORMAT") @Unsigned IntPtr d3d11_formats,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_texture_formats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetSupportedD3D11TextureFormatsINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                imageType,
                plane,
                num_entries,
                (MemorySegment) (d3d11_formats != null ? d3d11_formats.segment() : MemorySegment.NULL),
                (MemorySegment) (num_texture_formats != null ? num_texture_formats.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetSupportedVA_APIMediaSurfaceFormatsINTEL.html">clGetSupportedVA_APIMediaSurfaceFormatsINTEL</a>
    public @NativeType("cl_int") int getSupportedVA_APIMediaSurfaceFormatsINTEL(
        @Nullable CLContext context,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @NativeType("cl_mem_object_type") @Unsigned int imageType,
        @NativeType("cl_uint") @Unsigned int plane,
        @NativeType("cl_uint") @Unsigned int num_entries,
        @Nullable @Pointer VAImageFormatCLREF va_api_formats,
        @Nullable @Pointer(comment="cl_uint") @Unsigned IntPtr num_surface_formats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetSupportedVA_APIMediaSurfaceFormatsINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                flags,
                imageType,
                plane,
                num_entries,
                (MemorySegment) (va_api_formats != null ? va_api_formats.segment() : MemorySegment.NULL),
                (MemorySegment) (num_surface_formats != null ? num_surface_formats.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueReadHostPipeINTEL.html">clEnqueueReadHostPipeINTEL</a>
    public @NativeType("cl_int") int enqueueReadHostPipeINTEL(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLProgram program,
        @Nullable BytePtr pipe_symbol,
        @NativeType("cl_bool") @Unsigned int blocking_read,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueReadHostPipeINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                (MemorySegment) (pipe_symbol != null ? pipe_symbol.segment() : MemorySegment.NULL),
                blocking_read,
                ptr,
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clEnqueueWriteHostPipeINTEL.html">clEnqueueWriteHostPipeINTEL</a>
    public @NativeType("cl_int") int enqueueWriteHostPipeINTEL(
        @Nullable CLCommandQueue command_queue,
        @Nullable CLProgram program,
        @Nullable BytePtr pipe_symbol,
        @NativeType("cl_bool") @Unsigned int blocking_write,
        @Pointer(comment="void*") @NotNull MemorySegment ptr,
        long size,
        @NativeType("cl_uint") @Unsigned int num_events_in_wait_list,
        @Nullable @Pointer CLEvent.Ptr event_wait_list,
        @Nullable @Pointer CLEvent.Ptr event
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clEnqueueWriteHostPipeINTEL);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (command_queue != null ? command_queue.segment() : MemorySegment.NULL),
                (MemorySegment) (program != null ? program.segment() : MemorySegment.NULL),
                (MemorySegment) (pipe_symbol != null ? pipe_symbol.segment() : MemorySegment.NULL),
                blocking_write,
                ptr,
                MemorySegment.ofAddress(size),
                num_events_in_wait_list,
                (MemorySegment) (event_wait_list != null ? event_wait_list.segment() : MemorySegment.NULL),
                (MemorySegment) (event != null ? event.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clGetImageRequirementsInfoEXT.html">clGetImageRequirementsInfoEXT</a>
    public @NativeType("cl_int") int getImageRequirementsInfoEXT(
        @Nullable CLContext context,
        @Nullable @Pointer(comment="cl_mem_properties") @Unsigned LongPtr properties,
        @NativeType("cl_mem_flags") @Unsigned long flags,
        @Nullable @Pointer CLImageFormat image_format,
        @Nullable @Pointer CLImageDesc image_desc,
        @NativeType("cl_image_requirements_info_ext") @Unsigned int paramName,
        long paramValueSize,
        @Pointer(comment="void*") @NotNull MemorySegment paramValue,
        @Nullable PointerPtr param_value_size_ret
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clGetImageRequirementsInfoEXT);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (properties != null ? properties.segment() : MemorySegment.NULL),
                flags,
                (MemorySegment) (image_format != null ? image_format.segment() : MemorySegment.NULL),
                (MemorySegment) (image_desc != null ? image_desc.segment() : MemorySegment.NULL),
                paramName,
                MemorySegment.ofAddress(paramValueSize),
                paramValue,
                (MemorySegment) (param_value_size_ret != null ? param_value_size_ret.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clCancelCommandsIMG.html">clCancelCommandsIMG</a>
    public @NativeType("cl_int") int cancelCommandsIMG(
        @Nullable @Pointer CLEvent.Ptr event_list,
        long num_events_in_list
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clCancelCommandsIMG);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (event_list != null ? event_list.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(num_events_in_list)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/clSetPerfHintQCOM.html">clSetPerfHintQCOM</a>
    public @NativeType("cl_int") int setPerfHintQCOM(
        @Nullable CLContext context,
        @NativeType("cl_perf_hint_qcom") @Unsigned int perf_hint
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$clSetPerfHintQCOM);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                perf_hint
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    // endregion

    // region segments and handles
    public final @Nullable MemorySegment SEGMENT$clGetDeviceIDsFromD3D10KHR;
    public final @Nullable MemorySegment SEGMENT$clCreateFromD3D10BufferKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateFromD3D10Texture2DKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateFromD3D10Texture3DKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueAcquireD3D10ObjectsKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReleaseD3D10ObjectsKHR;
    public final @Nullable MemorySegment SEGMENT$clGetDeviceIDsFromD3D11KHR;
    public final @Nullable MemorySegment SEGMENT$clCreateFromD3D11BufferKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateFromD3D11Texture2DKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateFromD3D11Texture3DKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueAcquireD3D11ObjectsKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReleaseD3D11ObjectsKHR;
    public final @Nullable MemorySegment SEGMENT$clGetDeviceIDsFromDX9MediaAdapterKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateFromDX9MediaSurfaceKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueAcquireDX9MediaSurfacesKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReleaseDX9MediaSurfacesKHR;
    public final @Nullable MemorySegment SEGMENT$clGetDeviceIDsFromDX9INTEL;
    public final @Nullable MemorySegment SEGMENT$clCreateFromDX9MediaSurfaceINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueAcquireDX9ObjectsINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReleaseDX9ObjectsINTEL;
    public final @Nullable MemorySegment SEGMENT$clCreateEventFromEGLSyncKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateFromEGLImageKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueAcquireEGLObjectsKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReleaseEGLObjectsKHR;
    public final @Nullable MemorySegment SEGMENT$clLogMessagesToSystemLogAPPLE;
    public final @Nullable MemorySegment SEGMENT$clLogMessagesToStdoutAPPLE;
    public final @Nullable MemorySegment SEGMENT$clLogMessagesToStderrAPPLE;
    public final @Nullable MemorySegment SEGMENT$clIcdGetPlatformIDsKHR;
    public final @Nullable MemorySegment SEGMENT$clIcdGetFunctionAddressForPlatformKHR;
    public final @Nullable MemorySegment SEGMENT$clIcdSetPlatformDispatchDataKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateProgramWithILKHR;
    public final @Nullable MemorySegment SEGMENT$clTerminateContextKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateCommandQueueWithPropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$clReleaseDeviceEXT;
    public final @Nullable MemorySegment SEGMENT$clRetainDeviceEXT;
    public final @Nullable MemorySegment SEGMENT$clCreateSubDevicesEXT;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMigrateMemObjectEXT;
    public final @Nullable MemorySegment SEGMENT$clGetDeviceImageInfoQCOM;
    public final @Nullable MemorySegment SEGMENT$clEnqueueAcquireGrallocObjectsIMG;
    public final @Nullable MemorySegment SEGMENT$clEnqueueGenerateMipmapIMG;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReleaseGrallocObjectsIMG;
    public final @Nullable MemorySegment SEGMENT$clGetKernelSubGroupInfoKHR;
    public final @Nullable MemorySegment SEGMENT$clGetKernelSuggestedLocalWorkSizeKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateSemaphoreWithPropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueWaitSemaphoresKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSignalSemaphoresKHR;
    public final @Nullable MemorySegment SEGMENT$clGetSemaphoreInfoKHR;
    public final @Nullable MemorySegment SEGMENT$clReleaseSemaphoreKHR;
    public final @Nullable MemorySegment SEGMENT$clRetainSemaphoreKHR;
    public final @Nullable MemorySegment SEGMENT$clGetSemaphoreHandleForTypeKHR;
    public final @Nullable MemorySegment SEGMENT$clReImportSemaphoreSyncFdKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueAcquireExternalMemObjectsKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReleaseExternalMemObjectsKHR;
    public final @Nullable MemorySegment SEGMENT$clImportMemoryARM;
    public final @Nullable MemorySegment SEGMENT$clSVMAllocARM;
    public final @Nullable MemorySegment SEGMENT$clSVMFreeARM;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMFreeARM;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMMemcpyARM;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMMemFillARM;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMMapARM;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMUnmapARM;
    public final @Nullable MemorySegment SEGMENT$clSetKernelArgSVMPointerARM;
    public final @Nullable MemorySegment SEGMENT$clSetKernelExecInfoARM;
    public final @Nullable MemorySegment SEGMENT$clCreateAcceleratorINTEL;
    public final @Nullable MemorySegment SEGMENT$clGetAcceleratorInfoINTEL;
    public final @Nullable MemorySegment SEGMENT$clRetainAcceleratorINTEL;
    public final @Nullable MemorySegment SEGMENT$clReleaseAcceleratorINTEL;
    public final @Nullable MemorySegment SEGMENT$clCreateEventFromGLsyncKHR;
    public final @Nullable MemorySegment SEGMENT$clGetGLContextInfoKHR;
    public final @Nullable MemorySegment SEGMENT$clCreateFromGLBuffer;
    public final @Nullable MemorySegment SEGMENT$clCreateFromGLTexture;
    public final @Nullable MemorySegment SEGMENT$clCreateFromGLRenderbuffer;
    public final @Nullable MemorySegment SEGMENT$clGetGLObjectInfo;
    public final @Nullable MemorySegment SEGMENT$clGetGLTextureInfo;
    public final @Nullable MemorySegment SEGMENT$clEnqueueAcquireGLObjects;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReleaseGLObjects;
    public final @Nullable MemorySegment SEGMENT$clCreateFromGLTexture2D;
    public final @Nullable MemorySegment SEGMENT$clCreateFromGLTexture3D;
    public final @Nullable MemorySegment SEGMENT$clGetDeviceIDsFromVA_APIMediaAdapterINTEL;
    public final @Nullable MemorySegment SEGMENT$clCreateFromVA_APIMediaSurfaceINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueAcquireVA_APIMediaSurfacesINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReleaseVA_APIMediaSurfacesINTEL;
    public final @Nullable MemorySegment SEGMENT$clHostMemAllocINTEL;
    public final @Nullable MemorySegment SEGMENT$clDeviceMemAllocINTEL;
    public final @Nullable MemorySegment SEGMENT$clSharedMemAllocINTEL;
    public final @Nullable MemorySegment SEGMENT$clMemFreeINTEL;
    public final @Nullable MemorySegment SEGMENT$clMemBlockingFreeINTEL;
    public final @Nullable MemorySegment SEGMENT$clGetMemAllocInfoINTEL;
    public final @Nullable MemorySegment SEGMENT$clSetKernelArgMemPointerINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMemsetINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMemFillINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMemcpyINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMigrateMemINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMemAdviseINTEL;
    public final @Nullable MemorySegment SEGMENT$clCreateBufferWithPropertiesINTEL;
    public final @Nullable MemorySegment SEGMENT$clCreateCommandBufferKHR;
    public final @Nullable MemorySegment SEGMENT$clFinalizeCommandBufferKHR;
    public final @Nullable MemorySegment SEGMENT$clRetainCommandBufferKHR;
    public final @Nullable MemorySegment SEGMENT$clReleaseCommandBufferKHR;
    public final @Nullable MemorySegment SEGMENT$clEnqueueCommandBufferKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandBarrierWithWaitListKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandCopyBufferKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandCopyBufferRectKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandCopyBufferToImageKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandCopyImageKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandCopyImageToBufferKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandFillBufferKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandFillImageKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandNDRangeKernelKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandSVMMemcpyKHR;
    public final @Nullable MemorySegment SEGMENT$clCommandSVMMemFillKHR;
    public final @Nullable MemorySegment SEGMENT$clGetCommandBufferInfoKHR;
    public final @Nullable MemorySegment SEGMENT$clUpdateMutableCommandsKHR;
    public final @Nullable MemorySegment SEGMENT$clGetMutableCommandInfoKHR;
    public final @Nullable MemorySegment SEGMENT$clRemapCommandBufferKHR;
    public final @Nullable MemorySegment SEGMENT$clSetContentSizeBufferPoCL;
    public final @Nullable MemorySegment SEGMENT$clGetPlatformIDs;
    public final @Nullable MemorySegment SEGMENT$clGetPlatformInfo;
    public final @Nullable MemorySegment SEGMENT$clGetDeviceIDs;
    public final @Nullable MemorySegment SEGMENT$clGetDeviceInfo;
    public final @Nullable MemorySegment SEGMENT$clCreateSubDevices;
    public final @Nullable MemorySegment SEGMENT$clRetainDevice;
    public final @Nullable MemorySegment SEGMENT$clReleaseDevice;
    public final @Nullable MemorySegment SEGMENT$clSetDefaultDeviceCommandQueue;
    public final @Nullable MemorySegment SEGMENT$clGetDeviceAndHostTimer;
    public final @Nullable MemorySegment SEGMENT$clGetHostTimer;
    public final @Nullable MemorySegment SEGMENT$clCreateContext;
    public final @Nullable MemorySegment SEGMENT$clCreateContextFromType;
    public final @Nullable MemorySegment SEGMENT$clRetainContext;
    public final @Nullable MemorySegment SEGMENT$clReleaseContext;
    public final @Nullable MemorySegment SEGMENT$clGetContextInfo;
    public final @Nullable MemorySegment SEGMENT$clSetContextDestructorCallback;
    public final @Nullable MemorySegment SEGMENT$clCreateCommandQueueWithProperties;
    public final @Nullable MemorySegment SEGMENT$clRetainCommandQueue;
    public final @Nullable MemorySegment SEGMENT$clReleaseCommandQueue;
    public final @Nullable MemorySegment SEGMENT$clGetCommandQueueInfo;
    public final @Nullable MemorySegment SEGMENT$clCreateBuffer;
    public final @Nullable MemorySegment SEGMENT$clCreateBufferWithProperties;
    public final @Nullable MemorySegment SEGMENT$clCreateSubBuffer;
    public final @Nullable MemorySegment SEGMENT$clCreateImage;
    public final @Nullable MemorySegment SEGMENT$clCreateImageWithProperties;
    public final @Nullable MemorySegment SEGMENT$clCreatePipe;
    public final @Nullable MemorySegment SEGMENT$clRetainMemObject;
    public final @Nullable MemorySegment SEGMENT$clReleaseMemObject;
    public final @Nullable MemorySegment SEGMENT$clGetSupportedImageFormats;
    public final @Nullable MemorySegment SEGMENT$clGetMemObjectInfo;
    public final @Nullable MemorySegment SEGMENT$clGetImageInfo;
    public final @Nullable MemorySegment SEGMENT$clGetPipeInfo;
    public final @Nullable MemorySegment SEGMENT$clSetMemObjectDestructorCallback;
    public final @Nullable MemorySegment SEGMENT$clSetMemObjectDestructorAPPLE;
    public final @Nullable MemorySegment SEGMENT$clSVMAlloc;
    public final @Nullable MemorySegment SEGMENT$clSVMFree;
    public final @Nullable MemorySegment SEGMENT$clCreateSamplerWithProperties;
    public final @Nullable MemorySegment SEGMENT$clRetainSampler;
    public final @Nullable MemorySegment SEGMENT$clReleaseSampler;
    public final @Nullable MemorySegment SEGMENT$clGetSamplerInfo;
    public final @Nullable MemorySegment SEGMENT$clCreateProgramWithSource;
    public final @Nullable MemorySegment SEGMENT$clCreateProgramWithBinary;
    public final @Nullable MemorySegment SEGMENT$clCreateProgramWithBuiltInKernels;
    public final @Nullable MemorySegment SEGMENT$clCreateProgramWithIL;
    public final @Nullable MemorySegment SEGMENT$clRetainProgram;
    public final @Nullable MemorySegment SEGMENT$clReleaseProgram;
    public final @Nullable MemorySegment SEGMENT$clBuildProgram;
    public final @Nullable MemorySegment SEGMENT$clCompileProgram;
    public final @Nullable MemorySegment SEGMENT$clLinkProgram;
    public final @Nullable MemorySegment SEGMENT$clSetProgramReleaseCallback;
    public final @Nullable MemorySegment SEGMENT$clSetProgramSpecializationConstant;
    public final @Nullable MemorySegment SEGMENT$clUnloadPlatformCompiler;
    public final @Nullable MemorySegment SEGMENT$clGetProgramInfo;
    public final @Nullable MemorySegment SEGMENT$clGetProgramBuildInfo;
    public final @Nullable MemorySegment SEGMENT$clCreateKernel;
    public final @Nullable MemorySegment SEGMENT$clCreateKernelsInProgram;
    public final @Nullable MemorySegment SEGMENT$clCloneKernel;
    public final @Nullable MemorySegment SEGMENT$clRetainKernel;
    public final @Nullable MemorySegment SEGMENT$clReleaseKernel;
    public final @Nullable MemorySegment SEGMENT$clSetKernelArg;
    public final @Nullable MemorySegment SEGMENT$clSetKernelArgSVMPointer;
    public final @Nullable MemorySegment SEGMENT$clSetKernelArgDevicePointerEXT;
    public final @Nullable MemorySegment SEGMENT$clSetKernelExecInfo;
    public final @Nullable MemorySegment SEGMENT$clGetKernelInfo;
    public final @Nullable MemorySegment SEGMENT$clGetKernelArgInfo;
    public final @Nullable MemorySegment SEGMENT$clGetKernelWorkGroupInfo;
    public final @Nullable MemorySegment SEGMENT$clGetKernelSubGroupInfo;
    public final @Nullable MemorySegment SEGMENT$clWaitForEvents;
    public final @Nullable MemorySegment SEGMENT$clGetEventInfo;
    public final @Nullable MemorySegment SEGMENT$clCreateUserEvent;
    public final @Nullable MemorySegment SEGMENT$clRetainEvent;
    public final @Nullable MemorySegment SEGMENT$clReleaseEvent;
    public final @Nullable MemorySegment SEGMENT$clSetUserEventStatus;
    public final @Nullable MemorySegment SEGMENT$clSetEventCallback;
    public final @Nullable MemorySegment SEGMENT$clGetEventProfilingInfo;
    public final @Nullable MemorySegment SEGMENT$clFlush;
    public final @Nullable MemorySegment SEGMENT$clFinish;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReadBuffer;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReadBufferRect;
    public final @Nullable MemorySegment SEGMENT$clEnqueueWriteBuffer;
    public final @Nullable MemorySegment SEGMENT$clEnqueueWriteBufferRect;
    public final @Nullable MemorySegment SEGMENT$clEnqueueFillBuffer;
    public final @Nullable MemorySegment SEGMENT$clEnqueueCopyBuffer;
    public final @Nullable MemorySegment SEGMENT$clEnqueueCopyBufferRect;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReadImage;
    public final @Nullable MemorySegment SEGMENT$clEnqueueWriteImage;
    public final @Nullable MemorySegment SEGMENT$clEnqueueFillImage;
    public final @Nullable MemorySegment SEGMENT$clEnqueueCopyImage;
    public final @Nullable MemorySegment SEGMENT$clEnqueueCopyImageToBuffer;
    public final @Nullable MemorySegment SEGMENT$clEnqueueCopyBufferToImage;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMapBuffer;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMapImage;
    public final @Nullable MemorySegment SEGMENT$clEnqueueUnmapMemObject;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMigrateMemObjects;
    public final @Nullable MemorySegment SEGMENT$clEnqueueNDRangeKernel;
    public final @Nullable MemorySegment SEGMENT$clEnqueueNativeKernel;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMarkerWithWaitList;
    public final @Nullable MemorySegment SEGMENT$clEnqueueBarrierWithWaitList;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMFree;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMMemcpy;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMMemFill;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMMap;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMUnmap;
    public final @Nullable MemorySegment SEGMENT$clEnqueueSVMMigrateMem;
    public final @Nullable MemorySegment SEGMENT$clGetExtensionFunctionAddressForPlatform;
    public final @Nullable MemorySegment SEGMENT$clSetCommandQueueProperty;
    public final @Nullable MemorySegment SEGMENT$clCreateImage2D;
    public final @Nullable MemorySegment SEGMENT$clCreateImage3D;
    public final @Nullable MemorySegment SEGMENT$clEnqueueMarker;
    public final @Nullable MemorySegment SEGMENT$clEnqueueWaitForEvents;
    public final @Nullable MemorySegment SEGMENT$clEnqueueBarrier;
    public final @Nullable MemorySegment SEGMENT$clUnloadCompiler;
    public final @Nullable MemorySegment SEGMENT$clGetExtensionFunctionAddress;
    public final @Nullable MemorySegment SEGMENT$clCreateCommandQueue;
    public final @Nullable MemorySegment SEGMENT$clCreateSampler;
    public final @Nullable MemorySegment SEGMENT$clEnqueueTask;
    public final @Nullable MemorySegment SEGMENT$clGetLayerInfo;
    public final @Nullable MemorySegment SEGMENT$clInitLayer;
    public final @Nullable MemorySegment SEGMENT$clGetICDLoaderInfoOCLICD;
    public final @Nullable MemorySegment SEGMENT$clGetSupportedGLTextureFormatsINTEL;
    public final @Nullable MemorySegment SEGMENT$clGetSupportedDX9MediaSurfaceFormatsINTEL;
    public final @Nullable MemorySegment SEGMENT$clGetSupportedD3D10TextureFormatsINTEL;
    public final @Nullable MemorySegment SEGMENT$clGetSupportedD3D11TextureFormatsINTEL;
    public final @Nullable MemorySegment SEGMENT$clGetSupportedVA_APIMediaSurfaceFormatsINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueReadHostPipeINTEL;
    public final @Nullable MemorySegment SEGMENT$clEnqueueWriteHostPipeINTEL;
    public final @Nullable MemorySegment SEGMENT$clGetImageRequirementsInfoEXT;
    public final @Nullable MemorySegment SEGMENT$clCancelCommandsIMG;
    public final @Nullable MemorySegment SEGMENT$clSetPerfHintQCOM;
    public final @Nullable MethodHandle HANDLE$clGetDeviceIDsFromD3D10KHR;
    public final @Nullable MethodHandle HANDLE$clCreateFromD3D10BufferKHR;
    public final @Nullable MethodHandle HANDLE$clCreateFromD3D10Texture2DKHR;
    public final @Nullable MethodHandle HANDLE$clCreateFromD3D10Texture3DKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueAcquireD3D10ObjectsKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueReleaseD3D10ObjectsKHR;
    public final @Nullable MethodHandle HANDLE$clGetDeviceIDsFromD3D11KHR;
    public final @Nullable MethodHandle HANDLE$clCreateFromD3D11BufferKHR;
    public final @Nullable MethodHandle HANDLE$clCreateFromD3D11Texture2DKHR;
    public final @Nullable MethodHandle HANDLE$clCreateFromD3D11Texture3DKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueAcquireD3D11ObjectsKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueReleaseD3D11ObjectsKHR;
    public final @Nullable MethodHandle HANDLE$clGetDeviceIDsFromDX9MediaAdapterKHR;
    public final @Nullable MethodHandle HANDLE$clCreateFromDX9MediaSurfaceKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueAcquireDX9MediaSurfacesKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueReleaseDX9MediaSurfacesKHR;
    public final @Nullable MethodHandle HANDLE$clGetDeviceIDsFromDX9INTEL;
    public final @Nullable MethodHandle HANDLE$clCreateFromDX9MediaSurfaceINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueAcquireDX9ObjectsINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueReleaseDX9ObjectsINTEL;
    public final @Nullable MethodHandle HANDLE$clCreateEventFromEGLSyncKHR;
    public final @Nullable MethodHandle HANDLE$clCreateFromEGLImageKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueAcquireEGLObjectsKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueReleaseEGLObjectsKHR;
    public final @Nullable MethodHandle HANDLE$clLogMessagesToSystemLogAPPLE;
    public final @Nullable MethodHandle HANDLE$clLogMessagesToStdoutAPPLE;
    public final @Nullable MethodHandle HANDLE$clLogMessagesToStderrAPPLE;
    public final @Nullable MethodHandle HANDLE$clIcdGetPlatformIDsKHR;
    public final @Nullable MethodHandle HANDLE$clIcdGetFunctionAddressForPlatformKHR;
    public final @Nullable MethodHandle HANDLE$clIcdSetPlatformDispatchDataKHR;
    public final @Nullable MethodHandle HANDLE$clCreateProgramWithILKHR;
    public final @Nullable MethodHandle HANDLE$clTerminateContextKHR;
    public final @Nullable MethodHandle HANDLE$clCreateCommandQueueWithPropertiesKHR;
    public final @Nullable MethodHandle HANDLE$clReleaseDeviceEXT;
    public final @Nullable MethodHandle HANDLE$clRetainDeviceEXT;
    public final @Nullable MethodHandle HANDLE$clCreateSubDevicesEXT;
    public final @Nullable MethodHandle HANDLE$clEnqueueMigrateMemObjectEXT;
    public final @Nullable MethodHandle HANDLE$clGetDeviceImageInfoQCOM;
    public final @Nullable MethodHandle HANDLE$clEnqueueAcquireGrallocObjectsIMG;
    public final @Nullable MethodHandle HANDLE$clEnqueueGenerateMipmapIMG;
    public final @Nullable MethodHandle HANDLE$clEnqueueReleaseGrallocObjectsIMG;
    public final @Nullable MethodHandle HANDLE$clGetKernelSubGroupInfoKHR;
    public final @Nullable MethodHandle HANDLE$clGetKernelSuggestedLocalWorkSizeKHR;
    public final @Nullable MethodHandle HANDLE$clCreateSemaphoreWithPropertiesKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueWaitSemaphoresKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueSignalSemaphoresKHR;
    public final @Nullable MethodHandle HANDLE$clGetSemaphoreInfoKHR;
    public final @Nullable MethodHandle HANDLE$clReleaseSemaphoreKHR;
    public final @Nullable MethodHandle HANDLE$clRetainSemaphoreKHR;
    public final @Nullable MethodHandle HANDLE$clGetSemaphoreHandleForTypeKHR;
    public final @Nullable MethodHandle HANDLE$clReImportSemaphoreSyncFdKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueAcquireExternalMemObjectsKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueReleaseExternalMemObjectsKHR;
    public final @Nullable MethodHandle HANDLE$clImportMemoryARM;
    public final @Nullable MethodHandle HANDLE$clSVMAllocARM;
    public final @Nullable MethodHandle HANDLE$clSVMFreeARM;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMFreeARM;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMMemcpyARM;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMMemFillARM;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMMapARM;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMUnmapARM;
    public final @Nullable MethodHandle HANDLE$clSetKernelArgSVMPointerARM;
    public final @Nullable MethodHandle HANDLE$clSetKernelExecInfoARM;
    public final @Nullable MethodHandle HANDLE$clCreateAcceleratorINTEL;
    public final @Nullable MethodHandle HANDLE$clGetAcceleratorInfoINTEL;
    public final @Nullable MethodHandle HANDLE$clRetainAcceleratorINTEL;
    public final @Nullable MethodHandle HANDLE$clReleaseAcceleratorINTEL;
    public final @Nullable MethodHandle HANDLE$clCreateEventFromGLsyncKHR;
    public final @Nullable MethodHandle HANDLE$clGetGLContextInfoKHR;
    public final @Nullable MethodHandle HANDLE$clCreateFromGLBuffer;
    public final @Nullable MethodHandle HANDLE$clCreateFromGLTexture;
    public final @Nullable MethodHandle HANDLE$clCreateFromGLRenderbuffer;
    public final @Nullable MethodHandle HANDLE$clGetGLObjectInfo;
    public final @Nullable MethodHandle HANDLE$clGetGLTextureInfo;
    public final @Nullable MethodHandle HANDLE$clEnqueueAcquireGLObjects;
    public final @Nullable MethodHandle HANDLE$clEnqueueReleaseGLObjects;
    public final @Nullable MethodHandle HANDLE$clCreateFromGLTexture2D;
    public final @Nullable MethodHandle HANDLE$clCreateFromGLTexture3D;
    public final @Nullable MethodHandle HANDLE$clGetDeviceIDsFromVA_APIMediaAdapterINTEL;
    public final @Nullable MethodHandle HANDLE$clCreateFromVA_APIMediaSurfaceINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueAcquireVA_APIMediaSurfacesINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueReleaseVA_APIMediaSurfacesINTEL;
    public final @Nullable MethodHandle HANDLE$clHostMemAllocINTEL;
    public final @Nullable MethodHandle HANDLE$clDeviceMemAllocINTEL;
    public final @Nullable MethodHandle HANDLE$clSharedMemAllocINTEL;
    public final @Nullable MethodHandle HANDLE$clMemFreeINTEL;
    public final @Nullable MethodHandle HANDLE$clMemBlockingFreeINTEL;
    public final @Nullable MethodHandle HANDLE$clGetMemAllocInfoINTEL;
    public final @Nullable MethodHandle HANDLE$clSetKernelArgMemPointerINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueMemsetINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueMemFillINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueMemcpyINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueMigrateMemINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueMemAdviseINTEL;
    public final @Nullable MethodHandle HANDLE$clCreateBufferWithPropertiesINTEL;
    public final @Nullable MethodHandle HANDLE$clCreateCommandBufferKHR;
    public final @Nullable MethodHandle HANDLE$clFinalizeCommandBufferKHR;
    public final @Nullable MethodHandle HANDLE$clRetainCommandBufferKHR;
    public final @Nullable MethodHandle HANDLE$clReleaseCommandBufferKHR;
    public final @Nullable MethodHandle HANDLE$clEnqueueCommandBufferKHR;
    public final @Nullable MethodHandle HANDLE$clCommandBarrierWithWaitListKHR;
    public final @Nullable MethodHandle HANDLE$clCommandCopyBufferKHR;
    public final @Nullable MethodHandle HANDLE$clCommandCopyBufferRectKHR;
    public final @Nullable MethodHandle HANDLE$clCommandCopyBufferToImageKHR;
    public final @Nullable MethodHandle HANDLE$clCommandCopyImageKHR;
    public final @Nullable MethodHandle HANDLE$clCommandCopyImageToBufferKHR;
    public final @Nullable MethodHandle HANDLE$clCommandFillBufferKHR;
    public final @Nullable MethodHandle HANDLE$clCommandFillImageKHR;
    public final @Nullable MethodHandle HANDLE$clCommandNDRangeKernelKHR;
    public final @Nullable MethodHandle HANDLE$clCommandSVMMemcpyKHR;
    public final @Nullable MethodHandle HANDLE$clCommandSVMMemFillKHR;
    public final @Nullable MethodHandle HANDLE$clGetCommandBufferInfoKHR;
    public final @Nullable MethodHandle HANDLE$clUpdateMutableCommandsKHR;
    public final @Nullable MethodHandle HANDLE$clGetMutableCommandInfoKHR;
    public final @Nullable MethodHandle HANDLE$clRemapCommandBufferKHR;
    public final @Nullable MethodHandle HANDLE$clSetContentSizeBufferPoCL;
    public final @Nullable MethodHandle HANDLE$clGetPlatformIDs;
    public final @Nullable MethodHandle HANDLE$clGetPlatformInfo;
    public final @Nullable MethodHandle HANDLE$clGetDeviceIDs;
    public final @Nullable MethodHandle HANDLE$clGetDeviceInfo;
    public final @Nullable MethodHandle HANDLE$clCreateSubDevices;
    public final @Nullable MethodHandle HANDLE$clRetainDevice;
    public final @Nullable MethodHandle HANDLE$clReleaseDevice;
    public final @Nullable MethodHandle HANDLE$clSetDefaultDeviceCommandQueue;
    public final @Nullable MethodHandle HANDLE$clGetDeviceAndHostTimer;
    public final @Nullable MethodHandle HANDLE$clGetHostTimer;
    public final @Nullable MethodHandle HANDLE$clCreateContext;
    public final @Nullable MethodHandle HANDLE$clCreateContextFromType;
    public final @Nullable MethodHandle HANDLE$clRetainContext;
    public final @Nullable MethodHandle HANDLE$clReleaseContext;
    public final @Nullable MethodHandle HANDLE$clGetContextInfo;
    public final @Nullable MethodHandle HANDLE$clSetContextDestructorCallback;
    public final @Nullable MethodHandle HANDLE$clCreateCommandQueueWithProperties;
    public final @Nullable MethodHandle HANDLE$clRetainCommandQueue;
    public final @Nullable MethodHandle HANDLE$clReleaseCommandQueue;
    public final @Nullable MethodHandle HANDLE$clGetCommandQueueInfo;
    public final @Nullable MethodHandle HANDLE$clCreateBuffer;
    public final @Nullable MethodHandle HANDLE$clCreateBufferWithProperties;
    public final @Nullable MethodHandle HANDLE$clCreateSubBuffer;
    public final @Nullable MethodHandle HANDLE$clCreateImage;
    public final @Nullable MethodHandle HANDLE$clCreateImageWithProperties;
    public final @Nullable MethodHandle HANDLE$clCreatePipe;
    public final @Nullable MethodHandle HANDLE$clRetainMemObject;
    public final @Nullable MethodHandle HANDLE$clReleaseMemObject;
    public final @Nullable MethodHandle HANDLE$clGetSupportedImageFormats;
    public final @Nullable MethodHandle HANDLE$clGetMemObjectInfo;
    public final @Nullable MethodHandle HANDLE$clGetImageInfo;
    public final @Nullable MethodHandle HANDLE$clGetPipeInfo;
    public final @Nullable MethodHandle HANDLE$clSetMemObjectDestructorCallback;
    public final @Nullable MethodHandle HANDLE$clSetMemObjectDestructorAPPLE;
    public final @Nullable MethodHandle HANDLE$clSVMAlloc;
    public final @Nullable MethodHandle HANDLE$clSVMFree;
    public final @Nullable MethodHandle HANDLE$clCreateSamplerWithProperties;
    public final @Nullable MethodHandle HANDLE$clRetainSampler;
    public final @Nullable MethodHandle HANDLE$clReleaseSampler;
    public final @Nullable MethodHandle HANDLE$clGetSamplerInfo;
    public final @Nullable MethodHandle HANDLE$clCreateProgramWithSource;
    public final @Nullable MethodHandle HANDLE$clCreateProgramWithBinary;
    public final @Nullable MethodHandle HANDLE$clCreateProgramWithBuiltInKernels;
    public final @Nullable MethodHandle HANDLE$clCreateProgramWithIL;
    public final @Nullable MethodHandle HANDLE$clRetainProgram;
    public final @Nullable MethodHandle HANDLE$clReleaseProgram;
    public final @Nullable MethodHandle HANDLE$clBuildProgram;
    public final @Nullable MethodHandle HANDLE$clCompileProgram;
    public final @Nullable MethodHandle HANDLE$clLinkProgram;
    public final @Nullable MethodHandle HANDLE$clSetProgramReleaseCallback;
    public final @Nullable MethodHandle HANDLE$clSetProgramSpecializationConstant;
    public final @Nullable MethodHandle HANDLE$clUnloadPlatformCompiler;
    public final @Nullable MethodHandle HANDLE$clGetProgramInfo;
    public final @Nullable MethodHandle HANDLE$clGetProgramBuildInfo;
    public final @Nullable MethodHandle HANDLE$clCreateKernel;
    public final @Nullable MethodHandle HANDLE$clCreateKernelsInProgram;
    public final @Nullable MethodHandle HANDLE$clCloneKernel;
    public final @Nullable MethodHandle HANDLE$clRetainKernel;
    public final @Nullable MethodHandle HANDLE$clReleaseKernel;
    public final @Nullable MethodHandle HANDLE$clSetKernelArg;
    public final @Nullable MethodHandle HANDLE$clSetKernelArgSVMPointer;
    public final @Nullable MethodHandle HANDLE$clSetKernelArgDevicePointerEXT;
    public final @Nullable MethodHandle HANDLE$clSetKernelExecInfo;
    public final @Nullable MethodHandle HANDLE$clGetKernelInfo;
    public final @Nullable MethodHandle HANDLE$clGetKernelArgInfo;
    public final @Nullable MethodHandle HANDLE$clGetKernelWorkGroupInfo;
    public final @Nullable MethodHandle HANDLE$clGetKernelSubGroupInfo;
    public final @Nullable MethodHandle HANDLE$clWaitForEvents;
    public final @Nullable MethodHandle HANDLE$clGetEventInfo;
    public final @Nullable MethodHandle HANDLE$clCreateUserEvent;
    public final @Nullable MethodHandle HANDLE$clRetainEvent;
    public final @Nullable MethodHandle HANDLE$clReleaseEvent;
    public final @Nullable MethodHandle HANDLE$clSetUserEventStatus;
    public final @Nullable MethodHandle HANDLE$clSetEventCallback;
    public final @Nullable MethodHandle HANDLE$clGetEventProfilingInfo;
    public final @Nullable MethodHandle HANDLE$clFlush;
    public final @Nullable MethodHandle HANDLE$clFinish;
    public final @Nullable MethodHandle HANDLE$clEnqueueReadBuffer;
    public final @Nullable MethodHandle HANDLE$clEnqueueReadBufferRect;
    public final @Nullable MethodHandle HANDLE$clEnqueueWriteBuffer;
    public final @Nullable MethodHandle HANDLE$clEnqueueWriteBufferRect;
    public final @Nullable MethodHandle HANDLE$clEnqueueFillBuffer;
    public final @Nullable MethodHandle HANDLE$clEnqueueCopyBuffer;
    public final @Nullable MethodHandle HANDLE$clEnqueueCopyBufferRect;
    public final @Nullable MethodHandle HANDLE$clEnqueueReadImage;
    public final @Nullable MethodHandle HANDLE$clEnqueueWriteImage;
    public final @Nullable MethodHandle HANDLE$clEnqueueFillImage;
    public final @Nullable MethodHandle HANDLE$clEnqueueCopyImage;
    public final @Nullable MethodHandle HANDLE$clEnqueueCopyImageToBuffer;
    public final @Nullable MethodHandle HANDLE$clEnqueueCopyBufferToImage;
    public final @Nullable MethodHandle HANDLE$clEnqueueMapBuffer;
    public final @Nullable MethodHandle HANDLE$clEnqueueMapImage;
    public final @Nullable MethodHandle HANDLE$clEnqueueUnmapMemObject;
    public final @Nullable MethodHandle HANDLE$clEnqueueMigrateMemObjects;
    public final @Nullable MethodHandle HANDLE$clEnqueueNDRangeKernel;
    public final @Nullable MethodHandle HANDLE$clEnqueueNativeKernel;
    public final @Nullable MethodHandle HANDLE$clEnqueueMarkerWithWaitList;
    public final @Nullable MethodHandle HANDLE$clEnqueueBarrierWithWaitList;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMFree;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMMemcpy;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMMemFill;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMMap;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMUnmap;
    public final @Nullable MethodHandle HANDLE$clEnqueueSVMMigrateMem;
    public final @Nullable MethodHandle HANDLE$clGetExtensionFunctionAddressForPlatform;
    public final @Nullable MethodHandle HANDLE$clSetCommandQueueProperty;
    public final @Nullable MethodHandle HANDLE$clCreateImage2D;
    public final @Nullable MethodHandle HANDLE$clCreateImage3D;
    public final @Nullable MethodHandle HANDLE$clEnqueueMarker;
    public final @Nullable MethodHandle HANDLE$clEnqueueWaitForEvents;
    public final @Nullable MethodHandle HANDLE$clEnqueueBarrier;
    public final @Nullable MethodHandle HANDLE$clUnloadCompiler;
    public final @Nullable MethodHandle HANDLE$clGetExtensionFunctionAddress;
    public final @Nullable MethodHandle HANDLE$clCreateCommandQueue;
    public final @Nullable MethodHandle HANDLE$clCreateSampler;
    public final @Nullable MethodHandle HANDLE$clEnqueueTask;
    public final @Nullable MethodHandle HANDLE$clGetLayerInfo;
    public final @Nullable MethodHandle HANDLE$clInitLayer;
    public final @Nullable MethodHandle HANDLE$clGetICDLoaderInfoOCLICD;
    public final @Nullable MethodHandle HANDLE$clGetSupportedGLTextureFormatsINTEL;
    public final @Nullable MethodHandle HANDLE$clGetSupportedDX9MediaSurfaceFormatsINTEL;
    public final @Nullable MethodHandle HANDLE$clGetSupportedD3D10TextureFormatsINTEL;
    public final @Nullable MethodHandle HANDLE$clGetSupportedD3D11TextureFormatsINTEL;
    public final @Nullable MethodHandle HANDLE$clGetSupportedVA_APIMediaSurfaceFormatsINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueReadHostPipeINTEL;
    public final @Nullable MethodHandle HANDLE$clEnqueueWriteHostPipeINTEL;
    public final @Nullable MethodHandle HANDLE$clGetImageRequirementsInfoEXT;
    public final @Nullable MethodHandle HANDLE$clCancelCommandsIMG;
    public final @Nullable MethodHandle HANDLE$clSetPerfHintQCOM;
    // endregion

    public static final class Descriptors {
        public static final FunctionDescriptor DESCRIPTOR$clGetDeviceIDsFromD3D10KHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromD3D10BufferKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromD3D10Texture2DKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromD3D10Texture3DKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueAcquireD3D10ObjectsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReleaseD3D10ObjectsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetDeviceIDsFromD3D11KHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromD3D11BufferKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromD3D11Texture2DKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromD3D11Texture3DKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueAcquireD3D11ObjectsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReleaseD3D11ObjectsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetDeviceIDsFromDX9MediaAdapterKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromDX9MediaSurfaceKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueAcquireDX9MediaSurfacesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReleaseDX9MediaSurfacesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetDeviceIDsFromDX9INTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromDX9MediaSurfaceINTEL = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueAcquireDX9ObjectsINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReleaseDX9ObjectsINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateEventFromEGLSyncKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromEGLImageKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueAcquireEGLObjectsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReleaseEGLObjectsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clLogMessagesToSystemLogAPPLE = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clLogMessagesToStdoutAPPLE = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clLogMessagesToStderrAPPLE = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clIcdGetPlatformIDsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clIcdGetFunctionAddressForPlatformKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$clIcdSetPlatformDispatchDataKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateProgramWithILKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clTerminateContextKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateCommandQueueWithPropertiesKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseDeviceEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainDeviceEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateSubDevicesEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMigrateMemObjectEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetDeviceImageInfoQCOM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS.withTargetLayout(CLImageFormat.LAYOUT),
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueAcquireGrallocObjectsIMG = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueGenerateMipmapIMG = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReleaseGrallocObjectsIMG = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetKernelSubGroupInfoKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetKernelSuggestedLocalWorkSizeKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateSemaphoreWithPropertiesKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueWaitSemaphoresKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSignalSemaphoresKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetSemaphoreInfoKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseSemaphoreKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainSemaphoreKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetSemaphoreHandleForTypeKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clReImportSemaphoreSyncFdKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueAcquireExternalMemObjectsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReleaseExternalMemObjectsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clImportMemoryARM = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clSVMAllocARM = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$clSVMFreeARM = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMFreeARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMMemcpyARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMMemFillARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMMapARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMUnmapARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetKernelArgSVMPointerARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetKernelExecInfoARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateAcceleratorINTEL = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetAcceleratorInfoINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainAcceleratorINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseAcceleratorINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateEventFromGLsyncKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetGLContextInfoKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromGLBuffer = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromGLTexture = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromGLRenderbuffer = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetGLObjectInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetGLTextureInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueAcquireGLObjects = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReleaseGLObjects = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromGLTexture2D = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromGLTexture3D = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetDeviceIDsFromVA_APIMediaAdapterINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateFromVA_APIMediaSurfaceINTEL = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueAcquireVA_APIMediaSurfacesINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReleaseVA_APIMediaSurfacesINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clHostMemAllocINTEL = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clDeviceMemAllocINTEL = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clSharedMemAllocINTEL = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clMemFreeINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clMemBlockingFreeINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetMemAllocInfoINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetKernelArgMemPointerINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMemsetINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMemFillINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMemcpyINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMigrateMemINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMemAdviseINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateBufferWithPropertiesINTEL = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.JAVA_LONG,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateCommandBufferKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clFinalizeCommandBufferKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainCommandBufferKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseCommandBufferKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueCommandBufferKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandBarrierWithWaitListKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandCopyBufferKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandCopyBufferRectKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandCopyBufferToImageKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandCopyImageKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandCopyImageToBufferKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandFillBufferKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandFillImageKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandNDRangeKernelKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandSVMMemcpyKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCommandSVMMemFillKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetCommandBufferInfoKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clUpdateMutableCommandsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetMutableCommandInfoKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRemapCommandBufferKHR = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetContentSizeBufferPoCL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetPlatformIDs = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetPlatformInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetDeviceIDs = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetDeviceInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateSubDevices = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainDevice = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseDevice = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetDefaultDeviceCommandQueue = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetDeviceAndHostTimer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetHostTimer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateContext = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateContextFromType = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainContext = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseContext = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetContextInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetContextDestructorCallback = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateCommandQueueWithProperties = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainCommandQueue = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseCommandQueue = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetCommandQueueInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateBuffer = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateBufferWithProperties = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.JAVA_LONG,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateSubBuffer = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateImage = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(CLImageFormat.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(CLImageDesc.LAYOUT),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateImageWithProperties = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(CLImageFormat.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(CLImageDesc.LAYOUT),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreatePipe = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainMemObject = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseMemObject = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetSupportedImageFormats = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(CLImageFormat.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetMemObjectInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetImageInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetPipeInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetMemObjectDestructorCallback = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetMemObjectDestructorAPPLE = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clSVMAlloc = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$clSVMFree = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateSamplerWithProperties = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainSampler = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseSampler = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetSamplerInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateProgramWithSource = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateProgramWithBinary = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateProgramWithBuiltInKernels = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateProgramWithIL = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainProgram = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseProgram = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clBuildProgram = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clCompileProgram = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clLinkProgram = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetProgramReleaseCallback = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetProgramSpecializationConstant = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clUnloadPlatformCompiler = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetProgramInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetProgramBuildInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateKernel = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateKernelsInProgram = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCloneKernel = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainKernel = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseKernel = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetKernelArg = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetKernelArgSVMPointer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetKernelArgDevicePointerEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetKernelExecInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetKernelInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetKernelArgInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetKernelWorkGroupInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetKernelSubGroupInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clWaitForEvents = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetEventInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateUserEvent = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clRetainEvent = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clReleaseEvent = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetUserEventStatus = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetEventCallback = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetEventProfilingInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clFlush = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clFinish = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReadBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReadBufferRect = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueWriteBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueWriteBufferRect = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueFillBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueCopyBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueCopyBufferRect = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReadImage = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueWriteImage = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueFillImage = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueCopyImage = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueCopyImageToBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueCopyBufferToImage = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMapBuffer = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMapImage = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueUnmapMemObject = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMigrateMemObjects = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueNDRangeKernel = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueNativeKernel = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMarkerWithWaitList = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueBarrierWithWaitList = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMFree = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMMemcpy = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMMemFill = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMMap = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMUnmap = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueSVMMigrateMem = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T),
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetExtensionFunctionAddressForPlatform = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetCommandQueueProperty = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateImage2D = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(CLImageFormat.LAYOUT),
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateImage3D = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(CLImageFormat.LAYOUT),
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueMarker = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueWaitForEvents = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueBarrier = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$clUnloadCompiler = FunctionDescriptor.of(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetExtensionFunctionAddress = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateCommandQueue = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCreateSampler = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueTask = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetLayerInfo = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clInitLayer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetICDLoaderInfoOCLICD = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetSupportedGLTextureFormatsINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetSupportedDX9MediaSurfaceFormatsINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetSupportedD3D10TextureFormatsINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetSupportedD3D11TextureFormatsINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetSupportedVA_APIMediaSurfaceFormatsINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VAImageFormatCLREF.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueReadHostPipeINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clEnqueueWriteHostPipeINTEL = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$clGetImageRequirementsInfoEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS.withTargetLayout(CLImageFormat.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(CLImageDesc.LAYOUT),
            ValueLayout.JAVA_INT,
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T)
        );

        public static final FunctionDescriptor DESCRIPTOR$clCancelCommandsIMG = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            NativeLayout.C_SIZE_T
        );

        public static final FunctionDescriptor DESCRIPTOR$clSetPerfHintQCOM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        /// Constructing this class is nonsense so the constructor is made private.
        private Descriptors() {}
    }
}
