package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSysmemColorSpaceFUCHSIA} and {@link VkSysmemColorSpaceFUCHSIA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSysmemColorSpaceFUCHSIA
    extends IPointer
    permits VkSysmemColorSpaceFUCHSIA, VkSysmemColorSpaceFUCHSIA.Ptr
{}
