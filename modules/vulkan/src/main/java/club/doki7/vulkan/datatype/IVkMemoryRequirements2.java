package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryRequirements2} and {@link VkMemoryRequirements2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryRequirements2
    extends IPointer
    permits VkMemoryRequirements2, VkMemoryRequirements2.Ptr
{}
