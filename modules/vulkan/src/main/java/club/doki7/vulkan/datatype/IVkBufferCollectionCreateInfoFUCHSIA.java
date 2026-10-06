package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferCollectionCreateInfoFUCHSIA} and {@link VkBufferCollectionCreateInfoFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferCollectionCreateInfoFUCHSIA
    extends IPointer
    permits VkBufferCollectionCreateInfoFUCHSIA, VkBufferCollectionCreateInfoFUCHSIA.Ptr
{}
