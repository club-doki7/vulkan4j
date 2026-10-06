package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkNativeBufferFormatPropertiesOHOS} and {@link VkNativeBufferFormatPropertiesOHOS.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkNativeBufferFormatPropertiesOHOS
    extends IPointer
    permits VkNativeBufferFormatPropertiesOHOS, VkNativeBufferFormatPropertiesOHOS.Ptr
{}
