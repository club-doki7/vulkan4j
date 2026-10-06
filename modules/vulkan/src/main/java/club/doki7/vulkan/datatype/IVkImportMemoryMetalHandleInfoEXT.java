package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMemoryMetalHandleInfoEXT} and {@link VkImportMemoryMetalHandleInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMemoryMetalHandleInfoEXT
    extends IPointer
    permits VkImportMemoryMetalHandleInfoEXT, VkImportMemoryMetalHandleInfoEXT.Ptr
{}
