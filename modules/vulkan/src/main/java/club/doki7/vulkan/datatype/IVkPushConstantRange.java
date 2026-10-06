package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPushConstantRange} and {@link VkPushConstantRange.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPushConstantRange
    extends IPointer
    permits VkPushConstantRange, VkPushConstantRange.Ptr
{}
