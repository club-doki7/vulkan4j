package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCommandPoolCreateInfo} and {@link VkCommandPoolCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCommandPoolCreateInfo
    extends IPointer
    permits VkCommandPoolCreateInfo, VkCommandPoolCreateInfo.Ptr
{}
