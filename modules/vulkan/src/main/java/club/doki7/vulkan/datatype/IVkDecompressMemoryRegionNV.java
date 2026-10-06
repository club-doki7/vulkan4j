package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDecompressMemoryRegionNV} and {@link VkDecompressMemoryRegionNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDecompressMemoryRegionNV
    extends IPointer
    permits VkDecompressMemoryRegionNV, VkDecompressMemoryRegionNV.Ptr
{}
