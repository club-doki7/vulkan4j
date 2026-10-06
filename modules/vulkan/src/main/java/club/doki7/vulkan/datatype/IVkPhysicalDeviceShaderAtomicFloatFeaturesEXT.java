package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderAtomicFloatFeaturesEXT} and {@link VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderAtomicFloatFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderAtomicFloatFeaturesEXT, VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.Ptr
{}
