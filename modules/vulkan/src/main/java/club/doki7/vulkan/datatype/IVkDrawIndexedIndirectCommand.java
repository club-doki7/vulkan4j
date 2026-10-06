package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrawIndexedIndirectCommand} and {@link VkDrawIndexedIndirectCommand.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrawIndexedIndirectCommand
    extends IPointer
    permits VkDrawIndexedIndirectCommand, VkDrawIndexedIndirectCommand.Ptr
{}
