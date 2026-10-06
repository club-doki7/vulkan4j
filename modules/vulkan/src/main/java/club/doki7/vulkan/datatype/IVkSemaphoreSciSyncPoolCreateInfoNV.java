package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSemaphoreSciSyncPoolCreateInfoNV} and {@link VkSemaphoreSciSyncPoolCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSemaphoreSciSyncPoolCreateInfoNV
    extends IPointer
    permits VkSemaphoreSciSyncPoolCreateInfoNV, VkSemaphoreSciSyncPoolCreateInfoNV.Ptr
{}
