package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderEnqueuePropertiesAMDX} and {@link VkPhysicalDeviceShaderEnqueuePropertiesAMDX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderEnqueuePropertiesAMDX
    extends IPointer
    permits VkPhysicalDeviceShaderEnqueuePropertiesAMDX, VkPhysicalDeviceShaderEnqueuePropertiesAMDX.Ptr
{}
