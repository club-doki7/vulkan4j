package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkOpaqueCaptureDataCreateInfoEXT} and {@link VkOpaqueCaptureDataCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkOpaqueCaptureDataCreateInfoEXT
    extends IPointer
    permits VkOpaqueCaptureDataCreateInfoEXT, VkOpaqueCaptureDataCreateInfoEXT.Ptr
{}
