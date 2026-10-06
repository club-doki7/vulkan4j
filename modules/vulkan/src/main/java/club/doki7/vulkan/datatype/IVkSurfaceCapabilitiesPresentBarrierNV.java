package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfaceCapabilitiesPresentBarrierNV} and {@link VkSurfaceCapabilitiesPresentBarrierNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfaceCapabilitiesPresentBarrierNV
    extends IPointer
    permits VkSurfaceCapabilitiesPresentBarrierNV, VkSurfaceCapabilitiesPresentBarrierNV.Ptr
{}
