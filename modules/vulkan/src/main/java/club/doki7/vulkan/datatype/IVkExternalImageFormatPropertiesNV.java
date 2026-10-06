package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalImageFormatPropertiesNV} and {@link VkExternalImageFormatPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalImageFormatPropertiesNV
    extends IPointer
    permits VkExternalImageFormatPropertiesNV, VkExternalImageFormatPropertiesNV.Ptr
{}
