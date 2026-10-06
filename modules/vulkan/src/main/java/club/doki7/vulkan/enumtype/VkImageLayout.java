package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageLayout.html"><code>VkImageLayout</code></a>
public final class VkImageLayout {
    public static final int UNDEFINED = 0x0;
    public static final int GENERAL = 0x1;
    public static final int COLOR_ATTACHMENT_OPTIMAL = 0x2;
    public static final int DEPTH_STENCIL_ATTACHMENT_OPTIMAL = 0x3;
    public static final int DEPTH_STENCIL_READ_ONLY_OPTIMAL = 0x4;
    public static final int SHADER_READ_ONLY_OPTIMAL = 0x5;
    public static final int TRANSFER_SRC_OPTIMAL = 0x6;
    public static final int TRANSFER_DST_OPTIMAL = 0x7;
    public static final int PREINITIALIZED = 0x8;
    public static final int DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL = 0x3b9c9308;
    public static final int DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL = 0x3b9c9309;
    public static final int DEPTH_ATTACHMENT_OPTIMAL = 0x3b9e7768;
    public static final int DEPTH_READ_ONLY_OPTIMAL = 0x3b9e7769;
    public static final int STENCIL_ATTACHMENT_OPTIMAL = 0x3b9e776a;
    public static final int STENCIL_READ_ONLY_OPTIMAL = 0x3b9e776b;
    public static final int READ_ONLY_OPTIMAL = 0x3b9f9490;
    public static final int ATTACHMENT_OPTIMAL = 0x3b9f9491;
    public static final int RENDERING_LOCAL_READ = 0x3b9e5440;
    public static final int PRESENT_SRC_KHR = 0x3b9acdea;
    public static final int VIDEO_DECODE_DST_KHR = 0x3b9b27c0;
    public static final int VIDEO_DECODE_SRC_KHR = 0x3b9b27c1;
    public static final int VIDEO_DECODE_DPB_KHR = 0x3b9b27c2;
    public static final int SHARED_PRESENT_KHR = 0x3b9c7b98;
    public static final int FRAGMENT_DENSITY_MAP_OPTIMAL_EXT = 0x3b9e1d90;
    public static final int FRAGMENT_SHADING_RATE_ATTACHMENT_OPTIMAL_KHR = 0x3b9d4aa3;
    public static final int VIDEO_ENCODE_DST_KHR = 0x3b9f59f8;
    public static final int VIDEO_ENCODE_SRC_KHR = 0x3b9f59f9;
    public static final int VIDEO_ENCODE_DPB_KHR = 0x3b9f59fa;
    public static final int ATTACHMENT_FEEDBACK_LOOP_OPTIMAL_EXT = 0x3b9ff638;
    public static final int TENSOR_ALIASING_ARM = 0x3ba1cee0;
    public static final int VIDEO_ENCODE_QUANTIZATION_MAP_KHR = 0x3ba33a28;
    public static final int ZERO_INITIALIZED_EXT = 0x3ba43fe0;

    public static String explain(@EnumType(VkImageLayout.class) int value) {
        return switch (value) {
            case VkImageLayout.ATTACHMENT_FEEDBACK_LOOP_OPTIMAL_EXT -> "VK_IMAGE_LAYOUT_ATTACHMENT_FEEDBACK_LOOP_OPTIMAL_EXT";
            case VkImageLayout.ATTACHMENT_OPTIMAL -> "VK_IMAGE_LAYOUT_ATTACHMENT_OPTIMAL";
            case VkImageLayout.COLOR_ATTACHMENT_OPTIMAL -> "VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL";
            case VkImageLayout.DEPTH_ATTACHMENT_OPTIMAL -> "VK_IMAGE_LAYOUT_DEPTH_ATTACHMENT_OPTIMAL";
            case VkImageLayout.DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL -> "VK_IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL";
            case VkImageLayout.DEPTH_READ_ONLY_OPTIMAL -> "VK_IMAGE_LAYOUT_DEPTH_READ_ONLY_OPTIMAL";
            case VkImageLayout.DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL -> "VK_IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL";
            case VkImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL -> "VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL";
            case VkImageLayout.DEPTH_STENCIL_READ_ONLY_OPTIMAL -> "VK_IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL";
            case VkImageLayout.FRAGMENT_DENSITY_MAP_OPTIMAL_EXT -> "VK_IMAGE_LAYOUT_FRAGMENT_DENSITY_MAP_OPTIMAL_EXT";
            case VkImageLayout.FRAGMENT_SHADING_RATE_ATTACHMENT_OPTIMAL_KHR -> "VK_IMAGE_LAYOUT_FRAGMENT_SHADING_RATE_ATTACHMENT_OPTIMAL_KHR";
            case VkImageLayout.GENERAL -> "VK_IMAGE_LAYOUT_GENERAL";
            case VkImageLayout.PREINITIALIZED -> "VK_IMAGE_LAYOUT_PREINITIALIZED";
            case VkImageLayout.PRESENT_SRC_KHR -> "VK_IMAGE_LAYOUT_PRESENT_SRC_KHR";
            case VkImageLayout.READ_ONLY_OPTIMAL -> "VK_IMAGE_LAYOUT_READ_ONLY_OPTIMAL";
            case VkImageLayout.RENDERING_LOCAL_READ -> "VK_IMAGE_LAYOUT_RENDERING_LOCAL_READ";
            case VkImageLayout.SHADER_READ_ONLY_OPTIMAL -> "VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL";
            case VkImageLayout.SHARED_PRESENT_KHR -> "VK_IMAGE_LAYOUT_SHARED_PRESENT_KHR";
            case VkImageLayout.STENCIL_ATTACHMENT_OPTIMAL -> "VK_IMAGE_LAYOUT_STENCIL_ATTACHMENT_OPTIMAL";
            case VkImageLayout.STENCIL_READ_ONLY_OPTIMAL -> "VK_IMAGE_LAYOUT_STENCIL_READ_ONLY_OPTIMAL";
            case VkImageLayout.TENSOR_ALIASING_ARM -> "VK_IMAGE_LAYOUT_TENSOR_ALIASING_ARM";
            case VkImageLayout.TRANSFER_DST_OPTIMAL -> "VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL";
            case VkImageLayout.TRANSFER_SRC_OPTIMAL -> "VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL";
            case VkImageLayout.UNDEFINED -> "VK_IMAGE_LAYOUT_UNDEFINED";
            case VkImageLayout.VIDEO_DECODE_DPB_KHR -> "VK_IMAGE_LAYOUT_VIDEO_DECODE_DPB_KHR";
            case VkImageLayout.VIDEO_DECODE_DST_KHR -> "VK_IMAGE_LAYOUT_VIDEO_DECODE_DST_KHR";
            case VkImageLayout.VIDEO_DECODE_SRC_KHR -> "VK_IMAGE_LAYOUT_VIDEO_DECODE_SRC_KHR";
            case VkImageLayout.VIDEO_ENCODE_DPB_KHR -> "VK_IMAGE_LAYOUT_VIDEO_ENCODE_DPB_KHR";
            case VkImageLayout.VIDEO_ENCODE_DST_KHR -> "VK_IMAGE_LAYOUT_VIDEO_ENCODE_DST_KHR";
            case VkImageLayout.VIDEO_ENCODE_QUANTIZATION_MAP_KHR -> "VK_IMAGE_LAYOUT_VIDEO_ENCODE_QUANTIZATION_MAP_KHR";
            case VkImageLayout.VIDEO_ENCODE_SRC_KHR -> "VK_IMAGE_LAYOUT_VIDEO_ENCODE_SRC_KHR";
            case VkImageLayout.ZERO_INITIALIZED_EXT -> "VK_IMAGE_LAYOUT_ZERO_INITIALIZED_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageLayout() {}
}
