package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAndroidHardwareBufferFormatPropertiesANDROID} and {@link VkAndroidHardwareBufferFormatPropertiesANDROID.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAndroidHardwareBufferFormatPropertiesANDROID
    extends IPointer
    permits VkAndroidHardwareBufferFormatPropertiesANDROID, VkAndroidHardwareBufferFormatPropertiesANDROID.Ptr
{}
