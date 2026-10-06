package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceFrameBoundaryFeaturesEXT} and {@link VkPhysicalDeviceFrameBoundaryFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceFrameBoundaryFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceFrameBoundaryFeaturesEXT, VkPhysicalDeviceFrameBoundaryFeaturesEXT.Ptr
{}
