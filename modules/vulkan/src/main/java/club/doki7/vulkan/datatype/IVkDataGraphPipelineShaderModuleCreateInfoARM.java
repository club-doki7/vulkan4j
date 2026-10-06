package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineShaderModuleCreateInfoARM} and {@link VkDataGraphPipelineShaderModuleCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineShaderModuleCreateInfoARM
    extends IPointer
    permits VkDataGraphPipelineShaderModuleCreateInfoARM, VkDataGraphPipelineShaderModuleCreateInfoARM.Ptr
{}
