package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPushDataInfoEXT} and {@link VkPushDataInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPushDataInfoEXT
    extends IPointer
    permits VkPushDataInfoEXT, VkPushDataInfoEXT.Ptr
{}
