package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMeshShaderFeaturesNV} and {@link VkPhysicalDeviceMeshShaderFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMeshShaderFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceMeshShaderFeaturesNV, VkPhysicalDeviceMeshShaderFeaturesNV.Ptr
{}
