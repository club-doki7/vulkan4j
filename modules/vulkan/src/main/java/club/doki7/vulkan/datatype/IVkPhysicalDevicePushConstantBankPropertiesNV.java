package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePushConstantBankPropertiesNV} and {@link VkPhysicalDevicePushConstantBankPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePushConstantBankPropertiesNV
    extends IPointer
    permits VkPhysicalDevicePushConstantBankPropertiesNV, VkPhysicalDevicePushConstantBankPropertiesNV.Ptr
{}
