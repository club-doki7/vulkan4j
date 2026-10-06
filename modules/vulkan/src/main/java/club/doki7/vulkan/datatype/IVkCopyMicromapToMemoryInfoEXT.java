package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyMicromapToMemoryInfoEXT} and {@link VkCopyMicromapToMemoryInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyMicromapToMemoryInfoEXT
    extends IPointer
    permits VkCopyMicromapToMemoryInfoEXT, VkCopyMicromapToMemoryInfoEXT.Ptr
{}
