package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceAmigoProfilingFeaturesSEC} and {@link VkPhysicalDeviceAmigoProfilingFeaturesSEC.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceAmigoProfilingFeaturesSEC
    extends IPointer
    permits VkPhysicalDeviceAmigoProfilingFeaturesSEC, VkPhysicalDeviceAmigoProfilingFeaturesSEC.Ptr
{}
