package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkStencilOpState} and {@link VkStencilOpState.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkStencilOpState
    extends IPointer
    permits VkStencilOpState, VkStencilOpState.Ptr
{}
