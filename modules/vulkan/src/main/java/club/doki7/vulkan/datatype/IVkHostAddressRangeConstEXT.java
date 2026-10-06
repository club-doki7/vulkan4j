package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkHostAddressRangeConstEXT} and {@link VkHostAddressRangeConstEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkHostAddressRangeConstEXT
    extends IPointer
    permits VkHostAddressRangeConstEXT, VkHostAddressRangeConstEXT.Ptr
{}
