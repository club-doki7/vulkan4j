package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkOffset2D} and {@link VkOffset2D.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkOffset2D
    extends IPointer
    permits VkOffset2D, VkOffset2D.Ptr
{}
