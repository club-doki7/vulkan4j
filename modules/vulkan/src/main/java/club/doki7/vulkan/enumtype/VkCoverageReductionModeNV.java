package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCoverageReductionModeNV.html"><code>VkCoverageReductionModeNV</code></a>
public final class VkCoverageReductionModeNV {
    public static final int MERGE = 0x0;
    public static final int TRUNCATE = 0x1;

    public static String explain(@EnumType(VkCoverageReductionModeNV.class) int value) {
        return switch (value) {
            case VkCoverageReductionModeNV.MERGE -> "VK_COVERAGE_REDUCTION_MODE_MERGE_NV";
            case VkCoverageReductionModeNV.TRUNCATE -> "VK_COVERAGE_REDUCTION_MODE_TRUNCATE_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkCoverageReductionModeNV() {}
}
