package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineExecutableInternalRepresentationKHR} and {@link VkPipelineExecutableInternalRepresentationKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineExecutableInternalRepresentationKHR
    extends IPointer
    permits VkPipelineExecutableInternalRepresentationKHR, VkPipelineExecutableInternalRepresentationKHR.Ptr
{}
