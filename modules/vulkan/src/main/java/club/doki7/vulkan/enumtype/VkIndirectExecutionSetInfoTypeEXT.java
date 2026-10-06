package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectExecutionSetInfoTypeEXT.html"><code>VkIndirectExecutionSetInfoTypeEXT</code></a>
public final class VkIndirectExecutionSetInfoTypeEXT {
    public static final int PIPELINES = 0x0;
    public static final int SHADER_OBJECTS = 0x1;

    public static String explain(@EnumType(VkIndirectExecutionSetInfoTypeEXT.class) int value) {
        return switch (value) {
            case VkIndirectExecutionSetInfoTypeEXT.PIPELINES -> "VK_INDIRECT_EXECUTION_SET_INFO_TYPE_PIPELINES_EXT";
            case VkIndirectExecutionSetInfoTypeEXT.SHADER_OBJECTS -> "VK_INDIRECT_EXECUTION_SET_INFO_TYPE_SHADER_OBJECTS_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkIndirectExecutionSetInfoTypeEXT() {}
}
