package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDevicePrivateDataCreateInfo} and {@link VkDevicePrivateDataCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDevicePrivateDataCreateInfo
    extends IPointer
    permits VkDevicePrivateDataCreateInfo, VkDevicePrivateDataCreateInfo.Ptr
{}
