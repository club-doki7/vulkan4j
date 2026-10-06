package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDrawMeshTasksIndirectCommandEXT} and {@link VkDrawMeshTasksIndirectCommandEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDrawMeshTasksIndirectCommandEXT
    extends IPointer
    permits VkDrawMeshTasksIndirectCommandEXT, VkDrawMeshTasksIndirectCommandEXT.Ptr
{}
