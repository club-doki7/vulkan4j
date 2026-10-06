package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderUntypedPointersFeaturesKHR} and {@link VkPhysicalDeviceShaderUntypedPointersFeaturesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderUntypedPointersFeaturesKHR
    extends IPointer
    permits VkPhysicalDeviceShaderUntypedPointersFeaturesKHR, VkPhysicalDeviceShaderUntypedPointersFeaturesKHR.Ptr
{}
