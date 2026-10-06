package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemorySciBufPropertiesNV} and {@link VkMemorySciBufPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemorySciBufPropertiesNV
    extends IPointer
    permits VkMemorySciBufPropertiesNV, VkMemorySciBufPropertiesNV.Ptr
{}
