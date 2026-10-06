package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSurfacePresentScalingCapabilitiesKHR} and {@link VkSurfacePresentScalingCapabilitiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSurfacePresentScalingCapabilitiesKHR
    extends IPointer
    permits VkSurfacePresentScalingCapabilitiesKHR, VkSurfacePresentScalingCapabilitiesKHR.Ptr
{}
