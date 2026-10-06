package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkLayerSettingsCreateInfoEXT} and {@link VkLayerSettingsCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkLayerSettingsCreateInfoEXT
    extends IPointer
    permits VkLayerSettingsCreateInfoEXT, VkLayerSettingsCreateInfoEXT.Ptr
{}
