package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMemoryFdInfoKHR} and {@link VkImportMemoryFdInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMemoryFdInfoKHR
    extends IPointer
    permits VkImportMemoryFdInfoKHR, VkImportMemoryFdInfoKHR.Ptr
{}
