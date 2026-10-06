package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrawIndirectCountIndirectCommandEXT} and {@link VkDrawIndirectCountIndirectCommandEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrawIndirectCountIndirectCommandEXT
    extends IPointer
    permits VkDrawIndirectCountIndirectCommandEXT, VkDrawIndirectCountIndirectCommandEXT.Ptr
{}
