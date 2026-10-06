package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSampleLocationEXT} and {@link VkSampleLocationEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSampleLocationEXT
    extends IPointer
    permits VkSampleLocationEXT, VkSampleLocationEXT.Ptr
{}
