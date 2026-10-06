package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoReferenceSlotInfoKHR} and {@link VkVideoReferenceSlotInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoReferenceSlotInfoKHR
    extends IPointer
    permits VkVideoReferenceSlotInfoKHR, VkVideoReferenceSlotInfoKHR.Ptr
{}
