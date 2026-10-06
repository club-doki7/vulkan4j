package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMultiviewPerViewAttributesInfoNVX} and {@link VkMultiviewPerViewAttributesInfoNVX.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMultiviewPerViewAttributesInfoNVX
    extends IPointer
    permits VkMultiviewPerViewAttributesInfoNVX, VkMultiviewPerViewAttributesInfoNVX.Ptr
{}
