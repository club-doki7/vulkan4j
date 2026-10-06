package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphOpticalFlowImageFormatInfoARM} and {@link VkDataGraphOpticalFlowImageFormatInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphOpticalFlowImageFormatInfoARM
    extends IPointer
    permits VkDataGraphOpticalFlowImageFormatInfoARM, VkDataGraphOpticalFlowImageFormatInfoARM.Ptr
{}
