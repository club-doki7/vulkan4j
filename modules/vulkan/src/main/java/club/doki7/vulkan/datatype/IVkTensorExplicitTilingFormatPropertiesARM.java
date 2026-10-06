package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTensorExplicitTilingFormatPropertiesARM} and {@link VkTensorExplicitTilingFormatPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTensorExplicitTilingFormatPropertiesARM
    extends IPointer
    permits VkTensorExplicitTilingFormatPropertiesARM, VkTensorExplicitTilingFormatPropertiesARM.Ptr
{}
