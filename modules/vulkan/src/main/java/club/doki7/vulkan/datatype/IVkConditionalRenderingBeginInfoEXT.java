package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkConditionalRenderingBeginInfoEXT} and {@link VkConditionalRenderingBeginInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkConditionalRenderingBeginInfoEXT
    extends IPointer
    permits VkConditionalRenderingBeginInfoEXT, VkConditionalRenderingBeginInfoEXT.Ptr
{}
