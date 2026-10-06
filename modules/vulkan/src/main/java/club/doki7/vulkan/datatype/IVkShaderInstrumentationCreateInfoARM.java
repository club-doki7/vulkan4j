package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShaderInstrumentationCreateInfoARM} and {@link VkShaderInstrumentationCreateInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShaderInstrumentationCreateInfoARM
    extends IPointer
    permits VkShaderInstrumentationCreateInfoARM, VkShaderInstrumentationCreateInfoARM.Ptr
{}
