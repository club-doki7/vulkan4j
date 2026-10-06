package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportSemaphoreCreateInfo} and {@link VkExportSemaphoreCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportSemaphoreCreateInfo
    extends IPointer
    permits VkExportSemaphoreCreateInfo, VkExportSemaphoreCreateInfo.Ptr
{}
