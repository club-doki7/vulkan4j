package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubpassDependency} and {@link VkSubpassDependency.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubpassDependency
    extends IPointer
    permits VkSubpassDependency, VkSubpassDependency.Ptr
{}
