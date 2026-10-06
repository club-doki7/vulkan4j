package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGeneratedCommandsInfoNV} and {@link VkGeneratedCommandsInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGeneratedCommandsInfoNV
    extends IPointer
    permits VkGeneratedCommandsInfoNV, VkGeneratedCommandsInfoNV.Ptr
{}
