package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkWriteDescriptorSetAccelerationStructureNV} and {@link VkWriteDescriptorSetAccelerationStructureNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkWriteDescriptorSetAccelerationStructureNV
    extends IPointer
    permits VkWriteDescriptorSetAccelerationStructureNV, VkWriteDescriptorSetAccelerationStructureNV.Ptr
{}
