package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphPipelineSingleNodeCreateInfoARM} and {@link VkDataGraphPipelineSingleNodeCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphPipelineSingleNodeCreateInfoARM
    extends IPointer
    permits VkDataGraphPipelineSingleNodeCreateInfoARM, VkDataGraphPipelineSingleNodeCreateInfoARM.Ptr
{}
