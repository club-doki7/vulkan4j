package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkClusterAccelerationStructureOpInputNV} and {@link VkClusterAccelerationStructureOpInputNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkClusterAccelerationStructureOpInputNV
    extends IPointer
    permits VkClusterAccelerationStructureOpInputNV, VkClusterAccelerationStructureOpInputNV.Ptr
{}
