package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubpassEndInfo} and {@link VkSubpassEndInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubpassEndInfo
    extends IPointer
    permits VkSubpassEndInfo, VkSubpassEndInfo.Ptr
{}
