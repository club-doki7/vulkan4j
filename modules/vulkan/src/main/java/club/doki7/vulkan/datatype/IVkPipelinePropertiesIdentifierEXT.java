package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelinePropertiesIdentifierEXT} and {@link VkPipelinePropertiesIdentifierEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelinePropertiesIdentifierEXT
    extends IPointer
    permits VkPipelinePropertiesIdentifierEXT, VkPipelinePropertiesIdentifierEXT.Ptr
{}
