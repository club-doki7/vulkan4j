package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceConservativeRasterizationPropertiesEXT} and {@link VkPhysicalDeviceConservativeRasterizationPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceConservativeRasterizationPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceConservativeRasterizationPropertiesEXT, VkPhysicalDeviceConservativeRasterizationPropertiesEXT.Ptr
{}
