package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPerTileBeginInfoQCOM} and {@link VkPerTileBeginInfoQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPerTileBeginInfoQCOM
    extends IPointer
    permits VkPerTileBeginInfoQCOM, VkPerTileBeginInfoQCOM.Ptr
{}
