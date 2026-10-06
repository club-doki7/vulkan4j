package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCuLaunchInfoNVX} and {@link VkCuLaunchInfoNVX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCuLaunchInfoNVX
    extends IPointer
    permits VkCuLaunchInfoNVX, VkCuLaunchInfoNVX.Ptr
{}
