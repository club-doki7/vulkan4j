package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceRenderPassStripedPropertiesARM} and {@link VkPhysicalDeviceRenderPassStripedPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceRenderPassStripedPropertiesARM
    extends IPointer
    permits VkPhysicalDeviceRenderPassStripedPropertiesARM, VkPhysicalDeviceRenderPassStripedPropertiesARM.Ptr
{}
