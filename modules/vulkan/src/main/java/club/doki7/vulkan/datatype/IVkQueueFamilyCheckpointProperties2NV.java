package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueueFamilyCheckpointProperties2NV} and {@link VkQueueFamilyCheckpointProperties2NV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueueFamilyCheckpointProperties2NV
    extends IPointer
    permits VkQueueFamilyCheckpointProperties2NV, VkQueueFamilyCheckpointProperties2NV.Ptr
{}
