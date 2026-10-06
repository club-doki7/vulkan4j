package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkHostImageLayoutTransitionInfo} and {@link VkHostImageLayoutTransitionInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkHostImageLayoutTransitionInfo
    extends IPointer
    permits VkHostImageLayoutTransitionInfo, VkHostImageLayoutTransitionInfo.Ptr
{}
