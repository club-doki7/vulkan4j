package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDescriptionFlags.html"><code>VkSubpassDescriptionFlags</code></a>
public final class VkSubpassDescriptionFlags {
    public static final int CUSTOM_RESOLVE_EXT = 0x8;
    public static final int ENABLE_LEGACY_DITHERING_EXT = 0x80;
    public static final int FRAGMENT_REGION_EXT = 0x4;
    public static final int PER_VIEW_ATTRIBUTES_NVX = 0x1;
    public static final int PER_VIEW_POSITION_X_ONLY_NVX = 0x2;
    public static final int RASTERIZATION_ORDER_ATTACHMENT_COLOR_ACCESS_EXT = 0x10;
    public static final int RASTERIZATION_ORDER_ATTACHMENT_DEPTH_ACCESS_EXT = 0x20;
    public static final int RASTERIZATION_ORDER_ATTACHMENT_STENCIL_ACCESS_EXT = 0x40;
    public static final int TILE_SHADING_APRON_QCOM = 0x100;

    public static String explain(@Bitmask(VkSubpassDescriptionFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & CUSTOM_RESOLVE_EXT) != 0) {
            detectedFlagBits.add("VK_SUBPASS_DESCRIPTION_CUSTOM_RESOLVE_BIT_EXT");
        }
        if ((flags & ENABLE_LEGACY_DITHERING_EXT) != 0) {
            detectedFlagBits.add("VK_SUBPASS_DESCRIPTION_ENABLE_LEGACY_DITHERING_BIT_EXT");
        }
        if ((flags & FRAGMENT_REGION_EXT) != 0) {
            detectedFlagBits.add("VK_SUBPASS_DESCRIPTION_FRAGMENT_REGION_BIT_EXT");
        }
        if ((flags & PER_VIEW_ATTRIBUTES_NVX) != 0) {
            detectedFlagBits.add("VK_SUBPASS_DESCRIPTION_PER_VIEW_ATTRIBUTES_BIT_NVX");
        }
        if ((flags & PER_VIEW_POSITION_X_ONLY_NVX) != 0) {
            detectedFlagBits.add("VK_SUBPASS_DESCRIPTION_PER_VIEW_POSITION_X_ONLY_BIT_NVX");
        }
        if ((flags & RASTERIZATION_ORDER_ATTACHMENT_COLOR_ACCESS_EXT) != 0) {
            detectedFlagBits.add("VK_SUBPASS_DESCRIPTION_RASTERIZATION_ORDER_ATTACHMENT_COLOR_ACCESS_BIT_EXT");
        }
        if ((flags & RASTERIZATION_ORDER_ATTACHMENT_DEPTH_ACCESS_EXT) != 0) {
            detectedFlagBits.add("VK_SUBPASS_DESCRIPTION_RASTERIZATION_ORDER_ATTACHMENT_DEPTH_ACCESS_BIT_EXT");
        }
        if ((flags & RASTERIZATION_ORDER_ATTACHMENT_STENCIL_ACCESS_EXT) != 0) {
            detectedFlagBits.add("VK_SUBPASS_DESCRIPTION_RASTERIZATION_ORDER_ATTACHMENT_STENCIL_ACCESS_BIT_EXT");
        }
        if ((flags & TILE_SHADING_APRON_QCOM) != 0) {
            detectedFlagBits.add("VK_SUBPASS_DESCRIPTION_TILE_SHADING_APRON_BIT_QCOM");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSubpassDescriptionFlags() {}
}
