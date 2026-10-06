package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCompressionFixedRateFlagsEXT.html"><code>VkImageCompressionFixedRateFlagsEXT</code></a>
public final class VkImageCompressionFixedRateFlagsEXT {
    public static final int _10BPC = 0x200;
    public static final int _11BPC = 0x400;
    public static final int _12BPC = 0x800;
    public static final int _13BPC = 0x1000;
    public static final int _14BPC = 0x2000;
    public static final int _15BPC = 0x4000;
    public static final int _16BPC = 0x8000;
    public static final int _17BPC = 0x10000;
    public static final int _18BPC = 0x20000;
    public static final int _19BPC = 0x40000;
    public static final int _1BPC = 0x1;
    public static final int _20BPC = 0x80000;
    public static final int _21BPC = 0x100000;
    public static final int _22BPC = 0x200000;
    public static final int _23BPC = 0x400000;
    public static final int _24BPC = 0x800000;
    public static final int _2BPC = 0x2;
    public static final int _3BPC = 0x4;
    public static final int _4BPC = 0x8;
    public static final int _5BPC = 0x10;
    public static final int _6BPC = 0x20;
    public static final int _7BPC = 0x40;
    public static final int _8BPC = 0x80;
    public static final int _9BPC = 0x100;
    public static final int NONE = 0x0;

    public static String explain(@Bitmask(VkImageCompressionFixedRateFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & _10BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_10BPC_BIT_EXT");
        }
        if ((flags & _11BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_11BPC_BIT_EXT");
        }
        if ((flags & _12BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_12BPC_BIT_EXT");
        }
        if ((flags & _13BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_13BPC_BIT_EXT");
        }
        if ((flags & _14BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_14BPC_BIT_EXT");
        }
        if ((flags & _15BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_15BPC_BIT_EXT");
        }
        if ((flags & _16BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_16BPC_BIT_EXT");
        }
        if ((flags & _17BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_17BPC_BIT_EXT");
        }
        if ((flags & _18BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_18BPC_BIT_EXT");
        }
        if ((flags & _19BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_19BPC_BIT_EXT");
        }
        if ((flags & _1BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_1BPC_BIT_EXT");
        }
        if ((flags & _20BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_20BPC_BIT_EXT");
        }
        if ((flags & _21BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_21BPC_BIT_EXT");
        }
        if ((flags & _22BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_22BPC_BIT_EXT");
        }
        if ((flags & _23BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_23BPC_BIT_EXT");
        }
        if ((flags & _24BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_24BPC_BIT_EXT");
        }
        if ((flags & _2BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_2BPC_BIT_EXT");
        }
        if ((flags & _3BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_3BPC_BIT_EXT");
        }
        if ((flags & _4BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_4BPC_BIT_EXT");
        }
        if ((flags & _5BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_5BPC_BIT_EXT");
        }
        if ((flags & _6BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_6BPC_BIT_EXT");
        }
        if ((flags & _7BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_7BPC_BIT_EXT");
        }
        if ((flags & _8BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_8BPC_BIT_EXT");
        }
        if ((flags & _9BPC) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_9BPC_BIT_EXT");
        }
        if ((flags & NONE) != 0) {
            detectedFlagBits.add("VK_IMAGE_COMPRESSION_FIXED_RATE_NONE_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageCompressionFixedRateFlagsEXT() {}
}
