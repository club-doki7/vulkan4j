package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMemoryBufferCollectionFUCHSIA} and {@link VkImportMemoryBufferCollectionFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMemoryBufferCollectionFUCHSIA
    extends IPointer
    permits VkImportMemoryBufferCollectionFUCHSIA, VkImportMemoryBufferCollectionFUCHSIA.Ptr
{}
