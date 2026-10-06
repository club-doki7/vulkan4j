package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalBufferProperties} and {@link VkExternalBufferProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalBufferProperties
    extends IPointer
    permits VkExternalBufferProperties, VkExternalBufferProperties.Ptr
{}
