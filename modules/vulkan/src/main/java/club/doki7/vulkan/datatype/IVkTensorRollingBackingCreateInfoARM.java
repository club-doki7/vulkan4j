package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTensorRollingBackingCreateInfoARM} and {@link VkTensorRollingBackingCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTensorRollingBackingCreateInfoARM
    extends IPointer
    permits VkTensorRollingBackingCreateInfoARM, VkTensorRollingBackingCreateInfoARM.Ptr
{}
