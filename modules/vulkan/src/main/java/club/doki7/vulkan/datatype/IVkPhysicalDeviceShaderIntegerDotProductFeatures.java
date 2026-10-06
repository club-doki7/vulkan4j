package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderIntegerDotProductFeatures} and {@link VkPhysicalDeviceShaderIntegerDotProductFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderIntegerDotProductFeatures
    extends IPointer
    permits VkPhysicalDeviceShaderIntegerDotProductFeatures, VkPhysicalDeviceShaderIntegerDotProductFeatures.Ptr
{}
