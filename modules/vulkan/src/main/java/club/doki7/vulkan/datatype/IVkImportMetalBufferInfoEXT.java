package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMetalBufferInfoEXT} and {@link VkImportMetalBufferInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMetalBufferInfoEXT
    extends IPointer
    permits VkImportMetalBufferInfoEXT, VkImportMetalBufferInfoEXT.Ptr
{}
