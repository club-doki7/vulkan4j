package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoInlineQueryInfoKHR} and {@link VkVideoInlineQueryInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoInlineQueryInfoKHR
    extends IPointer
    permits VkVideoInlineQueryInfoKHR, VkVideoInlineQueryInfoKHR.Ptr
{}
