package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderDemoteToHelperInvocationFeatures} and {@link VkPhysicalDeviceShaderDemoteToHelperInvocationFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderDemoteToHelperInvocationFeatures
    extends IPointer
    permits VkPhysicalDeviceShaderDemoteToHelperInvocationFeatures, VkPhysicalDeviceShaderDemoteToHelperInvocationFeatures.Ptr
{}
