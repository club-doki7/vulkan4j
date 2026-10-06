package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceRenderPassStripedFeaturesARM} and {@link VkPhysicalDeviceRenderPassStripedFeaturesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceRenderPassStripedFeaturesARM
    extends IPointer
    permits VkPhysicalDeviceRenderPassStripedFeaturesARM, VkPhysicalDeviceRenderPassStripedFeaturesARM.Ptr
{}
