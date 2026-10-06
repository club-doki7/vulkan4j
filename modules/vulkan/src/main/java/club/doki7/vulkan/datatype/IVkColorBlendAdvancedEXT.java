package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkColorBlendAdvancedEXT} and {@link VkColorBlendAdvancedEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkColorBlendAdvancedEXT
    extends IPointer
    permits VkColorBlendAdvancedEXT, VkColorBlendAdvancedEXT.Ptr
{}
