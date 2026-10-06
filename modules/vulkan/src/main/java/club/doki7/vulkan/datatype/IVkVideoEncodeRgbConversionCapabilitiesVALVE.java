package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeRgbConversionCapabilitiesVALVE} and {@link VkVideoEncodeRgbConversionCapabilitiesVALVE.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeRgbConversionCapabilitiesVALVE
    extends IPointer
    permits VkVideoEncodeRgbConversionCapabilitiesVALVE, VkVideoEncodeRgbConversionCapabilitiesVALVE.Ptr
{}
