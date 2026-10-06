package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageFormatConstraintsInfoFUCHSIA} and {@link VkImageFormatConstraintsInfoFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageFormatConstraintsInfoFUCHSIA
    extends IPointer
    permits VkImageFormatConstraintsInfoFUCHSIA, VkImageFormatConstraintsInfoFUCHSIA.Ptr
{}
