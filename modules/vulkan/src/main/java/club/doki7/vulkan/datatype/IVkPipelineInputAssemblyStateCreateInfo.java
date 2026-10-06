package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineInputAssemblyStateCreateInfo} and {@link VkPipelineInputAssemblyStateCreateInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineInputAssemblyStateCreateInfo
    extends IPointer
    permits VkPipelineInputAssemblyStateCreateInfo, VkPipelineInputAssemblyStateCreateInfo.Ptr
{}
