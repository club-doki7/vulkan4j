package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFormatProperties3} and {@link VkFormatProperties3.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFormatProperties3
    extends IPointer
    permits VkFormatProperties3, VkFormatProperties3.Ptr
{}
