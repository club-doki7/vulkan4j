package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayPlaneInfo2KHR} and {@link VkDisplayPlaneInfo2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayPlaneInfo2KHR
    extends IPointer
    permits VkDisplayPlaneInfo2KHR, VkDisplayPlaneInfo2KHR.Ptr
{}
