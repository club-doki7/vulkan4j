package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalMemoryProperties} and {@link VkExternalMemoryProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalMemoryProperties
    extends IPointer
    permits VkExternalMemoryProperties, VkExternalMemoryProperties.Ptr
{}
