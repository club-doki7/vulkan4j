package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDispatchParametersARM} and {@link VkDispatchParametersARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDispatchParametersARM
    extends IPointer
    permits VkDispatchParametersARM, VkDispatchParametersARM.Ptr
{}
