package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMetalIOSurfaceInfoEXT} and {@link VkImportMetalIOSurfaceInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMetalIOSurfaceInfoEXT
    extends IPointer
    permits VkImportMetalIOSurfaceInfoEXT, VkImportMetalIOSurfaceInfoEXT.Ptr
{}
