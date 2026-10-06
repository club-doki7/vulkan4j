package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMetalCommandQueueInfoEXT} and {@link VkExportMetalCommandQueueInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMetalCommandQueueInfoEXT
    extends IPointer
    permits VkExportMetalCommandQueueInfoEXT, VkExportMetalCommandQueueInfoEXT.Ptr
{}
