package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalFormatQNX} and {@link VkExternalFormatQNX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalFormatQNX
    extends IPointer
    permits VkExternalFormatQNX, VkExternalFormatQNX.Ptr
{}
