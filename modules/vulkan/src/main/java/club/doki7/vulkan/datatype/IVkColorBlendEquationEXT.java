package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkColorBlendEquationEXT} and {@link VkColorBlendEquationEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkColorBlendEquationEXT
    extends IPointer
    permits VkColorBlendEquationEXT, VkColorBlendEquationEXT.Ptr
{}
