package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFragmentShadingRateAttachmentInfoKHR} and {@link VkFragmentShadingRateAttachmentInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFragmentShadingRateAttachmentInfoKHR
    extends IPointer
    permits VkFragmentShadingRateAttachmentInfoKHR, VkFragmentShadingRateAttachmentInfoKHR.Ptr
{}
