package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportFenceSciSyncInfoNV} and {@link VkExportFenceSciSyncInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportFenceSciSyncInfoNV
    extends IPointer
    permits VkExportFenceSciSyncInfoNV, VkExportFenceSciSyncInfoNV.Ptr
{}
