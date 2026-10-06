package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryHostPointerPropertiesEXT} and {@link VkMemoryHostPointerPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryHostPointerPropertiesEXT
    extends IPointer
    permits VkMemoryHostPointerPropertiesEXT, VkMemoryHostPointerPropertiesEXT.Ptr
{}
