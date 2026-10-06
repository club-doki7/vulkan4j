package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubpassBeginInfo} and {@link VkSubpassBeginInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubpassBeginInfo
    extends IPointer
    permits VkSubpassBeginInfo, VkSubpassBeginInfo.Ptr
{}
