package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAndroidHardwareBufferFormatProperties2ANDROID} and {@link VkAndroidHardwareBufferFormatProperties2ANDROID.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAndroidHardwareBufferFormatProperties2ANDROID
    extends IPointer
    permits VkAndroidHardwareBufferFormatProperties2ANDROID, VkAndroidHardwareBufferFormatProperties2ANDROID.Ptr
{}
