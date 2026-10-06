package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSRTDataNV} and {@link VkSRTDataNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSRTDataNV
    extends IPointer
    permits VkSRTDataNV, VkSRTDataNV.Ptr
{}
