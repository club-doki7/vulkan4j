package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAndroidHardwareBufferUsageANDROID} and {@link VkAndroidHardwareBufferUsageANDROID.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAndroidHardwareBufferUsageANDROID
    extends IPointer
    permits VkAndroidHardwareBufferUsageANDROID, VkAndroidHardwareBufferUsageANDROID.Ptr
{}
