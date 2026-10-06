package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCudaModuleCreateInfoNV} and {@link VkCudaModuleCreateInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCudaModuleCreateInfoNV
    extends IPointer
    permits VkCudaModuleCreateInfoNV, VkCudaModuleCreateInfoNV.Ptr
{}
