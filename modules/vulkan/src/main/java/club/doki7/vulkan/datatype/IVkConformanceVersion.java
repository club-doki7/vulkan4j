package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkConformanceVersion} and {@link VkConformanceVersion.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkConformanceVersion
    extends IPointer
    permits VkConformanceVersion, VkConformanceVersion.Ptr
{}
