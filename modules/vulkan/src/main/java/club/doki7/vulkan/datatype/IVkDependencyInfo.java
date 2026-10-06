package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDependencyInfo} and {@link VkDependencyInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDependencyInfo
    extends IPointer
    permits VkDependencyInfo, VkDependencyInfo.Ptr
{}
