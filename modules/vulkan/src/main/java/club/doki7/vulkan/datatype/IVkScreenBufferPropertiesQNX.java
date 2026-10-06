package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkScreenBufferPropertiesQNX} and {@link VkScreenBufferPropertiesQNX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkScreenBufferPropertiesQNX
    extends IPointer
    permits VkScreenBufferPropertiesQNX, VkScreenBufferPropertiesQNX.Ptr
{}
