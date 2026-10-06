package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueueFamilyCheckpointPropertiesNV} and {@link VkQueueFamilyCheckpointPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueueFamilyCheckpointPropertiesNV
    extends IPointer
    permits VkQueueFamilyCheckpointPropertiesNV, VkQueueFamilyCheckpointPropertiesNV.Ptr
{}
