package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrawIndirectCount2InfoKHR} and {@link VkDrawIndirectCount2InfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrawIndirectCount2InfoKHR
    extends IPointer
    permits VkDrawIndirectCount2InfoKHR, VkDrawIndirectCount2InfoKHR.Ptr
{}
