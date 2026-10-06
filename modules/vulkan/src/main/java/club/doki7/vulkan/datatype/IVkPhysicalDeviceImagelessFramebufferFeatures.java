package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceImagelessFramebufferFeatures} and {@link VkPhysicalDeviceImagelessFramebufferFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceImagelessFramebufferFeatures
    extends IPointer
    permits VkPhysicalDeviceImagelessFramebufferFeatures, VkPhysicalDeviceImagelessFramebufferFeatures.Ptr
{}
