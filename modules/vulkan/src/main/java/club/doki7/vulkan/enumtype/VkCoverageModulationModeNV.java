package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCoverageModulationModeNV.html"><code>VkCoverageModulationModeNV</code></a>
public final class VkCoverageModulationModeNV {
    public static final int NONE = 0x0;
    public static final int RGB = 0x1;
    public static final int ALPHA = 0x2;
    public static final int RGBA = 0x3;

    public static String explain(@EnumType(VkCoverageModulationModeNV.class) int value) {
        return switch (value) {
            case VkCoverageModulationModeNV.ALPHA -> "VK_COVERAGE_MODULATION_MODE_ALPHA_NV";
            case VkCoverageModulationModeNV.NONE -> "VK_COVERAGE_MODULATION_MODE_NONE_NV";
            case VkCoverageModulationModeNV.RGBA -> "VK_COVERAGE_MODULATION_MODE_RGBA_NV";
            case VkCoverageModulationModeNV.RGB -> "VK_COVERAGE_MODULATION_MODE_RGB_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCoverageModulationModeNV() {}
}
