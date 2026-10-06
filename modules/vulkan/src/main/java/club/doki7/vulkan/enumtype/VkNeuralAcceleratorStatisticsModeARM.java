package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkNeuralAcceleratorStatisticsModeARM.html"><code>VkNeuralAcceleratorStatisticsModeARM</code></a>
public final class VkNeuralAcceleratorStatisticsModeARM {
    public static final int DISABLED = 0x0;
    public static final int STATISTICS0 = 0x1;
    public static final int STATISTICS1 = 0x2;

    public static String explain(@EnumType(VkNeuralAcceleratorStatisticsModeARM.class) int value) {
        return switch (value) {
            case VkNeuralAcceleratorStatisticsModeARM.DISABLED -> "VK_NEURAL_ACCELERATOR_STATISTICS_MODE_DISABLED_ARM";
            case VkNeuralAcceleratorStatisticsModeARM.STATISTICS0 -> "VK_NEURAL_ACCELERATOR_STATISTICS_MODE_STATISTICS0_ARM";
            case VkNeuralAcceleratorStatisticsModeARM.STATISTICS1 -> "VK_NEURAL_ACCELERATOR_STATISTICS_MODE_STATISTICS1_ARM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkNeuralAcceleratorStatisticsModeARM() {}
}
