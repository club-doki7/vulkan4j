package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGeometryAABBNV} and {@link VkGeometryAABBNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGeometryAABBNV
    extends IPointer
    permits VkGeometryAABBNV, VkGeometryAABBNV.Ptr
{}
