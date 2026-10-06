package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceEventInfoEXT} and {@link VkDeviceEventInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceEventInfoEXT
    extends IPointer
    permits VkDeviceEventInfoEXT, VkDeviceEventInfoEXT.Ptr
{}
