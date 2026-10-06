package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueueFamilyGlobalPriorityProperties} and {@link VkQueueFamilyGlobalPriorityProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueueFamilyGlobalPriorityProperties
    extends IPointer
    permits VkQueueFamilyGlobalPriorityProperties, VkQueueFamilyGlobalPriorityProperties.Ptr
{}
