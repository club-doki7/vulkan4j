package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMemoryAllocateInfoNV} and {@link VkExportMemoryAllocateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMemoryAllocateInfoNV
    extends IPointer
    permits VkExportMemoryAllocateInfoNV, VkExportMemoryAllocateInfoNV.Ptr
{}
