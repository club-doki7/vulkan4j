package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAntiLagPresentationInfoAMD} and {@link VkAntiLagPresentationInfoAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAntiLagPresentationInfoAMD
    extends IPointer
    permits VkAntiLagPresentationInfoAMD, VkAntiLagPresentationInfoAMD.Ptr
{}
