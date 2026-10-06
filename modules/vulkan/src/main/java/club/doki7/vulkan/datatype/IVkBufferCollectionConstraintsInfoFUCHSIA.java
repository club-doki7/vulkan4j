package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferCollectionConstraintsInfoFUCHSIA} and {@link VkBufferCollectionConstraintsInfoFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferCollectionConstraintsInfoFUCHSIA
    extends IPointer
    permits VkBufferCollectionConstraintsInfoFUCHSIA, VkBufferCollectionConstraintsInfoFUCHSIA.Ptr
{}
