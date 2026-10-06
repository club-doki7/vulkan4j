package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderSubgroupExtendedTypesFeatures} and {@link VkPhysicalDeviceShaderSubgroupExtendedTypesFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderSubgroupExtendedTypesFeatures
    extends IPointer
    permits VkPhysicalDeviceShaderSubgroupExtendedTypesFeatures, VkPhysicalDeviceShaderSubgroupExtendedTypesFeatures.Ptr
{}
