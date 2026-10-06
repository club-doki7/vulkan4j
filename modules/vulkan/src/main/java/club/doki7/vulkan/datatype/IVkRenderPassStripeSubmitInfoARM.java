package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassStripeSubmitInfoARM} and {@link VkRenderPassStripeSubmitInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassStripeSubmitInfoARM
    extends IPointer
    permits VkRenderPassStripeSubmitInfoARM, VkRenderPassStripeSubmitInfoARM.Ptr
{}
