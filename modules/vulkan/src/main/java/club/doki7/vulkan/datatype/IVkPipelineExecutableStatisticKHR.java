package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineExecutableStatisticKHR} and {@link VkPipelineExecutableStatisticKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineExecutableStatisticKHR
    extends IPointer
    permits VkPipelineExecutableStatisticKHR, VkPipelineExecutableStatisticKHR.Ptr
{}
