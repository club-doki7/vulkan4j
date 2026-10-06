package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreSciSyncCreateInfoNV} and {@link VkSemaphoreSciSyncCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreSciSyncCreateInfoNV
    extends IPointer
    permits VkSemaphoreSciSyncCreateInfoNV, VkSemaphoreSciSyncCreateInfoNV.Ptr
{}
