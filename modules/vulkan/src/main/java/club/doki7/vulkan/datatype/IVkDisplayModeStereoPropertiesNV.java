package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayModeStereoPropertiesNV} and {@link VkDisplayModeStereoPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayModeStereoPropertiesNV
    extends IPointer
    permits VkDisplayModeStereoPropertiesNV, VkDisplayModeStereoPropertiesNV.Ptr
{}
