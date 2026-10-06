package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryDedicatedRequirements} and {@link VkMemoryDedicatedRequirements.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryDedicatedRequirements
    extends IPointer
    permits VkMemoryDedicatedRequirements, VkMemoryDedicatedRequirements.Ptr
{}
