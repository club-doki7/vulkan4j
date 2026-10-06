package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCreateFlags2KHR.html"><code>VkImageCreateFlags2KHR</code></a>
public final class VkImageCreateFlags2KHR {
    public static final long _2D_ARRAY_COMPATIBLE = 0x20L;
    public static final long _2D_VIEW_COMPATIBLE_EXT = 0x20000L;
    public static final long ALIAS = 0x400L;
    public static final long ALIAS_SINGLE_LAYER_DESCRIPTOR = 0x400000L;
    public static final long BLOCK_TEXEL_VIEW_COMPATIBLE = 0x80L;
    public static final long CORNER_SAMPLED_NV = 0x2000L;
    public static final long CUBE_COMPATIBLE = 0x10L;
    public static final long DESCRIPTOR_BUFFER_CAPTURE_REPLAY_EXT = 0x10000L;
    public static final long DISJOINT = 0x200L;
    public static final long EXTENDED_USAGE = 0x100L;
    public static final long FRAGMENT_DENSITY_MAP_OFFSET_EXT = 0x8000L;
    public static final long MULTISAMPLED_RENDER_TO_SINGLE_SAMPLED_EXT = 0x40000L;
    public static final long MUTABLE_FORMAT = 0x8L;
    public static final long PROTECTED = 0x800L;
    public static final long SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_EXT = 0x1000L;
    public static final long SPARSE_ALIASED = 0x4L;
    public static final long SPARSE_BINDING = 0x1L;
    public static final long SPARSE_RESIDENCY = 0x2L;
    public static final long SPLIT_INSTANCE_BIND_REGIONS = 0x40L;
    public static final long SUBSAMPLED_EXT = 0x4000L;
    public static final long VIDEO_PROFILE_INDEPENDENT = 0x100000L;

    public static String explain(@Bitmask(VkImageCreateFlags2KHR.class) long flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & _2D_ARRAY_COMPATIBLE) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_2D_ARRAY_COMPATIBLE_BIT_KHR");
        }
        if ((flags & _2D_VIEW_COMPATIBLE_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_2D_VIEW_COMPATIBLE_BIT_EXT");
        }
        if ((flags & ALIAS) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_ALIAS_BIT_KHR");
        }
        if ((flags & ALIAS_SINGLE_LAYER_DESCRIPTOR) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_ALIAS_SINGLE_LAYER_DESCRIPTOR_BIT_KHR");
        }
        if ((flags & BLOCK_TEXEL_VIEW_COMPATIBLE) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_BLOCK_TEXEL_VIEW_COMPATIBLE_BIT_KHR");
        }
        if ((flags & CORNER_SAMPLED_NV) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_CORNER_SAMPLED_BIT_NV");
        }
        if ((flags & CUBE_COMPATIBLE) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_CUBE_COMPATIBLE_BIT_KHR");
        }
        if ((flags & DESCRIPTOR_BUFFER_CAPTURE_REPLAY_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_DESCRIPTOR_BUFFER_CAPTURE_REPLAY_BIT_EXT");
        }
        if ((flags & DISJOINT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_DISJOINT_BIT_KHR");
        }
        if ((flags & EXTENDED_USAGE) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_EXTENDED_USAGE_BIT_KHR");
        }
        if ((flags & FRAGMENT_DENSITY_MAP_OFFSET_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_FRAGMENT_DENSITY_MAP_OFFSET_BIT_EXT");
        }
        if ((flags & MULTISAMPLED_RENDER_TO_SINGLE_SAMPLED_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_MULTISAMPLED_RENDER_TO_SINGLE_SAMPLED_BIT_EXT");
        }
        if ((flags & MUTABLE_FORMAT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_MUTABLE_FORMAT_BIT_KHR");
        }
        if ((flags & PROTECTED) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_PROTECTED_BIT_KHR");
        }
        if ((flags & SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT");
        }
        if ((flags & SPARSE_ALIASED) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_SPARSE_ALIASED_BIT_KHR");
        }
        if ((flags & SPARSE_BINDING) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_SPARSE_BINDING_BIT_KHR");
        }
        if ((flags & SPARSE_RESIDENCY) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_SPARSE_RESIDENCY_BIT_KHR");
        }
        if ((flags & SPLIT_INSTANCE_BIND_REGIONS) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_SPLIT_INSTANCE_BIND_REGIONS_BIT_KHR");
        }
        if ((flags & SUBSAMPLED_EXT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_SUBSAMPLED_BIT_EXT");
        }
        if ((flags & VIDEO_PROFILE_INDEPENDENT) != 0) {
            detectedFlagBits.add("VK_IMAGE_CREATE_2_VIDEO_PROFILE_INDEPENDENT_BIT_KHR");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Long.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageCreateFlags2KHR() {}
}
