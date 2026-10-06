package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayPropertiesKHR} and {@link VkDisplayPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayPropertiesKHR
    extends IPointer
    permits VkDisplayPropertiesKHR, VkDisplayPropertiesKHR.Ptr
{}
