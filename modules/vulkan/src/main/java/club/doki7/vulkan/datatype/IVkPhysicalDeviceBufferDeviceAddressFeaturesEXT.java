package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceBufferDeviceAddressFeaturesEXT} and {@link VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceBufferDeviceAddressFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceBufferDeviceAddressFeaturesEXT, VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.Ptr
{}
