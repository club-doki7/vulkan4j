package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCudaKernelLaunchPropertiesNV} and {@link VkPhysicalDeviceCudaKernelLaunchPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCudaKernelLaunchPropertiesNV
    extends IPointer
    permits VkPhysicalDeviceCudaKernelLaunchPropertiesNV, VkPhysicalDeviceCudaKernelLaunchPropertiesNV.Ptr
{}
