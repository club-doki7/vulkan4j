package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkEventCreateInfo} and {@link VkEventCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkEventCreateInfo
    extends IPointer
    permits VkEventCreateInfo, VkEventCreateInfo.Ptr
{}
