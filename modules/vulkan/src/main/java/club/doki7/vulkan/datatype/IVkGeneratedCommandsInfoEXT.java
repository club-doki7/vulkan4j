package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGeneratedCommandsInfoEXT} and {@link VkGeneratedCommandsInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGeneratedCommandsInfoEXT
    extends IPointer
    permits VkGeneratedCommandsInfoEXT, VkGeneratedCommandsInfoEXT.Ptr
{}
