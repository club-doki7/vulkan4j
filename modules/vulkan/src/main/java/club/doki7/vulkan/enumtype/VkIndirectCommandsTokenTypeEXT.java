package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsTokenTypeEXT.html"><code>VkIndirectCommandsTokenTypeEXT</code></a>
public final class VkIndirectCommandsTokenTypeEXT {
    public static final int EXECUTION_SET = 0x0;
    public static final int PUSH_CONSTANT = 0x1;
    public static final int SEQUENCE_INDEX = 0x2;
    public static final int INDEX_BUFFER = 0x3;
    public static final int VERTEX_BUFFER = 0x4;
    public static final int DRAW_INDEXED = 0x5;
    public static final int DRAW = 0x6;
    public static final int DRAW_INDEXED_COUNT = 0x7;
    public static final int DRAW_COUNT = 0x8;
    public static final int DISPATCH = 0x9;
    public static final int PUSH_DATA = 0x3b9cd958;
    public static final int PUSH_DATA_SEQUENCE_INDEX = 0x3b9cd959;
    public static final int DRAW_MESH_TASKS_NV = 0x3b9ddf12;
    public static final int DRAW_MESH_TASKS_COUNT_NV = 0x3b9ddf13;
    public static final int DRAW_MESH_TASKS = 0x3b9fcb40;
    public static final int DRAW_MESH_TASKS_COUNT = 0x3b9fcb41;
    public static final int TRACE_RAYS2 = 0x3ba0add4;

    public static String explain(@EnumType(VkIndirectCommandsTokenTypeEXT.class) int value) {
        return switch (value) {
            case VkIndirectCommandsTokenTypeEXT.DISPATCH -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DISPATCH_EXT";
            case VkIndirectCommandsTokenTypeEXT.DRAW_COUNT -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_COUNT_EXT";
            case VkIndirectCommandsTokenTypeEXT.DRAW -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_EXT";
            case VkIndirectCommandsTokenTypeEXT.DRAW_INDEXED_COUNT -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_INDEXED_COUNT_EXT";
            case VkIndirectCommandsTokenTypeEXT.DRAW_INDEXED -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_INDEXED_EXT";
            case VkIndirectCommandsTokenTypeEXT.DRAW_MESH_TASKS_COUNT -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_MESH_TASKS_COUNT_EXT";
            case VkIndirectCommandsTokenTypeEXT.DRAW_MESH_TASKS_COUNT_NV -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_MESH_TASKS_COUNT_NV_EXT";
            case VkIndirectCommandsTokenTypeEXT.DRAW_MESH_TASKS -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_MESH_TASKS_EXT";
            case VkIndirectCommandsTokenTypeEXT.DRAW_MESH_TASKS_NV -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_DRAW_MESH_TASKS_NV_EXT";
            case VkIndirectCommandsTokenTypeEXT.EXECUTION_SET -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_EXECUTION_SET_EXT";
            case VkIndirectCommandsTokenTypeEXT.INDEX_BUFFER -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_INDEX_BUFFER_EXT";
            case VkIndirectCommandsTokenTypeEXT.PUSH_CONSTANT -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_PUSH_CONSTANT_EXT";
            case VkIndirectCommandsTokenTypeEXT.PUSH_DATA -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_PUSH_DATA_EXT";
            case VkIndirectCommandsTokenTypeEXT.PUSH_DATA_SEQUENCE_INDEX -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_PUSH_DATA_SEQUENCE_INDEX_EXT";
            case VkIndirectCommandsTokenTypeEXT.SEQUENCE_INDEX -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_SEQUENCE_INDEX_EXT";
            case VkIndirectCommandsTokenTypeEXT.TRACE_RAYS2 -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_TRACE_RAYS2_EXT";
            case VkIndirectCommandsTokenTypeEXT.VERTEX_BUFFER -> "VK_INDIRECT_COMMANDS_TOKEN_TYPE_VERTEX_BUFFER_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkIndirectCommandsTokenTypeEXT() {}
}
