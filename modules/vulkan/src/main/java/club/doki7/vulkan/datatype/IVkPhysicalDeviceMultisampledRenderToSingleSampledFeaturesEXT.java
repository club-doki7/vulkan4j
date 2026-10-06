package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceMultisampledRenderToSingleSampledFeaturesEXT} and {@link VkPhysicalDeviceMultisampledRenderToSingleSampledFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceMultisampledRenderToSingleSampledFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceMultisampledRenderToSingleSampledFeaturesEXT, VkPhysicalDeviceMultisampledRenderToSingleSampledFeaturesEXT.Ptr
{}
