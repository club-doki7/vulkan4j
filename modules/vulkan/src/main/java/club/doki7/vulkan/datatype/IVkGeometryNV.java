package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGeometryNV} and {@link VkGeometryNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGeometryNV
    extends IPointer
    permits VkGeometryNV, VkGeometryNV.Ptr
{}
