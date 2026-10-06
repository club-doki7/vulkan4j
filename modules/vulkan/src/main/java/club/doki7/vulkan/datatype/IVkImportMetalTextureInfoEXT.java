package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMetalTextureInfoEXT} and {@link VkImportMetalTextureInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMetalTextureInfoEXT
    extends IPointer
    permits VkImportMetalTextureInfoEXT, VkImportMetalTextureInfoEXT.Ptr
{}
