package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBeginCustomResolveInfoEXT} and {@link VkBeginCustomResolveInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBeginCustomResolveInfoEXT
    extends IPointer
    permits VkBeginCustomResolveInfoEXT, VkBeginCustomResolveInfoEXT.Ptr
{}
