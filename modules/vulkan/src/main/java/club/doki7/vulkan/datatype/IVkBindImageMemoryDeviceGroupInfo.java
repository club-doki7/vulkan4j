package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindImageMemoryDeviceGroupInfo} and {@link VkBindImageMemoryDeviceGroupInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindImageMemoryDeviceGroupInfo
    extends IPointer
    permits VkBindImageMemoryDeviceGroupInfo, VkBindImageMemoryDeviceGroupInfo.Ptr
{}
