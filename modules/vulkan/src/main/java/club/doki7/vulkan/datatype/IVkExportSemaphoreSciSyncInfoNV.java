package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportSemaphoreSciSyncInfoNV} and {@link VkExportSemaphoreSciSyncInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportSemaphoreSciSyncInfoNV
    extends IPointer
    permits VkExportSemaphoreSciSyncInfoNV, VkExportSemaphoreSciSyncInfoNV.Ptr
{}
