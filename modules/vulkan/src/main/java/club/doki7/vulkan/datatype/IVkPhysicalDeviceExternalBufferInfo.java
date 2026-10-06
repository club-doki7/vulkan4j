package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceExternalBufferInfo} and {@link VkPhysicalDeviceExternalBufferInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceExternalBufferInfo
    extends IPointer
    permits VkPhysicalDeviceExternalBufferInfo, VkPhysicalDeviceExternalBufferInfo.Ptr
{}
