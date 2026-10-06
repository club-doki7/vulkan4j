package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceFullScreenExclusiveInfoEXT} and {@link VkSurfaceFullScreenExclusiveInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceFullScreenExclusiveInfoEXT
    extends IPointer
    permits VkSurfaceFullScreenExclusiveInfoEXT, VkSurfaceFullScreenExclusiveInfoEXT.Ptr
{}
