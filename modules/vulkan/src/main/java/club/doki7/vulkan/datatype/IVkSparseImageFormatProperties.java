package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSparseImageFormatProperties} and {@link VkSparseImageFormatProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSparseImageFormatProperties
    extends IPointer
    permits VkSparseImageFormatProperties, VkSparseImageFormatProperties.Ptr
{}
