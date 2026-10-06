package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderTerminateInvocationFeatures} and {@link VkPhysicalDeviceShaderTerminateInvocationFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderTerminateInvocationFeatures
    extends IPointer
    permits VkPhysicalDeviceShaderTerminateInvocationFeatures, VkPhysicalDeviceShaderTerminateInvocationFeatures.Ptr
{}
