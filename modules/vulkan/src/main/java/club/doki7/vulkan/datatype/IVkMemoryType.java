package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryType} and {@link VkMemoryType.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryType
    extends IPointer
    permits VkMemoryType, VkMemoryType.Ptr
{}
