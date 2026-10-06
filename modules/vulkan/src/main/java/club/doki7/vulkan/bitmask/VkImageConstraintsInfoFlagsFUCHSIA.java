package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageConstraintsInfoFlagsFUCHSIA.html"><code>VkImageConstraintsInfoFlagsFUCHSIA</code></a>
public final class VkImageConstraintsInfoFlagsFUCHSIA {
    public static final int CPU_READ_OFTEN = 0x2;
    public static final int CPU_READ_RARELY = 0x1;
    public static final int CPU_WRITE_OFTEN = 0x8;
    public static final int CPU_WRITE_RARELY = 0x4;
    public static final int PROTECTED_OPTIONAL = 0x10;

    public static String explain(@Bitmask(VkImageConstraintsInfoFlagsFUCHSIA.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & CPU_READ_OFTEN) != 0) {
            detectedFlagBits.add("VK_IMAGE_CONSTRAINTS_INFO_CPU_READ_OFTEN_FUCHSIA");
        }
        if ((flags & CPU_READ_RARELY) != 0) {
            detectedFlagBits.add("VK_IMAGE_CONSTRAINTS_INFO_CPU_READ_RARELY_FUCHSIA");
        }
        if ((flags & CPU_WRITE_OFTEN) != 0) {
            detectedFlagBits.add("VK_IMAGE_CONSTRAINTS_INFO_CPU_WRITE_OFTEN_FUCHSIA");
        }
        if ((flags & CPU_WRITE_RARELY) != 0) {
            detectedFlagBits.add("VK_IMAGE_CONSTRAINTS_INFO_CPU_WRITE_RARELY_FUCHSIA");
        }
        if ((flags & PROTECTED_OPTIONAL) != 0) {
            detectedFlagBits.add("VK_IMAGE_CONSTRAINTS_INFO_PROTECTED_OPTIONAL_FUCHSIA");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkImageConstraintsInfoFlagsFUCHSIA() {}
}
