package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceAddressBindingFlagsEXT.html"><code>VkDeviceAddressBindingFlagsEXT</code></a>
public final class VkDeviceAddressBindingFlagsEXT {
    public static final int INTERNAL_OBJECT = 0x1;

    public static String explain(@Bitmask(VkDeviceAddressBindingFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & INTERNAL_OBJECT) != 0) {
            detectedFlagBits.add("VK_DEVICE_ADDRESS_BINDING_INTERNAL_OBJECT_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceAddressBindingFlagsEXT() {}
}
