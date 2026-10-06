package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalComputeQueueCreateInfoNV} and {@link VkExternalComputeQueueCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalComputeQueueCreateInfoNV
    extends IPointer
    permits VkExternalComputeQueueCreateInfoNV, VkExternalComputeQueueCreateInfoNV.Ptr
{}
