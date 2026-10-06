package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSamplerCaptureDescriptorDataInfoEXT} and {@link VkSamplerCaptureDescriptorDataInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSamplerCaptureDescriptorDataInfoEXT
    extends IPointer
    permits VkSamplerCaptureDescriptorDataInfoEXT, VkSamplerCaptureDescriptorDataInfoEXT.Ptr
{}
