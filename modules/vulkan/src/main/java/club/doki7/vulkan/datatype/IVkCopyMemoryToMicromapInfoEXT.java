package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyMemoryToMicromapInfoEXT} and {@link VkCopyMemoryToMicromapInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyMemoryToMicromapInfoEXT
    extends IPointer
    permits VkCopyMemoryToMicromapInfoEXT, VkCopyMemoryToMicromapInfoEXT.Ptr
{}
