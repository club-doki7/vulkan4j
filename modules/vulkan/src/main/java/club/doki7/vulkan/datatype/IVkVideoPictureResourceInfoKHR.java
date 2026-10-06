package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoPictureResourceInfoKHR} and {@link VkVideoPictureResourceInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoPictureResourceInfoKHR
    extends IPointer
    permits VkVideoPictureResourceInfoKHR, VkVideoPictureResourceInfoKHR.Ptr
{}
