package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoFormatPropertiesKHR} and {@link VkVideoFormatPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoFormatPropertiesKHR
    extends IPointer
    permits VkVideoFormatPropertiesKHR, VkVideoFormatPropertiesKHR.Ptr
{}
