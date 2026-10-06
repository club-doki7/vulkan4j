package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindVertexBuffer3InfoKHR} and {@link VkBindVertexBuffer3InfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindVertexBuffer3InfoKHR
    extends IPointer
    permits VkBindVertexBuffer3InfoKHR, VkBindVertexBuffer3InfoKHR.Ptr
{}
