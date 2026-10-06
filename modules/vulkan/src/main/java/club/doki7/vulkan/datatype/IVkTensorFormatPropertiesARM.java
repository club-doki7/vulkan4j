package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTensorFormatPropertiesARM} and {@link VkTensorFormatPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTensorFormatPropertiesARM
    extends IPointer
    permits VkTensorFormatPropertiesARM, VkTensorFormatPropertiesARM.Ptr
{}
