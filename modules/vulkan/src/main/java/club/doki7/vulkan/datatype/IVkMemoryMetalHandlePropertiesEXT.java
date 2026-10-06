package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryMetalHandlePropertiesEXT} and {@link VkMemoryMetalHandlePropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryMetalHandlePropertiesEXT
    extends IPointer
    permits VkMemoryMetalHandlePropertiesEXT, VkMemoryMetalHandlePropertiesEXT.Ptr
{}
