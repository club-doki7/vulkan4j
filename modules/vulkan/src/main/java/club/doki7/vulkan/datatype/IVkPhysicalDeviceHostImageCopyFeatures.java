package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceHostImageCopyFeatures} and {@link VkPhysicalDeviceHostImageCopyFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceHostImageCopyFeatures
    extends IPointer
    permits VkPhysicalDeviceHostImageCopyFeatures, VkPhysicalDeviceHostImageCopyFeatures.Ptr
{}
