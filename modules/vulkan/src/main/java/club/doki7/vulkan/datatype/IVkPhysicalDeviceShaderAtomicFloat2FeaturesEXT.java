package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT} and {@link VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderAtomicFloat2FeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT, VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.Ptr
{}
