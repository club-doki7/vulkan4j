package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceMemoryReportCallbackDataEXT} and {@link VkDeviceMemoryReportCallbackDataEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceMemoryReportCallbackDataEXT
    extends IPointer
    permits VkDeviceMemoryReportCallbackDataEXT, VkDeviceMemoryReportCallbackDataEXT.Ptr
{}
