package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTileMemoryBindInfoQCOM} and {@link VkTileMemoryBindInfoQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTileMemoryBindInfoQCOM
    extends IPointer
    permits VkTileMemoryBindInfoQCOM, VkTileMemoryBindInfoQCOM.Ptr
{}
