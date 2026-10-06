package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDebugMarkerObjectTagInfoEXT} and {@link VkDebugMarkerObjectTagInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDebugMarkerObjectTagInfoEXT
    extends IPointer
    permits VkDebugMarkerObjectTagInfoEXT, VkDebugMarkerObjectTagInfoEXT.Ptr
{}
