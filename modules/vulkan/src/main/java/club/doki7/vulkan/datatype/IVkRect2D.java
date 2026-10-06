package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRect2D} and {@link VkRect2D.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRect2D
    extends IPointer
    permits VkRect2D, VkRect2D.Ptr
{}
