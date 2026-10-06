package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubpassDependency2} and {@link VkSubpassDependency2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubpassDependency2
    extends IPointer
    permits VkSubpassDependency2, VkSubpassDependency2.Ptr
{}
