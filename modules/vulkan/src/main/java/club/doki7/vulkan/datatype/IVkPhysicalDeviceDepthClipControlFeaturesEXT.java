package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDepthClipControlFeaturesEXT} and {@link VkPhysicalDeviceDepthClipControlFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDepthClipControlFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceDepthClipControlFeaturesEXT, VkPhysicalDeviceDepthClipControlFeaturesEXT.Ptr
{}
