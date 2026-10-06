package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDepthClampRangeEXT} and {@link VkDepthClampRangeEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDepthClampRangeEXT
    extends IPointer
    permits VkDepthClampRangeEXT, VkDepthClampRangeEXT.Ptr
{}
