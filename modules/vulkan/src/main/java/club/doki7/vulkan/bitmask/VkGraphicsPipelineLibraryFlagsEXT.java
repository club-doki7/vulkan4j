package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGraphicsPipelineLibraryFlagsEXT.html"><code>VkGraphicsPipelineLibraryFlagsEXT</code></a>
public final class VkGraphicsPipelineLibraryFlagsEXT {
    public static final int FRAGMENT_OUTPUT_INTERFACE = 0x8;
    public static final int FRAGMENT_SHADER = 0x4;
    public static final int PRE_RASTERIZATION_SHADERS = 0x2;
    public static final int VERTEX_INPUT_INTERFACE = 0x1;

    public static String explain(@Bitmask(VkGraphicsPipelineLibraryFlagsEXT.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & FRAGMENT_OUTPUT_INTERFACE) != 0) {
            detectedFlagBits.add("VK_GRAPHICS_PIPELINE_LIBRARY_FRAGMENT_OUTPUT_INTERFACE_BIT_EXT");
        }
        if ((flags & FRAGMENT_SHADER) != 0) {
            detectedFlagBits.add("VK_GRAPHICS_PIPELINE_LIBRARY_FRAGMENT_SHADER_BIT_EXT");
        }
        if ((flags & PRE_RASTERIZATION_SHADERS) != 0) {
            detectedFlagBits.add("VK_GRAPHICS_PIPELINE_LIBRARY_PRE_RASTERIZATION_SHADERS_BIT_EXT");
        }
        if ((flags & VERTEX_INPUT_INTERFACE) != 0) {
            detectedFlagBits.add("VK_GRAPHICS_PIPELINE_LIBRARY_VERTEX_INPUT_INTERFACE_BIT_EXT");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkGraphicsPipelineLibraryFlagsEXT() {}
}
