package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCudaFunctionCreateInfoNV} and {@link VkCudaFunctionCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCudaFunctionCreateInfoNV
    extends IPointer
    permits VkCudaFunctionCreateInfoNV, VkCudaFunctionCreateInfoNV.Ptr
{}
