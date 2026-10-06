package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaSampleTypeAMD.html"><code>VkGpaSampleTypeAMD</code></a>
public final class VkGpaSampleTypeAMD {
    public static final int CUMULATIVE = 0x0;
    public static final int TRACE = 0x1;
    public static final int TIMING = 0x2;

    public static String explain(@EnumType(VkGpaSampleTypeAMD.class) int value) {
        return switch (value) {
            case VkGpaSampleTypeAMD.CUMULATIVE -> "VK_GPA_SAMPLE_TYPE_CUMULATIVE_AMD";
            case VkGpaSampleTypeAMD.TIMING -> "VK_GPA_SAMPLE_TYPE_TIMING_AMD";
            case VkGpaSampleTypeAMD.TRACE -> "VK_GPA_SAMPLE_TYPE_TRACE_AMD";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkGpaSampleTypeAMD() {}
}
