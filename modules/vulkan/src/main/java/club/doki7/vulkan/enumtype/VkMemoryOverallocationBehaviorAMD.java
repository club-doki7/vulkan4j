package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryOverallocationBehaviorAMD.html"><code>VkMemoryOverallocationBehaviorAMD</code></a>
public final class VkMemoryOverallocationBehaviorAMD {
    public static final int DEFAULT = 0x0;
    public static final int ALLOWED = 0x1;
    public static final int DISALLOWED = 0x2;

    public static String explain(@EnumType(VkMemoryOverallocationBehaviorAMD.class) int value) {
        return switch (value) {
            case VkMemoryOverallocationBehaviorAMD.ALLOWED -> "VK_MEMORY_OVERALLOCATION_BEHAVIOR_ALLOWED_AMD";
            case VkMemoryOverallocationBehaviorAMD.DEFAULT -> "VK_MEMORY_OVERALLOCATION_BEHAVIOR_DEFAULT_AMD";
            case VkMemoryOverallocationBehaviorAMD.DISALLOWED -> "VK_MEMORY_OVERALLOCATION_BEHAVIOR_DISALLOWED_AMD";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkMemoryOverallocationBehaviorAMD() {}
}
