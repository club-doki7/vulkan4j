package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplaySurfaceStereoCreateInfoNV} and {@link VkDisplaySurfaceStereoCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplaySurfaceStereoCreateInfoNV
    extends IPointer
    permits VkDisplaySurfaceStereoCreateInfoNV, VkDisplaySurfaceStereoCreateInfoNV.Ptr
{}
