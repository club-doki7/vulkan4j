package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMultiDrawIndexedInfoEXT} and {@link VkMultiDrawIndexedInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMultiDrawIndexedInfoEXT
    extends IPointer
    permits VkMultiDrawIndexedInfoEXT, VkMultiDrawIndexedInfoEXT.Ptr
{}
