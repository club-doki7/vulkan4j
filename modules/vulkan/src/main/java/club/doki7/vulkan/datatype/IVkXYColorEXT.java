package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkXYColorEXT} and {@link VkXYColorEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkXYColorEXT
    extends IPointer
    permits VkXYColorEXT, VkXYColorEXT.Ptr
{}
