package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineShaderStageModuleIdentifierCreateInfoEXT} and {@link VkPipelineShaderStageModuleIdentifierCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineShaderStageModuleIdentifierCreateInfoEXT
    extends IPointer
    permits VkPipelineShaderStageModuleIdentifierCreateInfoEXT, VkPipelineShaderStageModuleIdentifierCreateInfoEXT.Ptr
{}
