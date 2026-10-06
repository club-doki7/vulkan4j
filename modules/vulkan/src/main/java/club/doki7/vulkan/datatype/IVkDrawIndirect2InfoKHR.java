package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrawIndirect2InfoKHR} and {@link VkDrawIndirect2InfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrawIndirect2InfoKHR
    extends IPointer
    permits VkDrawIndirect2InfoKHR, VkDrawIndirect2InfoKHR.Ptr
{}
