package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerfHintInfoQCOM} and {@link VkPerfHintInfoQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerfHintInfoQCOM
    extends IPointer
    permits VkPerfHintInfoQCOM, VkPerfHintInfoQCOM.Ptr
{}
