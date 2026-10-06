package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubpassSampleLocationsEXT} and {@link VkSubpassSampleLocationsEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubpassSampleLocationsEXT
    extends IPointer
    permits VkSubpassSampleLocationsEXT, VkSubpassSampleLocationsEXT.Ptr
{}
