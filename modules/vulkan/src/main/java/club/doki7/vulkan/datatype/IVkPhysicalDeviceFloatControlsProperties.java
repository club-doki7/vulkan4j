package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceFloatControlsProperties} and {@link VkPhysicalDeviceFloatControlsProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceFloatControlsProperties
    extends IPointer
    permits VkPhysicalDeviceFloatControlsProperties, VkPhysicalDeviceFloatControlsProperties.Ptr
{}
