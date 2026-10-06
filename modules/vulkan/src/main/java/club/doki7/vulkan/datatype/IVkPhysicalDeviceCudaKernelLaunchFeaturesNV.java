package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCudaKernelLaunchFeaturesNV} and {@link VkPhysicalDeviceCudaKernelLaunchFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCudaKernelLaunchFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceCudaKernelLaunchFeaturesNV, VkPhysicalDeviceCudaKernelLaunchFeaturesNV.Ptr
{}
