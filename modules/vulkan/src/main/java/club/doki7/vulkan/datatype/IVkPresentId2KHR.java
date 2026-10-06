package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentId2KHR} and {@link VkPresentId2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentId2KHR
    extends IPointer
    permits VkPresentId2KHR, VkPresentId2KHR.Ptr
{}
