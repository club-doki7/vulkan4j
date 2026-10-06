package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderObjectFeaturesEXT} and {@link VkPhysicalDeviceShaderObjectFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderObjectFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderObjectFeaturesEXT, VkPhysicalDeviceShaderObjectFeaturesEXT.Ptr
{}
