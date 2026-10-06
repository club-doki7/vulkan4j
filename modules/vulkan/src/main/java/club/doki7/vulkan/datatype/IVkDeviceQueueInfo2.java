package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceQueueInfo2} and {@link VkDeviceQueueInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceQueueInfo2
    extends IPointer
    permits VkDeviceQueueInfo2, VkDeviceQueueInfo2.Ptr
{}
