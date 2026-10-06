package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreGetZirconHandleInfoFUCHSIA} and {@link VkSemaphoreGetZirconHandleInfoFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreGetZirconHandleInfoFUCHSIA
    extends IPointer
    permits VkSemaphoreGetZirconHandleInfoFUCHSIA, VkSemaphoreGetZirconHandleInfoFUCHSIA.Ptr
{}
