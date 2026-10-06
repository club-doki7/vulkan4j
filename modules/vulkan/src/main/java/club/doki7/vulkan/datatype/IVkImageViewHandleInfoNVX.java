package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageViewHandleInfoNVX} and {@link VkImageViewHandleInfoNVX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageViewHandleInfoNVX
    extends IPointer
    permits VkImageViewHandleInfoNVX, VkImageViewHandleInfoNVX.Ptr
{}
