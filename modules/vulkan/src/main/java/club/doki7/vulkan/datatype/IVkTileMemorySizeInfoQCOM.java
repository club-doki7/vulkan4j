package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTileMemorySizeInfoQCOM} and {@link VkTileMemorySizeInfoQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTileMemorySizeInfoQCOM
    extends IPointer
    permits VkTileMemorySizeInfoQCOM, VkTileMemorySizeInfoQCOM.Ptr
{}
