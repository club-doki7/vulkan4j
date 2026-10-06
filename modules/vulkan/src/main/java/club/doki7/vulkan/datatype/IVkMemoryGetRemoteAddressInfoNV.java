package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryGetRemoteAddressInfoNV} and {@link VkMemoryGetRemoteAddressInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryGetRemoteAddressInfoNV
    extends IPointer
    permits VkMemoryGetRemoteAddressInfoNV, VkMemoryGetRemoteAddressInfoNV.Ptr
{}
