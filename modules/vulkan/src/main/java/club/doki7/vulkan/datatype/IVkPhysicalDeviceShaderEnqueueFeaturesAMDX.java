package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderEnqueueFeaturesAMDX} and {@link VkPhysicalDeviceShaderEnqueueFeaturesAMDX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderEnqueueFeaturesAMDX
    extends IPointer
    permits VkPhysicalDeviceShaderEnqueueFeaturesAMDX, VkPhysicalDeviceShaderEnqueueFeaturesAMDX.Ptr
{}
