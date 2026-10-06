package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkInternalAllocationType.html"><code>VkInternalAllocationType</code></a>
public final class VkInternalAllocationType {
    public static final int EXECUTABLE = 0x0;

    public static String explain(@EnumType(VkInternalAllocationType.class) int value) {
        return switch (value) {
            case VkInternalAllocationType.EXECUTABLE -> "VK_INTERNAL_ALLOCATION_TYPE_EXECUTABLE";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkInternalAllocationType() {}
}
