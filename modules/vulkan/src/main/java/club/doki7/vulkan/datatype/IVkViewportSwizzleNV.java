package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkViewportSwizzleNV} and {@link VkViewportSwizzleNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkViewportSwizzleNV
    extends IPointer
    permits VkViewportSwizzleNV, VkViewportSwizzleNV.Ptr
{}
