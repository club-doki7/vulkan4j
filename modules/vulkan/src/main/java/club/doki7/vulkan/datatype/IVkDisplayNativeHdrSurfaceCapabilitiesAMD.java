package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDisplayNativeHdrSurfaceCapabilitiesAMD} and {@link VkDisplayNativeHdrSurfaceCapabilitiesAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDisplayNativeHdrSurfaceCapabilitiesAMD
    extends IPointer
    permits VkDisplayNativeHdrSurfaceCapabilitiesAMD, VkDisplayNativeHdrSurfaceCapabilitiesAMD.Ptr
{}
