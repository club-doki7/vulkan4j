package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDispatchIndirect2InfoKHR} and {@link VkDispatchIndirect2InfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDispatchIndirect2InfoKHR
    extends IPointer
    permits VkDispatchIndirect2InfoKHR, VkDispatchIndirect2InfoKHR.Ptr
{}
