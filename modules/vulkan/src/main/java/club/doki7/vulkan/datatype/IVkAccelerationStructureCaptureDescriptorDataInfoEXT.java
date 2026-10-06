package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAccelerationStructureCaptureDescriptorDataInfoEXT} and {@link VkAccelerationStructureCaptureDescriptorDataInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAccelerationStructureCaptureDescriptorDataInfoEXT
    extends IPointer
    permits VkAccelerationStructureCaptureDescriptorDataInfoEXT, VkAccelerationStructureCaptureDescriptorDataInfoEXT.Ptr
{}
