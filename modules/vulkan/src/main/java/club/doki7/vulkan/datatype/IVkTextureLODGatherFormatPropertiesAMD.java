package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTextureLODGatherFormatPropertiesAMD} and {@link VkTextureLODGatherFormatPropertiesAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTextureLODGatherFormatPropertiesAMD
    extends IPointer
    permits VkTextureLODGatherFormatPropertiesAMD, VkTextureLODGatherFormatPropertiesAMD.Ptr
{}
