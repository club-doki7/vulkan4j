package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceFaultDebugInfoKHR} and {@link VkDeviceFaultDebugInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceFaultDebugInfoKHR
    extends IPointer
    permits VkDeviceFaultDebugInfoKHR, VkDeviceFaultDebugInfoKHR.Ptr
{}
