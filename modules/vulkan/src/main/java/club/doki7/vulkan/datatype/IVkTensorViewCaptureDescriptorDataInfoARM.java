package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTensorViewCaptureDescriptorDataInfoARM} and {@link VkTensorViewCaptureDescriptorDataInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTensorViewCaptureDescriptorDataInfoARM
    extends IPointer
    permits VkTensorViewCaptureDescriptorDataInfoARM, VkTensorViewCaptureDescriptorDataInfoARM.Ptr
{}
