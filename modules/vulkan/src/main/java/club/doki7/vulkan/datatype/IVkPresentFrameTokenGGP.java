package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentFrameTokenGGP} and {@link VkPresentFrameTokenGGP.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentFrameTokenGGP
    extends IPointer
    permits VkPresentFrameTokenGGP, VkPresentFrameTokenGGP.Ptr
{}
