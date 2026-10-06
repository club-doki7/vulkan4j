package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportFenceCreateInfo} and {@link VkExportFenceCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportFenceCreateInfo
    extends IPointer
    permits VkExportFenceCreateInfo, VkExportFenceCreateInfo.Ptr
{}
