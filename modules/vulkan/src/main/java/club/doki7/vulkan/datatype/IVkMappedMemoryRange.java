package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMappedMemoryRange} and {@link VkMappedMemoryRange.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMappedMemoryRange
    extends IPointer
    permits VkMappedMemoryRange, VkMappedMemoryRange.Ptr
{}
