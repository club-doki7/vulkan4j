package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkOffset3D} and {@link VkOffset3D.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkOffset3D
    extends IPointer
    permits VkOffset3D, VkOffset3D.Ptr
{}
