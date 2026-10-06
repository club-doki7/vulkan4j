package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassStripeBeginInfoARM} and {@link VkRenderPassStripeBeginInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassStripeBeginInfoARM
    extends IPointer
    permits VkRenderPassStripeBeginInfoARM, VkRenderPassStripeBeginInfoARM.Ptr
{}
