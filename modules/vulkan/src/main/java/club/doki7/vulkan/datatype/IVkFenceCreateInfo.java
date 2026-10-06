package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFenceCreateInfo} and {@link VkFenceCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFenceCreateInfo
    extends IPointer
    permits VkFenceCreateInfo, VkFenceCreateInfo.Ptr
{}
