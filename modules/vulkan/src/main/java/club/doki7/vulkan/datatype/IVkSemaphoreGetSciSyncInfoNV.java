package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreGetSciSyncInfoNV} and {@link VkSemaphoreGetSciSyncInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreGetSciSyncInfoNV
    extends IPointer
    permits VkSemaphoreGetSciSyncInfoNV, VkSemaphoreGetSciSyncInfoNV.Ptr
{}
