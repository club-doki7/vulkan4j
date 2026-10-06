package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMetalBufferInfoEXT} and {@link VkExportMetalBufferInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMetalBufferInfoEXT
    extends IPointer
    permits VkExportMetalBufferInfoEXT, VkExportMetalBufferInfoEXT.Ptr
{}
