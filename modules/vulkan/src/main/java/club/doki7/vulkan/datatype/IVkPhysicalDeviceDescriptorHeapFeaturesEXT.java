package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDescriptorHeapFeaturesEXT} and {@link VkPhysicalDeviceDescriptorHeapFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDescriptorHeapFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceDescriptorHeapFeaturesEXT, VkPhysicalDeviceDescriptorHeapFeaturesEXT.Ptr
{}
