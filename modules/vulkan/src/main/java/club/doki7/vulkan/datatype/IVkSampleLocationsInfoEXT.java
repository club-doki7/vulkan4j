package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSampleLocationsInfoEXT} and {@link VkSampleLocationsInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSampleLocationsInfoEXT
    extends IPointer
    permits VkSampleLocationsInfoEXT, VkSampleLocationsInfoEXT.Ptr
{}
