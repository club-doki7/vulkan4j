package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalMemoryImageCreateInfo} and {@link VkExternalMemoryImageCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalMemoryImageCreateInfo
    extends IPointer
    permits VkExternalMemoryImageCreateInfo, VkExternalMemoryImageCreateInfo.Ptr
{}
