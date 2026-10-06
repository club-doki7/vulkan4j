package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkScreenBufferFormatPropertiesQNX} and {@link VkScreenBufferFormatPropertiesQNX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkScreenBufferFormatPropertiesQNX
    extends IPointer
    permits VkScreenBufferFormatPropertiesQNX, VkScreenBufferFormatPropertiesQNX.Ptr
{}
