package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineColorBlendAdvancedStateCreateInfoEXT} and {@link VkPipelineColorBlendAdvancedStateCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineColorBlendAdvancedStateCreateInfoEXT
    extends IPointer
    permits VkPipelineColorBlendAdvancedStateCreateInfoEXT, VkPipelineColorBlendAdvancedStateCreateInfoEXT.Ptr
{}
