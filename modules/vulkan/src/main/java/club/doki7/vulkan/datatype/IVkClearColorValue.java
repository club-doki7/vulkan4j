package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkClearColorValue} and {@link VkClearColorValue.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkClearColorValue
    extends IPointer
    permits VkClearColorValue, VkClearColorValue.Ptr
{}
