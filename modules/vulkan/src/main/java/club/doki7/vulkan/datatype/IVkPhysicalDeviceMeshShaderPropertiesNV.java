package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMeshShaderPropertiesNV} and {@link VkPhysicalDeviceMeshShaderPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMeshShaderPropertiesNV
    extends IPointer
    permits VkPhysicalDeviceMeshShaderPropertiesNV, VkPhysicalDeviceMeshShaderPropertiesNV.Ptr
{}
