package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryGetSciBufInfoNV} and {@link VkMemoryGetSciBufInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryGetSciBufInfoNV
    extends IPointer
    permits VkMemoryGetSciBufInfoNV, VkMemoryGetSciBufInfoNV.Ptr
{}
