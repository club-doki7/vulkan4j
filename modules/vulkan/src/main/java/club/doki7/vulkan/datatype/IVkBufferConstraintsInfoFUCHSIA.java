package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBufferConstraintsInfoFUCHSIA} and {@link VkBufferConstraintsInfoFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBufferConstraintsInfoFUCHSIA
    extends IPointer
    permits VkBufferConstraintsInfoFUCHSIA, VkBufferConstraintsInfoFUCHSIA.Ptr
{}
