package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDispatchIndirectCommand} and {@link VkDispatchIndirectCommand.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDispatchIndirectCommand
    extends IPointer
    permits VkDispatchIndirectCommand, VkDispatchIndirectCommand.Ptr
{}
