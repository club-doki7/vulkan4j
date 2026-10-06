package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCommandBufferInheritanceViewportScissorInfoNV} and {@link VkCommandBufferInheritanceViewportScissorInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCommandBufferInheritanceViewportScissorInfoNV
    extends IPointer
    permits VkCommandBufferInheritanceViewportScissorInfoNV, VkCommandBufferInheritanceViewportScissorInfoNV.Ptr
{}
