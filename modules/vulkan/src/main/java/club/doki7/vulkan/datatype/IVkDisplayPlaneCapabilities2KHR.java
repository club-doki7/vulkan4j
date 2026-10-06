package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayPlaneCapabilities2KHR} and {@link VkDisplayPlaneCapabilities2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayPlaneCapabilities2KHR
    extends IPointer
    permits VkDisplayPlaneCapabilities2KHR, VkDisplayPlaneCapabilities2KHR.Ptr
{}
