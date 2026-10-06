package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphProcessingEngineCreateInfoARM} and {@link VkDataGraphProcessingEngineCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphProcessingEngineCreateInfoARM
    extends IPointer
    permits VkDataGraphProcessingEngineCreateInfoARM, VkDataGraphProcessingEngineCreateInfoARM.Ptr
{}
