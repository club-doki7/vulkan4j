package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryWin32HandlePropertiesKHR} and {@link VkMemoryWin32HandlePropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryWin32HandlePropertiesKHR
    extends IPointer
    permits VkMemoryWin32HandlePropertiesKHR, VkMemoryWin32HandlePropertiesKHR.Ptr
{}
