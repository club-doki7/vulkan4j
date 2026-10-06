package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMetalObjectCreateInfoEXT} and {@link VkExportMetalObjectCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMetalObjectCreateInfoEXT
    extends IPointer
    permits VkExportMetalObjectCreateInfoEXT, VkExportMetalObjectCreateInfoEXT.Ptr
{}
