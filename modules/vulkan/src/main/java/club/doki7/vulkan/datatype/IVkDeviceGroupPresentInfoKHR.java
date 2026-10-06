package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceGroupPresentInfoKHR} and {@link VkDeviceGroupPresentInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceGroupPresentInfoKHR
    extends IPointer
    permits VkDeviceGroupPresentInfoKHR, VkDeviceGroupPresentInfoKHR.Ptr
{}
