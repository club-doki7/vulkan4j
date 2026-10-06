package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderSplitBarrierFeaturesEXT} and {@link VkPhysicalDeviceShaderSplitBarrierFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderSplitBarrierFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderSplitBarrierFeaturesEXT, VkPhysicalDeviceShaderSplitBarrierFeaturesEXT.Ptr
{}
