package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceShaderAtomicInt64Features} and {@link VkPhysicalDeviceShaderAtomicInt64Features.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceShaderAtomicInt64Features
    extends IPointer
    permits VkPhysicalDeviceShaderAtomicInt64Features, VkPhysicalDeviceShaderAtomicInt64Features.Ptr
{}
