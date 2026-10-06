package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDispatchTileInfoQCOM} and {@link VkDispatchTileInfoQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDispatchTileInfoQCOM
    extends IPointer
    permits VkDispatchTileInfoQCOM, VkDispatchTileInfoQCOM.Ptr
{}
