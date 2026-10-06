package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDiagnosticsConfigFeaturesNV} and {@link VkPhysicalDeviceDiagnosticsConfigFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDiagnosticsConfigFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceDiagnosticsConfigFeaturesNV, VkPhysicalDeviceDiagnosticsConfigFeaturesNV.Ptr
{}
