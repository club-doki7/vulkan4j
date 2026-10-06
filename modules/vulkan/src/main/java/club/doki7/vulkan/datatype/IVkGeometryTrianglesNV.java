package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGeometryTrianglesNV} and {@link VkGeometryTrianglesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGeometryTrianglesNV
    extends IPointer
    permits VkGeometryTrianglesNV, VkGeometryTrianglesNV.Ptr
{}
