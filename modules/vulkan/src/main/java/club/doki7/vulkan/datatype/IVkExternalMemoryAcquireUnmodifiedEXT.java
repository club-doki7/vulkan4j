package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalMemoryAcquireUnmodifiedEXT} and {@link VkExternalMemoryAcquireUnmodifiedEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalMemoryAcquireUnmodifiedEXT
    extends IPointer
    permits VkExternalMemoryAcquireUnmodifiedEXT, VkExternalMemoryAcquireUnmodifiedEXT.Ptr
{}
