package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassMergeStatusEXT.html"><code>VkSubpassMergeStatusEXT</code></a>
public final class VkSubpassMergeStatusEXT {
    public static final int MERGED = 0x0;
    public static final int DISALLOWED = 0x1;
    public static final int NOT_MERGED_SIDE_EFFECTS = 0x2;
    public static final int NOT_MERGED_SAMPLES_MISMATCH = 0x3;
    public static final int NOT_MERGED_VIEWS_MISMATCH = 0x4;
    public static final int NOT_MERGED_ALIASING = 0x5;
    public static final int NOT_MERGED_DEPENDENCIES = 0x6;
    public static final int NOT_MERGED_INCOMPATIBLE_INPUT_ATTACHMENT = 0x7;
    public static final int NOT_MERGED_TOO_MANY_ATTACHMENTS = 0x8;
    public static final int NOT_MERGED_INSUFFICIENT_STORAGE = 0x9;
    public static final int NOT_MERGED_DEPTH_STENCIL_COUNT = 0xa;
    public static final int NOT_MERGED_RESOLVE_ATTACHMENT_REUSE = 0xb;
    public static final int NOT_MERGED_SINGLE_SUBPASS = 0xc;
    public static final int NOT_MERGED_UNSPECIFIED = 0xd;

    public static String explain(@EnumType(VkSubpassMergeStatusEXT.class) int value) {
        return switch (value) {
            case VkSubpassMergeStatusEXT.DISALLOWED -> "VK_SUBPASS_MERGE_STATUS_DISALLOWED_EXT";
            case VkSubpassMergeStatusEXT.MERGED -> "VK_SUBPASS_MERGE_STATUS_MERGED_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_ALIASING -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_ALIASING_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_DEPENDENCIES -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_DEPENDENCIES_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_DEPTH_STENCIL_COUNT -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_DEPTH_STENCIL_COUNT_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_INCOMPATIBLE_INPUT_ATTACHMENT -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_INCOMPATIBLE_INPUT_ATTACHMENT_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_INSUFFICIENT_STORAGE -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_INSUFFICIENT_STORAGE_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_RESOLVE_ATTACHMENT_REUSE -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_RESOLVE_ATTACHMENT_REUSE_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_SAMPLES_MISMATCH -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_SAMPLES_MISMATCH_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_SIDE_EFFECTS -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_SIDE_EFFECTS_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_SINGLE_SUBPASS -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_SINGLE_SUBPASS_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_TOO_MANY_ATTACHMENTS -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_TOO_MANY_ATTACHMENTS_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_UNSPECIFIED -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_UNSPECIFIED_EXT";
            case VkSubpassMergeStatusEXT.NOT_MERGED_VIEWS_MISMATCH -> "VK_SUBPASS_MERGE_STATUS_NOT_MERGED_VIEWS_MISMATCH_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSubpassMergeStatusEXT() {}
}
