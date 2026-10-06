package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkApplicationInfo} and {@link VkApplicationInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkApplicationInfo
    extends IPointer
    permits VkApplicationInfo, VkApplicationInfo.Ptr
{}
