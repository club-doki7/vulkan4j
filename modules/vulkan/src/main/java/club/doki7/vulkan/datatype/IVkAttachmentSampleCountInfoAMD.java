package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAttachmentSampleCountInfoAMD} and {@link VkAttachmentSampleCountInfoAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAttachmentSampleCountInfoAMD
    extends IPointer
    permits VkAttachmentSampleCountInfoAMD, VkAttachmentSampleCountInfoAMD.Ptr
{}
