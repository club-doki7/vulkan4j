package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceFaultFeaturesEXT} and {@link VkPhysicalDeviceFaultFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceFaultFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceFaultFeaturesEXT, VkPhysicalDeviceFaultFeaturesEXT.Ptr
{}
