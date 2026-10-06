package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineRasterizationStateStreamCreateInfoEXT} and {@link VkPipelineRasterizationStateStreamCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineRasterizationStateStreamCreateInfoEXT
    extends IPointer
    permits VkPipelineRasterizationStateStreamCreateInfoEXT, VkPipelineRasterizationStateStreamCreateInfoEXT.Ptr
{}
