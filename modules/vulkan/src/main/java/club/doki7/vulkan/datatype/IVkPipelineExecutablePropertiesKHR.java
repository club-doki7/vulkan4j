package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineExecutablePropertiesKHR} and {@link VkPipelineExecutablePropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineExecutablePropertiesKHR
    extends IPointer
    permits VkPipelineExecutablePropertiesKHR, VkPipelineExecutablePropertiesKHR.Ptr
{}
