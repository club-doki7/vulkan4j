package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSubpassDescription2} and {@link VkSubpassDescription2.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSubpassDescription2
    extends IPointer
    permits VkSubpassDescription2, VkSubpassDescription2.Ptr
{}
