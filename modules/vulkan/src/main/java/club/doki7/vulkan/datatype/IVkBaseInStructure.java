package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBaseInStructure} and {@link VkBaseInStructure.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBaseInStructure
    extends IPointer
    permits VkBaseInStructure, VkBaseInStructure.Ptr
{}
