package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceHostQueryResetFeatures} and {@link VkPhysicalDeviceHostQueryResetFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceHostQueryResetFeatures
    extends IPointer
    permits VkPhysicalDeviceHostQueryResetFeatures, VkPhysicalDeviceHostQueryResetFeatures.Ptr
{}
