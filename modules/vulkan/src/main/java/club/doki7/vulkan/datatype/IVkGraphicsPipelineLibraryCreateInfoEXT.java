package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGraphicsPipelineLibraryCreateInfoEXT} and {@link VkGraphicsPipelineLibraryCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGraphicsPipelineLibraryCreateInfoEXT
    extends IPointer
    permits VkGraphicsPipelineLibraryCreateInfoEXT, VkGraphicsPipelineLibraryCreateInfoEXT.Ptr
{}
