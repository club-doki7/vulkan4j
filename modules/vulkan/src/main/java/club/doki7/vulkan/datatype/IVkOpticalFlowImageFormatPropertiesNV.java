package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkOpticalFlowImageFormatPropertiesNV} and {@link VkOpticalFlowImageFormatPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkOpticalFlowImageFormatPropertiesNV
    extends IPointer
    permits VkOpticalFlowImageFormatPropertiesNV, VkOpticalFlowImageFormatPropertiesNV.Ptr
{}
