package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkNativeBufferPropertiesOHOS} and {@link VkNativeBufferPropertiesOHOS.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkNativeBufferPropertiesOHOS
    extends IPointer
    permits VkNativeBufferPropertiesOHOS, VkNativeBufferPropertiesOHOS.Ptr
{}
