package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDedicatedAllocationBufferCreateInfoNV} and {@link VkDedicatedAllocationBufferCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDedicatedAllocationBufferCreateInfoNV
    extends IPointer
    permits VkDedicatedAllocationBufferCreateInfoNV, VkDedicatedAllocationBufferCreateInfoNV.Ptr
{}
