package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkOpticalFlowSessionCreateInfoNV} and {@link VkOpticalFlowSessionCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkOpticalFlowSessionCreateInfoNV
    extends IPointer
    permits VkOpticalFlowSessionCreateInfoNV, VkOpticalFlowSessionCreateInfoNV.Ptr
{}
