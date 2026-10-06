package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayPlaneProperties2KHR} and {@link VkDisplayPlaneProperties2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayPlaneProperties2KHR
    extends IPointer
    permits VkDisplayPlaneProperties2KHR, VkDisplayPlaneProperties2KHR.Ptr
{}
