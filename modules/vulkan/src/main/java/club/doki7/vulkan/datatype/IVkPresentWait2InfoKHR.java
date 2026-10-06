package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentWait2InfoKHR} and {@link VkPresentWait2InfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentWait2InfoKHR
    extends IPointer
    permits VkPresentWait2InfoKHR, VkPresentWait2InfoKHR.Ptr
{}
