package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceEXT.html"><code>VkDescriptorMappingSourceEXT</code></a>
public final class VkDescriptorMappingSourceEXT {
    public static final int HEAP_WITH_CONSTANT_OFFSET = 0x0;
    public static final int HEAP_WITH_PUSH_INDEX = 0x1;
    public static final int HEAP_WITH_INDIRECT_INDEX = 0x2;
    public static final int HEAP_WITH_INDIRECT_INDEX_ARRAY = 0x3;
    public static final int RESOURCE_HEAP_DATA = 0x4;
    public static final int PUSH_DATA = 0x5;
    public static final int PUSH_ADDRESS = 0x6;
    public static final int INDIRECT_ADDRESS = 0x7;
    public static final int HEAP_WITH_SHADER_RECORD_INDEX = 0x8;
    public static final int SHADER_RECORD_DATA = 0x9;
    public static final int SHADER_RECORD_ADDRESS = 0xa;

    public static String explain(@EnumType(VkDescriptorMappingSourceEXT.class) int value) {
        return switch (value) {
            case VkDescriptorMappingSourceEXT.HEAP_WITH_CONSTANT_OFFSET -> "VK_DESCRIPTOR_MAPPING_SOURCE_HEAP_WITH_CONSTANT_OFFSET_EXT";
            case VkDescriptorMappingSourceEXT.HEAP_WITH_INDIRECT_INDEX_ARRAY -> "VK_DESCRIPTOR_MAPPING_SOURCE_HEAP_WITH_INDIRECT_INDEX_ARRAY_EXT";
            case VkDescriptorMappingSourceEXT.HEAP_WITH_INDIRECT_INDEX -> "VK_DESCRIPTOR_MAPPING_SOURCE_HEAP_WITH_INDIRECT_INDEX_EXT";
            case VkDescriptorMappingSourceEXT.HEAP_WITH_PUSH_INDEX -> "VK_DESCRIPTOR_MAPPING_SOURCE_HEAP_WITH_PUSH_INDEX_EXT";
            case VkDescriptorMappingSourceEXT.HEAP_WITH_SHADER_RECORD_INDEX -> "VK_DESCRIPTOR_MAPPING_SOURCE_HEAP_WITH_SHADER_RECORD_INDEX_EXT";
            case VkDescriptorMappingSourceEXT.INDIRECT_ADDRESS -> "VK_DESCRIPTOR_MAPPING_SOURCE_INDIRECT_ADDRESS_EXT";
            case VkDescriptorMappingSourceEXT.PUSH_ADDRESS -> "VK_DESCRIPTOR_MAPPING_SOURCE_PUSH_ADDRESS_EXT";
            case VkDescriptorMappingSourceEXT.PUSH_DATA -> "VK_DESCRIPTOR_MAPPING_SOURCE_PUSH_DATA_EXT";
            case VkDescriptorMappingSourceEXT.RESOURCE_HEAP_DATA -> "VK_DESCRIPTOR_MAPPING_SOURCE_RESOURCE_HEAP_DATA_EXT";
            case VkDescriptorMappingSourceEXT.SHADER_RECORD_ADDRESS -> "VK_DESCRIPTOR_MAPPING_SOURCE_SHADER_RECORD_ADDRESS_EXT";
            case VkDescriptorMappingSourceEXT.SHADER_RECORD_DATA -> "VK_DESCRIPTOR_MAPPING_SOURCE_SHADER_RECORD_DATA_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDescriptorMappingSourceEXT() {}
}
