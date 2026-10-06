package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceGroupPresentCapabilitiesKHR} and {@link VkDeviceGroupPresentCapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceGroupPresentCapabilitiesKHR
    extends IPointer
    permits VkDeviceGroupPresentCapabilitiesKHR, VkDeviceGroupPresentCapabilitiesKHR.Ptr
{}
