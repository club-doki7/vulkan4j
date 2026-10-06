package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGpaPerfBlockPropertiesAMD} and {@link VkGpaPerfBlockPropertiesAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGpaPerfBlockPropertiesAMD
    extends IPointer
    permits VkGpaPerfBlockPropertiesAMD, VkGpaPerfBlockPropertiesAMD.Ptr
{}
