package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryGetZirconHandleInfoFUCHSIA} and {@link VkMemoryGetZirconHandleInfoFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryGetZirconHandleInfoFUCHSIA
    extends IPointer
    permits VkMemoryGetZirconHandleInfoFUCHSIA, VkMemoryGetZirconHandleInfoFUCHSIA.Ptr
{}
