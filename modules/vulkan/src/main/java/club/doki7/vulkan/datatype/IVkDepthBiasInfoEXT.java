package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDepthBiasInfoEXT} and {@link VkDepthBiasInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDepthBiasInfoEXT
    extends IPointer
    permits VkDepthBiasInfoEXT, VkDepthBiasInfoEXT.Ptr
{}
