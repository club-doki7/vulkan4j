package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTraceRaysIndirectCommandKHR} and {@link VkTraceRaysIndirectCommandKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTraceRaysIndirectCommandKHR
    extends IPointer
    permits VkTraceRaysIndirectCommandKHR, VkTraceRaysIndirectCommandKHR.Ptr
{}
