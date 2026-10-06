package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayModePropertiesKHR} and {@link VkDisplayModePropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayModePropertiesKHR
    extends IPointer
    permits VkDisplayModePropertiesKHR, VkDisplayModePropertiesKHR.Ptr
{}
