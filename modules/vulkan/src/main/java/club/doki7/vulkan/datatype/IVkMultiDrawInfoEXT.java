package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMultiDrawInfoEXT} and {@link VkMultiDrawInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMultiDrawInfoEXT
    extends IPointer
    permits VkMultiDrawInfoEXT, VkMultiDrawInfoEXT.Ptr
{}
