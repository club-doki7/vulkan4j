package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalMemoryImageCreateInfoNV} and {@link VkExternalMemoryImageCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalMemoryImageCreateInfoNV
    extends IPointer
    permits VkExternalMemoryImageCreateInfoNV, VkExternalMemoryImageCreateInfoNV.Ptr
{}
