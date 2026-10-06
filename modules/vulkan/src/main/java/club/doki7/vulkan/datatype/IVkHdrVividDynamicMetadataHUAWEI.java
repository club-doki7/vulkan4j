package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkHdrVividDynamicMetadataHUAWEI} and {@link VkHdrVividDynamicMetadataHUAWEI.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkHdrVividDynamicMetadataHUAWEI
    extends IPointer
    permits VkHdrVividDynamicMetadataHUAWEI, VkHdrVividDynamicMetadataHUAWEI.Ptr
{}
