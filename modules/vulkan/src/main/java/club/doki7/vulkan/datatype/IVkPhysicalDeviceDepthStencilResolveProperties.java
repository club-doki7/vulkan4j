package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDepthStencilResolveProperties} and {@link VkPhysicalDeviceDepthStencilResolveProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDepthStencilResolveProperties
    extends IPointer
    permits VkPhysicalDeviceDepthStencilResolveProperties, VkPhysicalDeviceDepthStencilResolveProperties.Ptr
{}
