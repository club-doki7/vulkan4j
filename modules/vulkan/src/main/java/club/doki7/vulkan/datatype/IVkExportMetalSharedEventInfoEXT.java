package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMetalSharedEventInfoEXT} and {@link VkExportMetalSharedEventInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMetalSharedEventInfoEXT
    extends IPointer
    permits VkExportMetalSharedEventInfoEXT, VkExportMetalSharedEventInfoEXT.Ptr
{}
