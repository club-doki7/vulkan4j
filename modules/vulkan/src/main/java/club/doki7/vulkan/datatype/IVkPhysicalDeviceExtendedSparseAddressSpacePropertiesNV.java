package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV} and {@link VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV
    extends IPointer
    permits VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV, VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.Ptr
{}
