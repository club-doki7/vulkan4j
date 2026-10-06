package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureMemoryRequirementsInfoNV} and {@link VkAccelerationStructureMemoryRequirementsInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureMemoryRequirementsInfoNV
    extends IPointer
    permits VkAccelerationStructureMemoryRequirementsInfoNV, VkAccelerationStructureMemoryRequirementsInfoNV.Ptr
{}
