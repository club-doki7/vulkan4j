package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureDeviceAddressInfoKHR} and {@link VkAccelerationStructureDeviceAddressInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureDeviceAddressInfoKHR
    extends IPointer
    permits VkAccelerationStructureDeviceAddressInfoKHR, VkAccelerationStructureDeviceAddressInfoKHR.Ptr
{}
