package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMemoryAllocateInfo} and {@link VkExportMemoryAllocateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMemoryAllocateInfo
    extends IPointer
    permits VkExportMemoryAllocateInfo, VkExportMemoryAllocateInfo.Ptr
{}
