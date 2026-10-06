package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShaderStatisticsInfoAMD} and {@link VkShaderStatisticsInfoAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShaderStatisticsInfoAMD
    extends IPointer
    permits VkShaderStatisticsInfoAMD, VkShaderStatisticsInfoAMD.Ptr
{}
