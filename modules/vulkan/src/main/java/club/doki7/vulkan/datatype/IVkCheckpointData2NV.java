package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCheckpointData2NV} and {@link VkCheckpointData2NV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCheckpointData2NV
    extends IPointer
    permits VkCheckpointData2NV, VkCheckpointData2NV.Ptr
{}
