package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTilePropertiesQCOM} and {@link VkTilePropertiesQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTilePropertiesQCOM
    extends IPointer
    permits VkTilePropertiesQCOM, VkTilePropertiesQCOM.Ptr
{}
