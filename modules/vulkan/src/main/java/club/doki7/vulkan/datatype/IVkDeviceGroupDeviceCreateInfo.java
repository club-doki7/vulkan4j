package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceGroupDeviceCreateInfo} and {@link VkDeviceGroupDeviceCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceGroupDeviceCreateInfo
    extends IPointer
    permits VkDeviceGroupDeviceCreateInfo, VkDeviceGroupDeviceCreateInfo.Ptr
{}
