package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueueFamilyVideoPropertiesKHR} and {@link VkQueueFamilyVideoPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueueFamilyVideoPropertiesKHR
    extends IPointer
    permits VkQueueFamilyVideoPropertiesKHR, VkQueueFamilyVideoPropertiesKHR.Ptr
{}
