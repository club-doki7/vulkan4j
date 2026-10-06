package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryZirconHandlePropertiesFUCHSIA} and {@link VkMemoryZirconHandlePropertiesFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryZirconHandlePropertiesFUCHSIA
    extends IPointer
    permits VkMemoryZirconHandlePropertiesFUCHSIA, VkMemoryZirconHandlePropertiesFUCHSIA.Ptr
{}
