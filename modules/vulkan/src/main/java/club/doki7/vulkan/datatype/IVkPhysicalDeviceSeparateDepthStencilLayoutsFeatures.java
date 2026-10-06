package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSeparateDepthStencilLayoutsFeatures} and {@link VkPhysicalDeviceSeparateDepthStencilLayoutsFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSeparateDepthStencilLayoutsFeatures
    extends IPointer
    permits VkPhysicalDeviceSeparateDepthStencilLayoutsFeatures, VkPhysicalDeviceSeparateDepthStencilLayoutsFeatures.Ptr
{}
