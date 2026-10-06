package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFenceGetFdInfoKHR} and {@link VkFenceGetFdInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFenceGetFdInfoKHR
    extends IPointer
    permits VkFenceGetFdInfoKHR, VkFenceGetFdInfoKHR.Ptr
{}
