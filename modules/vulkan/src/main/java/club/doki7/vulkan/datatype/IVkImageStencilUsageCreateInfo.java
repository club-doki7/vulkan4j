package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageStencilUsageCreateInfo} and {@link VkImageStencilUsageCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageStencilUsageCreateInfo
    extends IPointer
    permits VkImageStencilUsageCreateInfo, VkImageStencilUsageCreateInfo.Ptr
{}
