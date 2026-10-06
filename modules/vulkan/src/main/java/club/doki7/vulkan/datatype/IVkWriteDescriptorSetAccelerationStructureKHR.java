package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkWriteDescriptorSetAccelerationStructureKHR} and {@link VkWriteDescriptorSetAccelerationStructureKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkWriteDescriptorSetAccelerationStructureKHR
    extends IPointer
    permits VkWriteDescriptorSetAccelerationStructureKHR, VkWriteDescriptorSetAccelerationStructureKHR.Ptr
{}
