package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMeshShaderFeaturesEXT} and {@link VkPhysicalDeviceMeshShaderFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMeshShaderFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceMeshShaderFeaturesEXT, VkPhysicalDeviceMeshShaderFeaturesEXT.Ptr
{}
