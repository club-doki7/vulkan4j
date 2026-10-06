package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkInstanceCreateInfo} and {@link VkInstanceCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkInstanceCreateInfo
    extends IPointer
    permits VkInstanceCreateInfo, VkInstanceCreateInfo.Ptr
{}
