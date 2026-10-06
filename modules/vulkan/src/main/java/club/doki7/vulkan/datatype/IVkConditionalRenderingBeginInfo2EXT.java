package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkConditionalRenderingBeginInfo2EXT} and {@link VkConditionalRenderingBeginInfo2EXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkConditionalRenderingBeginInfo2EXT
    extends IPointer
    permits VkConditionalRenderingBeginInfo2EXT, VkConditionalRenderingBeginInfo2EXT.Ptr
{}
