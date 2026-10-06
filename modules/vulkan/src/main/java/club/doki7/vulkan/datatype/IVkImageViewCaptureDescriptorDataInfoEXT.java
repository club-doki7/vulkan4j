package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageViewCaptureDescriptorDataInfoEXT} and {@link VkImageViewCaptureDescriptorDataInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageViewCaptureDescriptorDataInfoEXT
    extends IPointer
    permits VkImageViewCaptureDescriptorDataInfoEXT, VkImageViewCaptureDescriptorDataInfoEXT.Ptr
{}
