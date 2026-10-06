package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMicromapCreateInfoEXT} and {@link VkMicromapCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMicromapCreateInfoEXT
    extends IPointer
    permits VkMicromapCreateInfoEXT, VkMicromapCreateInfoEXT.Ptr
{}
