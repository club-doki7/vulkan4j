package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFormatProperties4KHR} and {@link VkFormatProperties4KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFormatProperties4KHR
    extends IPointer
    permits VkFormatProperties4KHR, VkFormatProperties4KHR.Ptr
{}
