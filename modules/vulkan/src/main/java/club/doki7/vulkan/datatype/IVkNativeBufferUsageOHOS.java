package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkNativeBufferUsageOHOS} and {@link VkNativeBufferUsageOHOS.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkNativeBufferUsageOHOS
    extends IPointer
    permits VkNativeBufferUsageOHOS, VkNativeBufferUsageOHOS.Ptr
{}
