package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainCalibratedTimestampInfoEXT} and {@link VkSwapchainCalibratedTimestampInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainCalibratedTimestampInfoEXT
    extends IPointer
    permits VkSwapchainCalibratedTimestampInfoEXT, VkSwapchainCalibratedTimestampInfoEXT.Ptr
{}
