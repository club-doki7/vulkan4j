package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkHostAddressRangeEXT} and {@link VkHostAddressRangeEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkHostAddressRangeEXT
    extends IPointer
    permits VkHostAddressRangeEXT, VkHostAddressRangeEXT.Ptr
{}
