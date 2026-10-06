package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorUpdateTemplateType.html"><code>VkDescriptorUpdateTemplateType</code></a>
public final class VkDescriptorUpdateTemplateType {
    public static final int DESCRIPTOR_SET = 0x0;
    public static final int PUSH_DESCRIPTORS = 0x1;

    public static String explain(@EnumType(VkDescriptorUpdateTemplateType.class) int value) {
        return switch (value) {
            case VkDescriptorUpdateTemplateType.DESCRIPTOR_SET -> "VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_DESCRIPTOR_SET";
            case VkDescriptorUpdateTemplateType.PUSH_DESCRIPTORS -> "VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDescriptorUpdateTemplateType() {}
}
