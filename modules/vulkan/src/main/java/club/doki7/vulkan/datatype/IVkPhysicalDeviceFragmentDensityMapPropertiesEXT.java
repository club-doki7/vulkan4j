package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceFragmentDensityMapPropertiesEXT} and {@link VkPhysicalDeviceFragmentDensityMapPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceFragmentDensityMapPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceFragmentDensityMapPropertiesEXT, VkPhysicalDeviceFragmentDensityMapPropertiesEXT.Ptr
{}
