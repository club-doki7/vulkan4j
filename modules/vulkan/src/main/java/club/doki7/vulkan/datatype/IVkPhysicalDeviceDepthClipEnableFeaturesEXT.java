package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDepthClipEnableFeaturesEXT} and {@link VkPhysicalDeviceDepthClipEnableFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDepthClipEnableFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceDepthClipEnableFeaturesEXT, VkPhysicalDeviceDepthClipEnableFeaturesEXT.Ptr
{}
