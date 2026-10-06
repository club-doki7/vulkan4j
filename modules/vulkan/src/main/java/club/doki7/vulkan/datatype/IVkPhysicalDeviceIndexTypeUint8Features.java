package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceIndexTypeUint8Features} and {@link VkPhysicalDeviceIndexTypeUint8Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceIndexTypeUint8Features
    extends IPointer
    permits VkPhysicalDeviceIndexTypeUint8Features, VkPhysicalDeviceIndexTypeUint8Features.Ptr
{}
