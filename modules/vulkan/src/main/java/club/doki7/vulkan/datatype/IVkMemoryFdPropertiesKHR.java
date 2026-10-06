package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryFdPropertiesKHR} and {@link VkMemoryFdPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryFdPropertiesKHR
    extends IPointer
    permits VkMemoryFdPropertiesKHR, VkMemoryFdPropertiesKHR.Ptr
{}
