package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDepthClampControlFeaturesEXT} and {@link VkPhysicalDeviceDepthClampControlFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDepthClampControlFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceDepthClampControlFeaturesEXT, VkPhysicalDeviceDepthClampControlFeaturesEXT.Ptr
{}
