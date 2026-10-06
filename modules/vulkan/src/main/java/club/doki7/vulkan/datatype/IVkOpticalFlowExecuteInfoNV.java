package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkOpticalFlowExecuteInfoNV} and {@link VkOpticalFlowExecuteInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkOpticalFlowExecuteInfoNV
    extends IPointer
    permits VkOpticalFlowExecuteInfoNV, VkOpticalFlowExecuteInfoNV.Ptr
{}
