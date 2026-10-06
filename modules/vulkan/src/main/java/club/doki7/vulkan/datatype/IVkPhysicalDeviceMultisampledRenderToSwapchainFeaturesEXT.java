package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMultisampledRenderToSwapchainFeaturesEXT} and {@link VkPhysicalDeviceMultisampledRenderToSwapchainFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMultisampledRenderToSwapchainFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceMultisampledRenderToSwapchainFeaturesEXT, VkPhysicalDeviceMultisampledRenderToSwapchainFeaturesEXT.Ptr
{}
