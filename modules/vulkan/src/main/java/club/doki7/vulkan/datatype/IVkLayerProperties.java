package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkLayerProperties} and {@link VkLayerProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkLayerProperties
    extends IPointer
    permits VkLayerProperties, VkLayerProperties.Ptr
{}
