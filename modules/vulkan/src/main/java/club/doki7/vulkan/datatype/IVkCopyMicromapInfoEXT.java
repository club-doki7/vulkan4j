package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyMicromapInfoEXT} and {@link VkCopyMicromapInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyMicromapInfoEXT
    extends IPointer
    permits VkCopyMicromapInfoEXT, VkCopyMicromapInfoEXT.Ptr
{}
