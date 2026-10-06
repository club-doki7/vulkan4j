package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExternalFenceInfo} and {@link VkPhysicalDeviceExternalFenceInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExternalFenceInfo
    extends IPointer
    permits VkPhysicalDeviceExternalFenceInfo, VkPhysicalDeviceExternalFenceInfo.Ptr
{}
