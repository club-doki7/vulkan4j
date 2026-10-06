package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkShaderResourceUsageAMD} and {@link VkShaderResourceUsageAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkShaderResourceUsageAMD
    extends IPointer
    permits VkShaderResourceUsageAMD, VkShaderResourceUsageAMD.Ptr
{}
