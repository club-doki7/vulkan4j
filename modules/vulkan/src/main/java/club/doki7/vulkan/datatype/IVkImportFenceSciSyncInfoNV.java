package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportFenceSciSyncInfoNV} and {@link VkImportFenceSciSyncInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportFenceSciSyncInfoNV
    extends IPointer
    permits VkImportFenceSciSyncInfoNV, VkImportFenceSciSyncInfoNV.Ptr
{}
