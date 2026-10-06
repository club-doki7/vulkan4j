package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMutableDescriptorTypeFeaturesEXT} and {@link VkPhysicalDeviceMutableDescriptorTypeFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMutableDescriptorTypeFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceMutableDescriptorTypeFeaturesEXT, VkPhysicalDeviceMutableDescriptorTypeFeaturesEXT.Ptr
{}
