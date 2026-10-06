package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGraphicsPipelineShaderGroupsCreateInfoNV} and {@link VkGraphicsPipelineShaderGroupsCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGraphicsPipelineShaderGroupsCreateInfoNV
    extends IPointer
    permits VkGraphicsPipelineShaderGroupsCreateInfoNV, VkGraphicsPipelineShaderGroupsCreateInfoNV.Ptr
{}
