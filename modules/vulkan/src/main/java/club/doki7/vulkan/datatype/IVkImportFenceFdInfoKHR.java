package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportFenceFdInfoKHR} and {@link VkImportFenceFdInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportFenceFdInfoKHR
    extends IPointer
    permits VkImportFenceFdInfoKHR, VkImportFenceFdInfoKHR.Ptr
{}
