package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSparseImageFormatProperties2} and {@link VkSparseImageFormatProperties2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSparseImageFormatProperties2
    extends IPointer
    permits VkSparseImageFormatProperties2, VkSparseImageFormatProperties2.Ptr
{}
