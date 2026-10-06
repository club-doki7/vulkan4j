package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkComponentMapping} and {@link VkComponentMapping.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkComponentMapping
    extends IPointer
    permits VkComponentMapping, VkComponentMapping.Ptr
{}
