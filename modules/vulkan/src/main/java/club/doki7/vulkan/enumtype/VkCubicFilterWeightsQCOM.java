package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCubicFilterWeightsQCOM.html"><code>VkCubicFilterWeightsQCOM</code></a>
public final class VkCubicFilterWeightsQCOM {
    public static final int CATMULL_ROM = 0x0;
    public static final int ZERO_TANGENT_CARDINAL = 0x1;
    public static final int B_SPLINE = 0x2;
    public static final int MITCHELL_NETRAVALI = 0x3;

    public static String explain(@EnumType(VkCubicFilterWeightsQCOM.class) int value) {
        return switch (value) {
            case VkCubicFilterWeightsQCOM.B_SPLINE -> "VK_CUBIC_FILTER_WEIGHTS_B_SPLINE_QCOM";
            case VkCubicFilterWeightsQCOM.CATMULL_ROM -> "VK_CUBIC_FILTER_WEIGHTS_CATMULL_ROM_QCOM";
            case VkCubicFilterWeightsQCOM.MITCHELL_NETRAVALI -> "VK_CUBIC_FILTER_WEIGHTS_MITCHELL_NETRAVALI_QCOM";
            case VkCubicFilterWeightsQCOM.ZERO_TANGENT_CARDINAL -> "VK_CUBIC_FILTER_WEIGHTS_ZERO_TANGENT_CARDINAL_QCOM";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCubicFilterWeightsQCOM() {}
}
