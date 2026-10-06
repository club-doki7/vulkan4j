package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPrivateDataSlotCreateInfo} and {@link VkPrivateDataSlotCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPrivateDataSlotCreateInfo
    extends IPointer
    permits VkPrivateDataSlotCreateInfo, VkPrivateDataSlotCreateInfo.Ptr
{}
