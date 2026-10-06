package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSparseImageMemoryRequirements} and {@link VkSparseImageMemoryRequirements.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSparseImageMemoryRequirements
    extends IPointer
    permits VkSparseImageMemoryRequirements, VkSparseImageMemoryRequirements.Ptr
{}
