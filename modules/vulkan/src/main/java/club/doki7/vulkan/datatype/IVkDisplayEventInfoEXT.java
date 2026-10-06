package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayEventInfoEXT} and {@link VkDisplayEventInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayEventInfoEXT
    extends IPointer
    permits VkDisplayEventInfoEXT, VkDisplayEventInfoEXT.Ptr
{}
