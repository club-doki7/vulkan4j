package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceFormatPackFeaturesARM} and {@link VkPhysicalDeviceFormatPackFeaturesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceFormatPackFeaturesARM
    extends IPointer
    permits VkPhysicalDeviceFormatPackFeaturesARM, VkPhysicalDeviceFormatPackFeaturesARM.Ptr
{}
