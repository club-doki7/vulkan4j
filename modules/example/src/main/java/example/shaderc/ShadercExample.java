package example.shaderc;

import club.doki7.ffm.library.ILibraryLoader;
import club.doki7.ffm.library.ISharedLibrary;
import club.doki7.ffm.ptr.BytePtr;
import club.doki7.shaderc.Shaderc;
import club.doki7.shaderc.ShadercUtil;
import club.doki7.shaderc.enumtype.ShadercShaderKind;
import club.doki7.shaderc.handle.ShadercCompilationResult;
import club.doki7.shaderc.handle.ShadercCompileOptions;
import club.doki7.shaderc.handle.ShadercCompiler;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public final class ShadercExample {
    public static void main(String[] args) throws IOException {
        ISharedLibrary libShaderc = ILibraryLoader.platformLoader().loadLibrary("shaderc_shared");
        Shaderc shaderc = new Shaderc(libShaderc);

        String shaderCode = Files.readString(Path.of("example/resc/nop1.comp"));

        ShadercCompiler compiler = shaderc.compilerInitialize();
        ShadercCompileOptions options = shaderc.compileOptionsInitialize();

        try (Arena arena = Arena.ofConfined()) {
            ShadercUtil.IncludeCallbacks callbacks = ShadercUtil.makeCallbacks(
                    arena,
                    (requestedSource, _, _, _) -> {
                        System.err.println("including source: " + requestedSource);
                        String content = Files.readString(Path.of("example/resc/" + requestedSource));
                        return new ShadercUtil.IncludeResult(requestedSource, content);
                    }
            );
            shaderc.compileOptionsSetIncludeCallbacks(
                    options,
                    callbacks.pfnIncludeResolve,
                    callbacks.pfnIncludeResultRelease,
                    MemorySegment.NULL
            );

            BytePtr pFileName = BytePtr.allocateString(arena, "nop.comp");
            BytePtr pEntryName = BytePtr.allocateString(arena, "main");

            BytePtr pShaderCode = BytePtr.allocateString(arena, shaderCode);
            ShadercCompilationResult result = shaderc.compileIntoSPVAssembly(
                    compiler,
                    pShaderCode,
                    pShaderCode.size() - 1,
                    ShadercShaderKind.COMPUTE_SHADER,
                    pFileName,
                    pEntryName,
                    options
            );
            long numErrors = shaderc.resultGetNumErrors(result);
            if (numErrors > 0) {
                System.err.println("Compilation failed with " + numErrors + " errors:");
                for (int i = 0; i < numErrors; i++) {
                    BytePtr errorMessage = Objects.requireNonNull(shaderc.resultGetErrorMessage(result));
                    System.err.println("Error " + (i + 1) + ": " + errorMessage.readString());
                }
                shaderc.resultRelease(result);
                return;
            }

            BytePtr spvAssembly = Objects.requireNonNull(shaderc.resultGetBytes(result));
            System.out.println("SPIR-V assembly (text):");
            System.out.println(spvAssembly.readString());

            result = shaderc.compileIntoSPV(
                    compiler,
                    pShaderCode,
                    pShaderCode.size() - 1,
                    ShadercShaderKind.COMPUTE_SHADER,
                    pFileName,
                    pEntryName,
                    options
            );
            numErrors = shaderc.resultGetNumErrors(result);
            if (numErrors > 0) {
                System.err.println("Compilation to SPIR-V failed with " + numErrors + " errors:");
                for (int i = 0; i < numErrors; i++) {
                    BytePtr errorMessage = Objects.requireNonNull(shaderc.resultGetErrorMessage(result));
                    System.err.println("Error " + (i + 1) + ": " + errorMessage.readString());
                }
                shaderc.resultRelease(result);
                return;
            }

            long numBytes = shaderc.resultGetLength(result);
            BytePtr spv = Objects.requireNonNull(shaderc.resultGetBytes(result)).reinterpret(numBytes);
            System.out.println("SPIR-V binary size: " + numBytes + " bytes");
            System.out.println("SPIR-V binary (hex):");
            for (long i = 0; i < numBytes; i++) {
                System.out.printf("%02x ", spv.read(i));
                if ((i + 1) % 16 == 0) {
                    System.out.println();
                }
            }
        } finally {
            shaderc.compileOptionsRelease(options);
            shaderc.compilerRelease(compiler);
            libShaderc.close();
        }
    }
}
