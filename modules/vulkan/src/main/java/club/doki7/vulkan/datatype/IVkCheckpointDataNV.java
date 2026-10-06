package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCheckpointDataNV} and {@link VkCheckpointDataNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCheckpointDataNV
    extends IPointer
    permits VkCheckpointDataNV, VkCheckpointDataNV.Ptr
{}
