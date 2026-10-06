package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineSampleLocationsStateCreateInfoEXT} and {@link VkPipelineSampleLocationsStateCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineSampleLocationsStateCreateInfoEXT
    extends IPointer
    permits VkPipelineSampleLocationsStateCreateInfoEXT, VkPipelineSampleLocationsStateCreateInfoEXT.Ptr
{}
