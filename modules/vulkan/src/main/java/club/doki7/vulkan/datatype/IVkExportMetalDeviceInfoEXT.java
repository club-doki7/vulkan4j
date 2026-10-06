package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExportMetalDeviceInfoEXT} and {@link VkExportMetalDeviceInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExportMetalDeviceInfoEXT
    extends IPointer
    permits VkExportMetalDeviceInfoEXT, VkExportMetalDeviceInfoEXT.Ptr
{}
