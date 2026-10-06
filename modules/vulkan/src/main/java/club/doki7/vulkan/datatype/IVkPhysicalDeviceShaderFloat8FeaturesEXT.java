package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderFloat8FeaturesEXT} and {@link VkPhysicalDeviceShaderFloat8FeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderFloat8FeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderFloat8FeaturesEXT, VkPhysicalDeviceShaderFloat8FeaturesEXT.Ptr
{}
