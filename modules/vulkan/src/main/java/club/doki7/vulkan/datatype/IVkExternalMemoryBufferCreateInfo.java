package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalMemoryBufferCreateInfo} and {@link VkExternalMemoryBufferCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalMemoryBufferCreateInfo
    extends IPointer
    permits VkExternalMemoryBufferCreateInfo, VkExternalMemoryBufferCreateInfo.Ptr
{}
