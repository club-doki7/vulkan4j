package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFenceGetSciSyncInfoNV} and {@link VkFenceGetSciSyncInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFenceGetSciSyncInfoNV
    extends IPointer
    permits VkFenceGetSciSyncInfoNV, VkFenceGetSciSyncInfoNV.Ptr
{}
