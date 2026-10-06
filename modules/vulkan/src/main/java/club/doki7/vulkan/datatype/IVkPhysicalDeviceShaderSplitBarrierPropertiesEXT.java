package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderSplitBarrierPropertiesEXT} and {@link VkPhysicalDeviceShaderSplitBarrierPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderSplitBarrierPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderSplitBarrierPropertiesEXT, VkPhysicalDeviceShaderSplitBarrierPropertiesEXT.Ptr
{}
