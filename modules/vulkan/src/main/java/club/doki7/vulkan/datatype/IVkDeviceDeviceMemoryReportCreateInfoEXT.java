package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceDeviceMemoryReportCreateInfoEXT} and {@link VkDeviceDeviceMemoryReportCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceDeviceMemoryReportCreateInfoEXT
    extends IPointer
    permits VkDeviceDeviceMemoryReportCreateInfoEXT, VkDeviceDeviceMemoryReportCreateInfoEXT.Ptr
{}
