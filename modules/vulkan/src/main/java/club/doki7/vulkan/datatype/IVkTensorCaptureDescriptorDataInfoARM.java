package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTensorCaptureDescriptorDataInfoARM} and {@link VkTensorCaptureDescriptorDataInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTensorCaptureDescriptorDataInfoARM
    extends IPointer
    permits VkTensorCaptureDescriptorDataInfoARM, VkTensorCaptureDescriptorDataInfoARM.Ptr
{}
