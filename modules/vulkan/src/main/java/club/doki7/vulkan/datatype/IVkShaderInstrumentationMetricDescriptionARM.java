package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShaderInstrumentationMetricDescriptionARM} and {@link VkShaderInstrumentationMetricDescriptionARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShaderInstrumentationMetricDescriptionARM
    extends IPointer
    permits VkShaderInstrumentationMetricDescriptionARM, VkShaderInstrumentationMetricDescriptionARM.Ptr
{}
