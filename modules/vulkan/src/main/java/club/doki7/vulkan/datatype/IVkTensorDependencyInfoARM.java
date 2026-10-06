package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTensorDependencyInfoARM} and {@link VkTensorDependencyInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTensorDependencyInfoARM
    extends IPointer
    permits VkTensorDependencyInfoARM, VkTensorDependencyInfoARM.Ptr
{}
