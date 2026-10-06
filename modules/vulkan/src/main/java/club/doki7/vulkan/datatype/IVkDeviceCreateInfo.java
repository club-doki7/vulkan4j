package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceCreateInfo} and {@link VkDeviceCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceCreateInfo
    extends IPointer
    permits VkDeviceCreateInfo, VkDeviceCreateInfo.Ptr
{}
