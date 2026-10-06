package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportAndroidHardwareBufferInfoANDROID} and {@link VkImportAndroidHardwareBufferInfoANDROID.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportAndroidHardwareBufferInfoANDROID
    extends IPointer
    permits VkImportAndroidHardwareBufferInfoANDROID, VkImportAndroidHardwareBufferInfoANDROID.Ptr
{}
