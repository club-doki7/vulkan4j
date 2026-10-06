package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRectLayerKHR} and {@link VkRectLayerKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRectLayerKHR
    extends IPointer
    permits VkRectLayerKHR, VkRectLayerKHR.Ptr
{}
