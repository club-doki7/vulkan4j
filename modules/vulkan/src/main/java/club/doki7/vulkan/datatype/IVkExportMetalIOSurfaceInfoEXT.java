package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMetalIOSurfaceInfoEXT} and {@link VkExportMetalIOSurfaceInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMetalIOSurfaceInfoEXT
    extends IPointer
    permits VkExportMetalIOSurfaceInfoEXT, VkExportMetalIOSurfaceInfoEXT.Ptr
{}
