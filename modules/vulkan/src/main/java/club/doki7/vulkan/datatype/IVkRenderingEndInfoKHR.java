package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderingEndInfoKHR} and {@link VkRenderingEndInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderingEndInfoKHR
    extends IPointer
    permits VkRenderingEndInfoKHR, VkRenderingEndInfoKHR.Ptr
{}
