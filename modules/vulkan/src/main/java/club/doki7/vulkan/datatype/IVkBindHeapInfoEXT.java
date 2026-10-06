package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindHeapInfoEXT} and {@link VkBindHeapInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindHeapInfoEXT
    extends IPointer
    permits VkBindHeapInfoEXT, VkBindHeapInfoEXT.Ptr
{}
