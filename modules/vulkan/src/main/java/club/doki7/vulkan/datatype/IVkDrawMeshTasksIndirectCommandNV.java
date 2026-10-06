package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrawMeshTasksIndirectCommandNV} and {@link VkDrawMeshTasksIndirectCommandNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrawMeshTasksIndirectCommandNV
    extends IPointer
    permits VkDrawMeshTasksIndirectCommandNV, VkDrawMeshTasksIndirectCommandNV.Ptr
{}
