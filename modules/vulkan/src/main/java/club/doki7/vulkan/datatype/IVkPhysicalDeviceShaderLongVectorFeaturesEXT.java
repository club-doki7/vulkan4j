package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderLongVectorFeaturesEXT} and {@link VkPhysicalDeviceShaderLongVectorFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderLongVectorFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderLongVectorFeaturesEXT, VkPhysicalDeviceShaderLongVectorFeaturesEXT.Ptr
{}
