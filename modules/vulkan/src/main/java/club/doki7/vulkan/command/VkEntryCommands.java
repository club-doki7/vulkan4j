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

public final class VkEntryCommands {
    public VkEntryCommands(RawFunctionLoader loader) {
        SEGMENT$vkCreateInstance = loader.apply("vkCreateInstance");
        HANDLE$vkCreateInstance = RawFunctionLoader.link(SEGMENT$vkCreateInstance, Descriptors.DESCRIPTOR$vkCreateInstance);
        SEGMENT$vkEnumerateInstanceExtensionProperties = loader.apply("vkEnumerateInstanceExtensionProperties");
        HANDLE$vkEnumerateInstanceExtensionProperties = RawFunctionLoader.link(SEGMENT$vkEnumerateInstanceExtensionProperties, Descriptors.DESCRIPTOR$vkEnumerateInstanceExtensionProperties);
        SEGMENT$vkEnumerateInstanceLayerProperties = loader.apply("vkEnumerateInstanceLayerProperties");
        HANDLE$vkEnumerateInstanceLayerProperties = RawFunctionLoader.link(SEGMENT$vkEnumerateInstanceLayerProperties, Descriptors.DESCRIPTOR$vkEnumerateInstanceLayerProperties);
        SEGMENT$vkEnumerateInstanceVersion = loader.apply("vkEnumerateInstanceVersion");
        HANDLE$vkEnumerateInstanceVersion = RawFunctionLoader.link(SEGMENT$vkEnumerateInstanceVersion, Descriptors.DESCRIPTOR$vkEnumerateInstanceVersion);
    }

    // region command wrappers

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateInstance.html"><code>vkCreateInstance</code></a>
    public @EnumType(VkResult.class) int createInstance(
        @Pointer VkInstanceCreateInfo pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkInstance.Ptr pInstance
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateInstance);
        try {
            return (int) hFunction.invokeExact(
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pInstance.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumerateInstanceExtensionProperties.html"><code>vkEnumerateInstanceExtensionProperties</code></a>
    public @EnumType(VkResult.class) int enumerateInstanceExtensionProperties(
        @Nullable BytePtr pLayerName,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkExtensionProperties pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumerateInstanceExtensionProperties);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (pLayerName != null ? pLayerName.segment() : MemorySegment.NULL),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumerateInstanceLayerProperties.html"><code>vkEnumerateInstanceLayerProperties</code></a>
    public @EnumType(VkResult.class) int enumerateInstanceLayerProperties(
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkLayerProperties pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumerateInstanceLayerProperties);
        try {
            return (int) hFunction.invokeExact(
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumerateInstanceVersion.html"><code>vkEnumerateInstanceVersion</code></a>
    public @EnumType(VkResult.class) int enumerateInstanceVersion(
        @Unsigned IntPtr pApiVersion
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumerateInstanceVersion);
        try {
            return (int) hFunction.invokeExact(
                pApiVersion.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    // endregion

    // region segments and handles
    public final @Nullable MemorySegment SEGMENT$vkCreateInstance;
    public final @Nullable MemorySegment SEGMENT$vkEnumerateInstanceExtensionProperties;
    public final @Nullable MemorySegment SEGMENT$vkEnumerateInstanceLayerProperties;
    public final @Nullable MemorySegment SEGMENT$vkEnumerateInstanceVersion;
    public final @Nullable MethodHandle HANDLE$vkCreateInstance;
    public final @Nullable MethodHandle HANDLE$vkEnumerateInstanceExtensionProperties;
    public final @Nullable MethodHandle HANDLE$vkEnumerateInstanceLayerProperties;
    public final @Nullable MethodHandle HANDLE$vkEnumerateInstanceVersion;
    // endregion

    public static final class Descriptors {
        public static final FunctionDescriptor DESCRIPTOR$vkCreateInstance = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkInstanceCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumerateInstanceExtensionProperties = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkExtensionProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumerateInstanceLayerProperties = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkLayerProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumerateInstanceVersion = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        /// Constructing this class is nonsense so the constructor is made private.
        private Descriptors() {}
    }
}
