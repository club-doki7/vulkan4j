package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceBufferDeviceAddressFeatures} and {@link VkPhysicalDeviceBufferDeviceAddressFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceBufferDeviceAddressFeatures
    extends IPointer
    permits VkPhysicalDeviceBufferDeviceAddressFeatures, VkPhysicalDeviceBufferDeviceAddressFeatures.Ptr
{}
