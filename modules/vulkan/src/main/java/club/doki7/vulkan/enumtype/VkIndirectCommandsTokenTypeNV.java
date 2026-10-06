package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsTokenTypeNV.html"><code>VkIndirectCommandsTokenTypeNV</code></a>
public final class VkIndirectCommandsTokenTypeNV {
    public static final int SHADER_GROUP = 0x0;
    public static final int STATE_FLAGS = 0x1;
    public static final int INDEX_BUFFER = 0x2;
    public static final int VERTEX_BUFFER = 0x3;
    public static final int PUSH_CONSTANT = 0x4;
    public static final int DRAW_INDEXED = 0x5;
    public static final int DRAW = 0x6;
    public static final int DRAW_TASKS = 0x7;
    public static final int PUSH_DATA = 0x3b9cd958;
    public static final int DRAW_MESH_TASKS = 0x3b9fcb40;
    public static final int PIPELINE = 0x3ba151e3;
    public static final int DISPATCH = 0x3ba151e4;

    public static String explain(@EnumType(VkIndirectCommandsTokenTypeNV.class) int value) {
        return switch (value) {
            case VkIndirectCommandsTokenTypeNV.DISPATCH -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DISPATCH_NV";
            case VkIndirectCommandsTokenTypeNV.DRAW_INDEXED -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_INDEXED_NV";
            case VkIndirectCommandsTokenTypeNV.DRAW_MESH_TASKS -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_MESH_TASKS_NV";
            case VkIndirectCommandsTokenTypeNV.DRAW -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_NV";
            case VkIndirectCommandsTokenTypeNV.DRAW_TASKS -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_TASKS_NV";
            case VkIndirectCommandsTokenTypeNV.INDEX_BUFFER -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_INDEX_BUFFER_NV";
            case VkIndirectCommandsTokenTypeNV.PIPELINE -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_PIPELINE_NV";
            case VkIndirectCommandsTokenTypeNV.PUSH_CONSTANT -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_PUSH_CONSTANT_NV";
            case VkIndirectCommandsTokenTypeNV.PUSH_DATA -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_PUSH_DATA_NV";
            case VkIndirectCommandsTokenTypeNV.SHADER_GROUP -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_SHADER_GROUP_NV";
            case VkIndirectCommandsTokenTypeNV.STATE_FLAGS -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_STATE_FLAGS_NV";
            case VkIndirectCommandsTokenTypeNV.VERTEX_BUFFER -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_VERTEX_BUFFER_NV";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkIndirectCommandsTokenTypeNV() {}
}
