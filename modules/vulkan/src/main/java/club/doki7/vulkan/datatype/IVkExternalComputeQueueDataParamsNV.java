package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalComputeQueueDataParamsNV} and {@link VkExternalComputeQueueDataParamsNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalComputeQueueDataParamsNV
    extends IPointer
    permits VkExternalComputeQueueDataParamsNV, VkExternalComputeQueueDataParamsNV.Ptr
{}
