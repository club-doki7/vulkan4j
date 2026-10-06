package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentStageTimeEXT} and {@link VkPresentStageTimeEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentStageTimeEXT
    extends IPointer
    permits VkPresentStageTimeEXT, VkPresentStageTimeEXT.Ptr
{}
