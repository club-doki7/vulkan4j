package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkRenderPassStripeInfoARM} and {@link VkRenderPassStripeInfoARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkRenderPassStripeInfoARM
    extends IPointer
    permits VkRenderPassStripeInfoARM, VkRenderPassStripeInfoARM.Ptr
{}
