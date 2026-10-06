package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayPowerInfoEXT} and {@link VkDisplayPowerInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayPowerInfoEXT
    extends IPointer
    permits VkDisplayPowerInfoEXT, VkDisplayPowerInfoEXT.Ptr
{}
