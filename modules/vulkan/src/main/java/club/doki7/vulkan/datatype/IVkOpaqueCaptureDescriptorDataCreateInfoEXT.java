package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkOpaqueCaptureDescriptorDataCreateInfoEXT} and {@link VkOpaqueCaptureDescriptorDataCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkOpaqueCaptureDescriptorDataCreateInfoEXT
    extends IPointer
    permits VkOpaqueCaptureDescriptorDataCreateInfoEXT, VkOpaqueCaptureDescriptorDataCreateInfoEXT.Ptr
{}
