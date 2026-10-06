package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubmitInfo2} and {@link VkSubmitInfo2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubmitInfo2
    extends IPointer
    permits VkSubmitInfo2, VkSubmitInfo2.Ptr
{}
