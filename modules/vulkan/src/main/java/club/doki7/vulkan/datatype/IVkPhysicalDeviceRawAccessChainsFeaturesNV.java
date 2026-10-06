package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceRawAccessChainsFeaturesNV} and {@link VkPhysicalDeviceRawAccessChainsFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceRawAccessChainsFeaturesNV
    extends IPointer
    permits VkPhysicalDeviceRawAccessChainsFeaturesNV, VkPhysicalDeviceRawAccessChainsFeaturesNV.Ptr
{}
