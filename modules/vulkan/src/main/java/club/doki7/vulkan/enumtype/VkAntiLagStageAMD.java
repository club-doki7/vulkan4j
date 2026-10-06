package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAntiLagStageAMD.html"><code>VkAntiLagStageAMD</code></a>
public final class VkAntiLagStageAMD {
    public static final int INPUT = 0x0;
    public static final int PRESENT = 0x1;

    public static String explain(@EnumType(VkAntiLagStageAMD.class) int value) {
        return switch (value) {
            case VkAntiLagStageAMD.INPUT -> "VK_ANTI_LAG_STAGE_INPUT_AMD";
            case VkAntiLagStageAMD.PRESENT -> "VK_ANTI_LAG_STAGE_PRESENT_AMD";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkAntiLagStageAMD() {}
}
