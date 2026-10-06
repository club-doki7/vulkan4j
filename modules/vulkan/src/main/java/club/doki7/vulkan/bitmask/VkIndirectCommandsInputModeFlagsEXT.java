package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsInputModeFlagsEXT.html"><code>VkIndirectCommandsInputModeFlagsEXT</code></a>
public final class VkIndirectCommandsInputModeFlagsEXT {
    public static final int DXGI_INDEX_BUFFER = 0x2;
    public static final int VULKAN_INDEX_BUFFER = 0x1;

    public static String explain(@Bitmask(VkIndirectCommandsInputModeFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & DXGI_INDEX_BUFFER) != 0) {
            detectedFlagBits.add("VK_INDIRECT_COMMANDS_INPUT_MODE_DXGI_INDEX_BUFFER_EXT");
        }
        if ((flags & VULKAN_INDEX_BUFFER) != 0) {
            detectedFlagBits.add("VK_INDIRECT_COMMANDS_INPUT_MODE_VULKAN_INDEX_BUFFER_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkIndirectCommandsInputModeFlagsEXT() {}
}
