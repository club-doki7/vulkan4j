package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorType.html"><code>VkDescriptorType</code></a>
public final class VkDescriptorType {
    public static final int SAMPLER = 0x0;
    public static final int COMBINED_IMAGE_SAMPLER = 0x1;
    public static final int SAMPLED_IMAGE = 0x2;
    public static final int STORAGE_IMAGE = 0x3;
    public static final int UNIFORM_TEXEL_BUFFER = 0x4;
    public static final int STORAGE_TEXEL_BUFFER = 0x5;
    public static final int UNIFORM_BUFFER = 0x6;
    public static final int STORAGE_BUFFER = 0x7;
    public static final int UNIFORM_BUFFER_DYNAMIC = 0x8;
    public static final int STORAGE_BUFFER_DYNAMIC = 0x9;
    public static final int INPUT_ATTACHMENT = 0xa;
    public static final int INLINE_UNIFORM_BLOCK = 0x3b9ce510;
    public static final int ACCELERATION_STRUCTURE_KHR = 0x3b9d13f0;
    public static final int ACCELERATION_STRUCTURE_NV = 0x3b9d4e88;
    public static final int SAMPLE_WEIGHT_IMAGE_QCOM = 0x3ba180c0;
    public static final int BLOCK_MATCH_IMAGE_QCOM = 0x3ba180c1;
    public static final int TENSOR_ARM = 0x3ba1cee0;
    public static final int MUTABLE_EXT = 0x3ba02518;
    public static final int PARTITIONED_ACCELERATION_STRUCTURE_NV = 0x3ba37c90;

    public static String explain(@EnumType(VkDescriptorType.class) int value) {
        return switch (value) {
            case VkDescriptorType.ACCELERATION_STRUCTURE_KHR -> "VK_DESCRIPTOR_TYPE_ACCELERATION_STRUCTURE_KHR";
            case VkDescriptorType.ACCELERATION_STRUCTURE_NV -> "VK_DESCRIPTOR_TYPE_ACCELERATION_STRUCTURE_NV";
            case VkDescriptorType.BLOCK_MATCH_IMAGE_QCOM -> "VK_DESCRIPTOR_TYPE_BLOCK_MATCH_IMAGE_QCOM";
            case VkDescriptorType.COMBINED_IMAGE_SAMPLER -> "VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER";
            case VkDescriptorType.INLINE_UNIFORM_BLOCK -> "VK_DESCRIPTOR_TYPE_INLINE_UNIFORM_BLOCK";
            case VkDescriptorType.INPUT_ATTACHMENT -> "VK_DESCRIPTOR_TYPE_INPUT_ATTACHMENT";
            case VkDescriptorType.MUTABLE_EXT -> "VK_DESCRIPTOR_TYPE_MUTABLE_EXT";
            case VkDescriptorType.PARTITIONED_ACCELERATION_STRUCTURE_NV -> "VK_DESCRIPTOR_TYPE_PARTITIONED_ACCELERATION_STRUCTURE_NV";
            case VkDescriptorType.SAMPLED_IMAGE -> "VK_DESCRIPTOR_TYPE_SAMPLED_IMAGE";
            case VkDescriptorType.SAMPLER -> "VK_DESCRIPTOR_TYPE_SAMPLER";
            case VkDescriptorType.SAMPLE_WEIGHT_IMAGE_QCOM -> "VK_DESCRIPTOR_TYPE_SAMPLE_WEIGHT_IMAGE_QCOM";
            case VkDescriptorType.STORAGE_BUFFER -> "VK_DESCRIPTOR_TYPE_STORAGE_BUFFER";
            case VkDescriptorType.STORAGE_BUFFER_DYNAMIC -> "VK_DESCRIPTOR_TYPE_STORAGE_BUFFER_DYNAMIC";
            case VkDescriptorType.STORAGE_IMAGE -> "VK_DESCRIPTOR_TYPE_STORAGE_IMAGE";
            case VkDescriptorType.STORAGE_TEXEL_BUFFER -> "VK_DESCRIPTOR_TYPE_STORAGE_TEXEL_BUFFER";
            case VkDescriptorType.TENSOR_ARM -> "VK_DESCRIPTOR_TYPE_TENSOR_ARM";
            case VkDescriptorType.UNIFORM_BUFFER -> "VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER";
            case VkDescriptorType.UNIFORM_BUFFER_DYNAMIC -> "VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER_DYNAMIC";
            case VkDescriptorType.UNIFORM_TEXEL_BUFFER -> "VK_DESCRIPTOR_TYPE_UNIFORM_TEXEL_BUFFER";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDescriptorType() {}
}
