package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryGetNativeBufferInfoOHOS} and {@link VkMemoryGetNativeBufferInfoOHOS.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryGetNativeBufferInfoOHOS
    extends IPointer
    permits VkMemoryGetNativeBufferInfoOHOS, VkMemoryGetNativeBufferInfoOHOS.Ptr
{}
