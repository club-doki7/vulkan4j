package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAllocationCallbacks} and {@link VkAllocationCallbacks.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAllocationCallbacks
    extends IPointer
    permits VkAllocationCallbacks, VkAllocationCallbacks.Ptr
{}
