package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageCreateInfo} and {@link VkImageCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageCreateInfo
    extends IPointer
    permits VkImageCreateInfo, VkImageCreateInfo.Ptr
{}
