package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMultiviewProperties} and {@link VkPhysicalDeviceMultiviewProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMultiviewProperties
    extends IPointer
    permits VkPhysicalDeviceMultiviewProperties, VkPhysicalDeviceMultiviewProperties.Ptr
{}
