package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreSignalInfo} and {@link VkSemaphoreSignalInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreSignalInfo
    extends IPointer
    permits VkSemaphoreSignalInfo, VkSemaphoreSignalInfo.Ptr
{}
