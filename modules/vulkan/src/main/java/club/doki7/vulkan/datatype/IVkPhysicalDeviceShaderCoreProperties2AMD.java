package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderCoreProperties2AMD} and {@link VkPhysicalDeviceShaderCoreProperties2AMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderCoreProperties2AMD
    extends IPointer
    permits VkPhysicalDeviceShaderCoreProperties2AMD, VkPhysicalDeviceShaderCoreProperties2AMD.Ptr
{}
