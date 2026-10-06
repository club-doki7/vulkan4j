package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShaderInstrumentationMetricDataHeaderARM} and {@link VkShaderInstrumentationMetricDataHeaderARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShaderInstrumentationMetricDataHeaderARM
    extends IPointer
    permits VkShaderInstrumentationMetricDataHeaderARM, VkShaderInstrumentationMetricDataHeaderARM.Ptr
{}
