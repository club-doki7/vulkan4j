package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCuModuleCreateInfoNVX} and {@link VkCuModuleCreateInfoNVX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCuModuleCreateInfoNVX
    extends IPointer
    permits VkCuModuleCreateInfoNVX, VkCuModuleCreateInfoNVX.Ptr
{}
