package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerTileEndInfoQCOM} and {@link VkPerTileEndInfoQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerTileEndInfoQCOM
    extends IPointer
    permits VkPerTileEndInfoQCOM, VkPerTileEndInfoQCOM.Ptr
{}
