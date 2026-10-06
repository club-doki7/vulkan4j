package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePrivateDataFeatures} and {@link VkPhysicalDevicePrivateDataFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePrivateDataFeatures
    extends IPointer
    permits VkPhysicalDevicePrivateDataFeatures, VkPhysicalDevicePrivateDataFeatures.Ptr
{}
