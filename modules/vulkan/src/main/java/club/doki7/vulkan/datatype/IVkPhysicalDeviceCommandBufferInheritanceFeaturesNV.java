package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCommandBufferInheritanceFeaturesNV} and {@link VkPhysicalDeviceCommandBufferInheritanceFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCommandBufferInheritanceFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceCommandBufferInheritanceFeaturesNV, VkPhysicalDeviceCommandBufferInheritanceFeaturesNV.Ptr
{}
