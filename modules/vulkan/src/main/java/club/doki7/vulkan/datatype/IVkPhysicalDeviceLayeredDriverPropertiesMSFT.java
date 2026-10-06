package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceLayeredDriverPropertiesMSFT} and {@link VkPhysicalDeviceLayeredDriverPropertiesMSFT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceLayeredDriverPropertiesMSFT
    extends IPointer
    permits VkPhysicalDeviceLayeredDriverPropertiesMSFT, VkPhysicalDeviceLayeredDriverPropertiesMSFT.Ptr
{}
