package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMemoryWin32HandleInfoNV} and {@link VkImportMemoryWin32HandleInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMemoryWin32HandleInfoNV
    extends IPointer
    permits VkImportMemoryWin32HandleInfoNV, VkImportMemoryWin32HandleInfoNV.Ptr
{}
