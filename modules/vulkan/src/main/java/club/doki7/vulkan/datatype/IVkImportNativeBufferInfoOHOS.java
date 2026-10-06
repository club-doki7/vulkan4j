package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkImportNativeBufferInfoOHOS} and {@link VkImportNativeBufferInfoOHOS.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkImportNativeBufferInfoOHOS
    extends IPointer
    permits VkImportNativeBufferInfoOHOS, VkImportNativeBufferInfoOHOS.Ptr
{}
