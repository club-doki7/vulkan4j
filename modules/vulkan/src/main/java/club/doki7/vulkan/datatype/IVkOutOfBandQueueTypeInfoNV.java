package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkOutOfBandQueueTypeInfoNV} and {@link VkOutOfBandQueueTypeInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkOutOfBandQueueTypeInfoNV
    extends IPointer
    permits VkOutOfBandQueueTypeInfoNV, VkOutOfBandQueueTypeInfoNV.Ptr
{}
