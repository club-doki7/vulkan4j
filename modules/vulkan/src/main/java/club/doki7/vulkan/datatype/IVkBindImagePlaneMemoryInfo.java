package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindImagePlaneMemoryInfo} and {@link VkBindImagePlaneMemoryInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindImagePlaneMemoryInfo
    extends IPointer
    permits VkBindImagePlaneMemoryInfo, VkBindImagePlaneMemoryInfo.Ptr
{}
