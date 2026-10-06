package club.doki7.vulkan.enumtype;

import club.doki7.ffm.annotation.*;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceAddressBindingTypeEXT.html"><code>VkDeviceAddressBindingTypeEXT</code></a>
public final class VkDeviceAddressBindingTypeEXT {
    public static final int BIND = 0x0;
    public static final int UNBIND = 0x1;

    public static String explain(@EnumType(VkDeviceAddressBindingTypeEXT.class) int value) {
        return switch (value) {
            case VkDeviceAddressBindingTypeEXT.BIND -> "VK_DEVICE_ADDRESS_BINDING_TYPE_BIND_EXT";
            case VkDeviceAddressBindingTypeEXT.UNBIND -> "VK_DEVICE_ADDRESS_BINDING_TYPE_UNBIND_EXT";
            default -> "UNKNOWN(" + value + ")";
        };
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkDeviceAddressBindingTypeEXT() {}
}
