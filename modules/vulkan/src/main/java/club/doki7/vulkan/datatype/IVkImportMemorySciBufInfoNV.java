package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMemorySciBufInfoNV} and {@link VkImportMemorySciBufInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMemorySciBufInfoNV
    extends IPointer
    permits VkImportMemorySciBufInfoNV, VkImportMemorySciBufInfoNV.Ptr
{}
