package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1PredictionModeKHR.html"><code>VkVideoEncodeAV1PredictionModeKHR</code></a>
public final class VkVideoEncodeAV1PredictionModeKHR {
    public static final int VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_INTRA_ONLY = 0x0;
    public static final int VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_SINGLE_REFERENCE = 0x1;
    public static final int VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_UNIDIRECTIONAL_COMPOUND = 0x2;
    public static final int VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_BIDIRECTIONAL_COMPOUND = 0x3;

    public static String explain(@EnumType(VkVideoEncodeAV1PredictionModeKHR.class) int value) {
        return switch (value) {
            case VkVideoEncodeAV1PredictionModeKHR.VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_BIDIRECTIONAL_COMPOUND -> "VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_BIDIRECTIONAL_COMPOUND_KHR";
            case VkVideoEncodeAV1PredictionModeKHR.VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_INTRA_ONLY -> "VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_INTRA_ONLY_KHR";
            case VkVideoEncodeAV1PredictionModeKHR.VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_SINGLE_REFERENCE -> "VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_SINGLE_REFERENCE_KHR";
            case VkVideoEncodeAV1PredictionModeKHR.VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_UNIDIRECTIONAL_COMPOUND -> "VK_VIDEO_ENCODE_AV1_PREDICTION_MODE_UNIDIRECTIONAL_COMPOUND_KHR";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkVideoEncodeAV1PredictionModeKHR() {}
}
