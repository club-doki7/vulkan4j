package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoCodingControlInfoKHR} and {@link VkVideoCodingControlInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoCodingControlInfoKHR
    extends IPointer
    permits VkVideoCodingControlInfoKHR, VkVideoCodingControlInfoKHR.Ptr
{}
