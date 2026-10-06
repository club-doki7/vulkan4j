package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExtent3D} and {@link VkExtent3D.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExtent3D
    extends IPointer
    permits VkExtent3D, VkExtent3D.Ptr
{}
