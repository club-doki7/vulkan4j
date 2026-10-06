package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceGroupBindSparseInfo} and {@link VkDeviceGroupBindSparseInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceGroupBindSparseInfo
    extends IPointer
    permits VkDeviceGroupBindSparseInfo, VkDeviceGroupBindSparseInfo.Ptr
{}
