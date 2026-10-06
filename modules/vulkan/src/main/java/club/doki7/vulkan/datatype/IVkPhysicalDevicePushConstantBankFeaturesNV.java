package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePushConstantBankFeaturesNV} and {@link VkPhysicalDevicePushConstantBankFeaturesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePushConstantBankFeaturesNV
    extends IPointer
    permits VkPhysicalDevicePushConstantBankFeaturesNV, VkPhysicalDevicePushConstantBankFeaturesNV.Ptr
{}
