package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkViSurfaceCreateInfoNN} and {@link VkViSurfaceCreateInfoNN.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkViSurfaceCreateInfoNN
    extends IPointer
    permits VkViSurfaceCreateInfoNN, VkViSurfaceCreateInfoNN.Ptr
{}
