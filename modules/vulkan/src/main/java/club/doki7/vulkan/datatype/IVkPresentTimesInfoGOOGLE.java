package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPresentTimesInfoGOOGLE} and {@link VkPresentTimesInfoGOOGLE.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPresentTimesInfoGOOGLE
    extends IPointer
    permits VkPresentTimesInfoGOOGLE, VkPresentTimesInfoGOOGLE.Ptr
{}
