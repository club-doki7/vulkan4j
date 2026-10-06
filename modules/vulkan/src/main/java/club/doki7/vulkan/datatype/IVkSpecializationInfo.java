package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSpecializationInfo} and {@link VkSpecializationInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSpecializationInfo
    extends IPointer
    permits VkSpecializationInfo, VkSpecializationInfo.Ptr
{}
