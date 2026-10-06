package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineExecutableStatisticValueKHR} and {@link VkPipelineExecutableStatisticValueKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineExecutableStatisticValueKHR
    extends IPointer
    permits VkPipelineExecutableStatisticValueKHR, VkPipelineExecutableStatisticValueKHR.Ptr
{}
