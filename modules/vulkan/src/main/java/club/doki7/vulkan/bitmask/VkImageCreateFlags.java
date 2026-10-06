package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCreateFlags.html"><code>VkImageCreateFlags</code></a>
public final class VkImageCreateFlags {
    public static final int _2D_ARRAY_COMPATIBLE = 0x20;
    public static final int _2D_VIEW_COMPATIBLE_EXT = 0x20000;
    public static final int ALIAS = 0x400;
    public static final int ALIAS_SINGLE_LAYER_DESCRIPTOR_KHR = 0x400000;
    public static final int BLOCK_TEXEL_VIEW_COMPATIBLE = 0x80;
    public static final int CORNER_SAMPLED_NV = 0x2000;
    public static final int CUBE_COMPATIBLE = 0x10;
    public static final int DESCRIPTOR_HEAP_CAPTURE_REPLAY_EXT = 0x10000;
    public static final int DISJOINT = 0x200;
    public static final int EXTENDED_USAGE = 0x100;
    public static final int FRAGMENT_DENSITY_MAP_OFFSET_EXT = 0x8000;
    public static final int MULTISAMPLED_RENDER_TO_SINGLE_SAMPLED_EXT = 0x40000;
    public static final int MUTABLE_FORMAT = 0x8;
    public static final int PROTECTED = 0x800;
    public static final int SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_EXT = 0x1000;
    public static final int SPARSE_ALIASED = 0x4;
    public static final int SPARSE_BINDING = 0x1;
    public static final int SPARSE_RESIDENCY = 0x2;
    public static final int SPLIT_INSTANCE_BIND_REGIONS = 0x40;
    public static final int SUBSAMPLED_EXT = 0x4000;
    public static final int VIDEO_PROFILE_INDEPENDENT_KHR = 0x100000;

    public static String explain(@Bitmask(VkImageCreateFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & _2D_ARRAY_COMPATIBLE) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2D_ARRAY_COMPATIBLE_BIT");
        }
        if ((flags & _2D_VIEW_COMPATIBLE_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2D_VIEW_COMPATIBLE_BIT_EXT");
        }
        if ((flags & ALIAS) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_ALIAS_BIT");
        }
        if ((flags & ALIAS_SINGLE_LAYER_DESCRIPTOR_KHR) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_ALIAS_SINGLE_LAYER_DESCRIPTOR_BIT_KHR");
        }
        if ((flags & BLOCK_TEXEL_VIEW_COMPATIBLE) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_BLOCK_TEXEL_VIEW_COMPATIBLE_BIT");
        }
        if ((flags & CORNER_SAMPLED_NV) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_CORNER_SAMPLED_BIT_NV");
        }
        if ((flags & CUBE_COMPATIBLE) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_CUBE_COMPATIBLE_BIT");
        }
        if ((flags & DESCRIPTOR_HEAP_CAPTURE_REPLAY_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_DESCRIPTOR_HEAP_CAPTURE_REPLAY_BIT_EXT");
        }
        if ((flags & DISJOINT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_DISJOINT_BIT");
        }
        if ((flags & EXTENDED_USAGE) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_EXTENDED_USAGE_BIT");
        }
        if ((flags & FRAGMENT_DENSITY_MAP_OFFSET_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_FRAGMENT_DENSITY_MAP_OFFSET_BIT_EXT");
        }
        if ((flags & MULTISAMPLED_RENDER_TO_SINGLE_SAMPLED_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_MULTISAMPLED_RENDER_TO_SINGLE_SAMPLED_BIT_EXT");
        }
        if ((flags & MUTABLE_FORMAT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_MUTABLE_FORMAT_BIT");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_PROTECTED_BIT");
        }
        if ((flags & SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT");
        }
        if ((flags & SPARSE_ALIASED) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_SPARSE_ALIASED_BIT");
        }
        if ((flags & SPARSE_BINDING) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_SPARSE_BINDING_BIT");
        }
        if ((flags & SPARSE_RESIDENCY) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT");
        }
        if ((flags & SPLIT_INSTANCE_BIND_REGIONS) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT");
        }
        if ((flags & SUBSAMPLED_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_SUBSAMPLED_BIT_EXT");
        }
        if ((flags & VIDEO_PROFILE_INDEPENDENT_KHR) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_VIDEO_PROFILE_INDEPENDENT_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageCreateFlags() {}
}
