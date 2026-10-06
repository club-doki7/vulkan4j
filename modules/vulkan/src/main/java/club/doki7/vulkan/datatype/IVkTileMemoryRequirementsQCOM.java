package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkTileMemoryRequirementsQCOM} and {@link VkTileMemoryRequirementsQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkTileMemoryRequirementsQCOM
    extends IPointer
    permits VkTileMemoryRequirementsQCOM, VkTileMemoryRequirementsQCOM.Ptr
{}
