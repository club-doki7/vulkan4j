package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderExpectAssumeFeatures} and {@link VkPhysicalDeviceShaderExpectAssumeFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderExpectAssumeFeatures
    extends IPointer
    permits VkPhysicalDeviceShaderExpectAssumeFeatures, VkPhysicalDeviceShaderExpectAssumeFeatures.Ptr
{}
