package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalComputeQueueDeviceCreateInfoNV} and {@link VkExternalComputeQueueDeviceCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalComputeQueueDeviceCreateInfoNV
    extends IPointer
    permits VkExternalComputeQueueDeviceCreateInfoNV, VkExternalComputeQueueDeviceCreateInfoNV.Ptr
{}
