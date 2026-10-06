package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMemorySciBufInfoNV} and {@link VkExportMemorySciBufInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMemorySciBufInfoNV
    extends IPointer
    permits VkExportMemorySciBufInfoNV, VkExportMemorySciBufInfoNV.Ptr
{}
