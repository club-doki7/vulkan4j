package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceFullScreenExclusiveWin32InfoEXT} and {@link VkSurfaceFullScreenExclusiveWin32InfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceFullScreenExclusiveWin32InfoEXT
    extends IPointer
    permits VkSurfaceFullScreenExclusiveWin32InfoEXT, VkSurfaceFullScreenExclusiveWin32InfoEXT.Ptr
{}
