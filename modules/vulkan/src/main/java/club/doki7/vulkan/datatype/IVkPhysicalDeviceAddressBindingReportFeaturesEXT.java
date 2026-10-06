package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceAddressBindingReportFeaturesEXT} and {@link VkPhysicalDeviceAddressBindingReportFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceAddressBindingReportFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceAddressBindingReportFeaturesEXT, VkPhysicalDeviceAddressBindingReportFeaturesEXT.Ptr
{}
