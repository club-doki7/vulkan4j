package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceQueueCreateInfo} and {@link VkDeviceQueueCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceQueueCreateInfo
    extends IPointer
    permits VkDeviceQueueCreateInfo, VkDeviceQueueCreateInfo.Ptr
{}
