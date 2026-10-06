package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDynamicRenderingLocalReadFeatures} and {@link VkPhysicalDeviceDynamicRenderingLocalReadFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDynamicRenderingLocalReadFeatures
    extends IPointer
    permits VkPhysicalDeviceDynamicRenderingLocalReadFeatures, VkPhysicalDeviceDynamicRenderingLocalReadFeatures.Ptr
{}
