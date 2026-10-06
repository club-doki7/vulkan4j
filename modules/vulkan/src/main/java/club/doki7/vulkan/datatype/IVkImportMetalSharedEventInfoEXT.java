package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportMetalSharedEventInfoEXT} and {@link VkImportMetalSharedEventInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportMetalSharedEventInfoEXT
    extends IPointer
    permits VkImportMetalSharedEventInfoEXT, VkImportMetalSharedEventInfoEXT.Ptr
{}
