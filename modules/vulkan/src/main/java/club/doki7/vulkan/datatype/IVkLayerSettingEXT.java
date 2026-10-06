package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkLayerSettingEXT} and {@link VkLayerSettingEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkLayerSettingEXT
    extends IPointer
    permits VkLayerSettingEXT, VkLayerSettingEXT.Ptr
{}
