package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkViewport} and {@link VkViewport.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkViewport
    extends IPointer
    permits VkViewport, VkViewport.Ptr
{}
