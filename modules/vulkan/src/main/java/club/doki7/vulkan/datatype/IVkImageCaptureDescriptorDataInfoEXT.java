package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImageCaptureDescriptorDataInfoEXT} and {@link VkImageCaptureDescriptorDataInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImageCaptureDescriptorDataInfoEXT
    extends IPointer
    permits VkImageCaptureDescriptorDataInfoEXT, VkImageCaptureDescriptorDataInfoEXT.Ptr
{}
