package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryGetAndroidHardwareBufferInfoANDROID} and {@link VkMemoryGetAndroidHardwareBufferInfoANDROID.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryGetAndroidHardwareBufferInfoANDROID
    extends IPointer
    permits VkMemoryGetAndroidHardwareBufferInfoANDROID, VkMemoryGetAndroidHardwareBufferInfoANDROID.Ptr
{}
