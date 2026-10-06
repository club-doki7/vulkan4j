package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubgroupFeatureFlags.html"><code>VkSubgroupFeatureFlags</code></a>
public final class VkSubgroupFeatureFlags {
    public static final int ARITHMETIC = 0x4;
    public static final int BALLOT = 0x8;
    public static final int BASIC = 0x1;
    public static final int CLUSTERED = 0x40;
    public static final int PARTITIONED_EXT = 0x100;
    public static final int QUAD = 0x80;
    public static final int ROTATE = 0x200;
    public static final int ROTATE_CLUSTERED = 0x400;
    public static final int SHUFFLE = 0x10;
    public static final int SHUFFLE_RELATIVE = 0x20;
    public static final int VOTE = 0x2;

    public static String explain(@Bitmask(VkSubgroupFeatureFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ARITHMETIC) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_ARITHMETIC_BIT");
        }
        if ((flags & BALLOT) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_BALLOT_BIT");
        }
        if ((flags & BASIC) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_BASIC_BIT");
        }
        if ((flags & CLUSTERED) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_CLUSTERED_BIT");
        }
        if ((flags & PARTITIONED_EXT) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_PARTITIONED_BIT_EXT");
        }
        if ((flags & QUAD) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_QUAD_BIT");
        }
        if ((flags & ROTATE) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_ROTATE_BIT");
        }
        if ((flags & ROTATE_CLUSTERED) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_ROTATE_CLUSTERED_BIT");
        }
        if ((flags & SHUFFLE) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_SHUFFLE_BIT");
        }
        if ((flags & SHUFFLE_RELATIVE) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_SHUFFLE_RELATIVE_BIT");
        }
        if ((flags & VOTE) != 0) {
            detectedFlagBits.add("VK_SUBGROUP_FEATURE_VOTE_BIT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkSubgroupFeatureFlags() {}
}
