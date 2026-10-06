package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMetalObjectsInfoEXT} and {@link VkExportMetalObjectsInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMetalObjectsInfoEXT
    extends IPointer
    permits VkExportMetalObjectsInfoEXT, VkExportMetalObjectsInfoEXT.Ptr
{}
