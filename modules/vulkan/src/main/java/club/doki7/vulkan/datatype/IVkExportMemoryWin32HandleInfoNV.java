package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMemoryWin32HandleInfoNV} and {@link VkExportMemoryWin32HandleInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMemoryWin32HandleInfoNV
    extends IPointer
    permits VkExportMemoryWin32HandleInfoNV, VkExportMemoryWin32HandleInfoNV.Ptr
{}
