package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMetalTextureInfoEXT} and {@link VkExportMetalTextureInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMetalTextureInfoEXT
    extends IPointer
    permits VkExportMetalTextureInfoEXT, VkExportMetalTextureInfoEXT.Ptr
{}
