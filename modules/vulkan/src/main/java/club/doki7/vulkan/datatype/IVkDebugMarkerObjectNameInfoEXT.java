package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDebugMarkerObjectNameInfoEXT} and {@link VkDebugMarkerObjectNameInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDebugMarkerObjectNameInfoEXT
    extends IPointer
    permits VkDebugMarkerObjectNameInfoEXT, VkDebugMarkerObjectNameInfoEXT.Ptr
{}
