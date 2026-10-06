package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineExecutableInfoKHR} and {@link VkPipelineExecutableInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineExecutableInfoKHR
    extends IPointer
    permits VkPipelineExecutableInfoKHR, VkPipelineExecutableInfoKHR.Ptr
{}
