package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalFenceProperties} and {@link VkExternalFenceProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalFenceProperties
    extends IPointer
    permits VkExternalFenceProperties, VkExternalFenceProperties.Ptr
{}
