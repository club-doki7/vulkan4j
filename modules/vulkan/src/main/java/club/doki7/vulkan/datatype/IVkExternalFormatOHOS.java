package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalFormatOHOS} and {@link VkExternalFormatOHOS.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalFormatOHOS
    extends IPointer
    permits VkExternalFormatOHOS, VkExternalFormatOHOS.Ptr
{}
