package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGeometryDataNV} and {@link VkGeometryDataNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGeometryDataNV
    extends IPointer
    permits VkGeometryDataNV, VkGeometryDataNV.Ptr
{}
