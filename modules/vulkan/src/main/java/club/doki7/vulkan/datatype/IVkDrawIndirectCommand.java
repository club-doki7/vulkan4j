package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrawIndirectCommand} and {@link VkDrawIndirectCommand.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrawIndirectCommand
    extends IPointer
    permits VkDrawIndirectCommand, VkDrawIndirectCommand.Ptr
{}
