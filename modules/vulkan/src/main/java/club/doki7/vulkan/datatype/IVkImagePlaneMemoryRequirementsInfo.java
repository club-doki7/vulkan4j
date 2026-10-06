package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImagePlaneMemoryRequirementsInfo} and {@link VkImagePlaneMemoryRequirementsInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImagePlaneMemoryRequirementsInfo
    extends IPointer
    permits VkImagePlaneMemoryRequirementsInfo, VkImagePlaneMemoryRequirementsInfo.Ptr
{}
