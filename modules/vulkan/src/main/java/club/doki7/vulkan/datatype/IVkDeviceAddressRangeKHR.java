package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceAddressRangeKHR} and {@link VkDeviceAddressRangeKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceAddressRangeKHR
    extends IPointer
    permits VkDeviceAddressRangeKHR, VkDeviceAddressRangeKHR.Ptr
{}
