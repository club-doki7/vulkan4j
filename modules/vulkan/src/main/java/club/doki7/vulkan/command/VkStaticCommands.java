package club.doki7.vulkan.command;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.RawFunctionLoader;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;
import static club.doki7.vulkan.VkFunctionTypes.*;

public final class VkStaticCommands {
    public VkStaticCommands(RawFunctionLoader loader) {
        SEGMENT$vkGetDeviceProcAddr = loader.apply("vkGetDeviceProcAddr");
        HANDLE$vkGetDeviceProcAddr = RawFunctionLoader.link(SEGMENT$vkGetDeviceProcAddr, Descriptors.DESCRIPTOR$vkGetDeviceProcAddr);
        SEGMENT$vkGetInstanceProcAddr = loader.apply("vkGetInstanceProcAddr");
        HANDLE$vkGetInstanceProcAddr = RawFunctionLoader.link(SEGMENT$vkGetInstanceProcAddr, Descriptors.DESCRIPTOR$vkGetInstanceProcAddr);
    }

    // region command wrappers

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetDeviceProcAddr.html"><code>vkGetDeviceProcAddr</code></a>
    public @Pointer(comment="PFN_vkVoidFunction") @NotNull MemorySegment getDeviceProcAddr(
        VkDevice device,
        BytePtr pName
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetDeviceProcAddr);
        try {
            return (MemorySegment) hFunction.invokeExact(
                device.segment(),
                pName.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetInstanceProcAddr.html"><code>vkGetInstanceProcAddr</code></a>
    public @Pointer(comment="PFN_vkVoidFunction") @NotNull MemorySegment getInstanceProcAddr(
        @Nullable VkInstance instance,
        BytePtr pName
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetInstanceProcAddr);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (instance != null ? instance.segment() : MemorySegment.NULL),
                pName.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    // endregion

    // region segments and handles
    public final @Nullable MemorySegment SEGMENT$vkGetDeviceProcAddr;
    public final @Nullable MemorySegment SEGMENT$vkGetInstanceProcAddr;
    public final @Nullable MethodHandle HANDLE$vkGetDeviceProcAddr;
    public final @Nullable MethodHandle HANDLE$vkGetInstanceProcAddr;
    // endregion

    public static final class Descriptors {
        public static final FunctionDescriptor DESCRIPTOR$vkGetDeviceProcAddr = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetInstanceProcAddr = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        /// Constructing this class is nonsense so the constructor is made private.
        private Descriptors() {}
    }
}
