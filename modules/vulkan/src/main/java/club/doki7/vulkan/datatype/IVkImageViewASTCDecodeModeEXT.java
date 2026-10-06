package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageViewASTCDecodeModeEXT} and {@link VkImageViewASTCDecodeModeEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageViewASTCDecodeModeEXT
    extends IPointer
    permits VkImageViewASTCDecodeModeEXT, VkImageViewASTCDecodeModeEXT.Ptr
{}
