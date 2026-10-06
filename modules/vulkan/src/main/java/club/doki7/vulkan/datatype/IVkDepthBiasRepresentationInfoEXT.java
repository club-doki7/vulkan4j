package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDepthBiasRepresentationInfoEXT} and {@link VkDepthBiasRepresentationInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDepthBiasRepresentationInfoEXT
    extends IPointer
    permits VkDepthBiasRepresentationInfoEXT, VkDepthBiasRepresentationInfoEXT.Ptr
{}
