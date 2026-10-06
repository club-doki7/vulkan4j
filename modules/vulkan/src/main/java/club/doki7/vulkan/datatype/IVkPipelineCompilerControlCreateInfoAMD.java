package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineCompilerControlCreateInfoAMD} and {@link VkPipelineCompilerControlCreateInfoAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineCompilerControlCreateInfoAMD
    extends IPointer
    permits VkPipelineCompilerControlCreateInfoAMD, VkPipelineCompilerControlCreateInfoAMD.Ptr
{}
