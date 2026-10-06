package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayModeProperties2KHR} and {@link VkDisplayModeProperties2KHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayModeProperties2KHR
    extends IPointer
    permits VkDisplayModeProperties2KHR, VkDisplayModeProperties2KHR.Ptr
{}
