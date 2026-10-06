package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentTimeGOOGLE} and {@link VkPresentTimeGOOGLE.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentTimeGOOGLE
    extends IPointer
    permits VkPresentTimeGOOGLE, VkPresentTimeGOOGLE.Ptr
{}
