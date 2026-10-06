package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSetPresentConfigNV} and {@link VkSetPresentConfigNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSetPresentConfigNV
    extends IPointer
    permits VkSetPresentConfigNV, VkSetPresentConfigNV.Ptr
{}
