package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderFloat16Int8Features} and {@link VkPhysicalDeviceShaderFloat16Int8Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderFloat16Int8Features
    extends IPointer
    permits VkPhysicalDeviceShaderFloat16Int8Features, VkPhysicalDeviceShaderFloat16Int8Features.Ptr
{}
