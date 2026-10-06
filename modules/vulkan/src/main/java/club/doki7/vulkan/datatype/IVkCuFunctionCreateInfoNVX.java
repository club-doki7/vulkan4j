package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCuFunctionCreateInfoNVX} and {@link VkCuFunctionCreateInfoNVX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCuFunctionCreateInfoNVX
    extends IPointer
    permits VkCuFunctionCreateInfoNVX, VkCuFunctionCreateInfoNVX.Ptr
{}
