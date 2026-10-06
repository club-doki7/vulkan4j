package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageViewCreateInfo} and {@link VkImageViewCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageViewCreateInfo
    extends IPointer
    permits VkImageViewCreateInfo, VkImageViewCreateInfo.Ptr
{}
