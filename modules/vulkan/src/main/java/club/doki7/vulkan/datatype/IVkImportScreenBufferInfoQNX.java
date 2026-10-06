package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportScreenBufferInfoQNX} and {@link VkImportScreenBufferInfoQNX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportScreenBufferInfoQNX
    extends IPointer
    permits VkImportScreenBufferInfoQNX, VkImportScreenBufferInfoQNX.Ptr
{}
