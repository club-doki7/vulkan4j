package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAndroidHardwareBufferPropertiesANDROID} and {@link VkAndroidHardwareBufferPropertiesANDROID.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAndroidHardwareBufferPropertiesANDROID
    extends IPointer
    permits VkAndroidHardwareBufferPropertiesANDROID, VkAndroidHardwareBufferPropertiesANDROID.Ptr
{}
