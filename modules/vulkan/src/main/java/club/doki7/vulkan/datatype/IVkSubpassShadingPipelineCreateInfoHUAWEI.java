package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubpassShadingPipelineCreateInfoHUAWEI} and {@link VkSubpassShadingPipelineCreateInfoHUAWEI.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubpassShadingPipelineCreateInfoHUAWEI
    extends IPointer
    permits VkSubpassShadingPipelineCreateInfoHUAWEI, VkSubpassShadingPipelineCreateInfoHUAWEI.Ptr
{}
