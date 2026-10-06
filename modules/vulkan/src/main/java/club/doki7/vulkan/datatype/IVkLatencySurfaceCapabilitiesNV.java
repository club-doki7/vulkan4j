package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkLatencySurfaceCapabilitiesNV} and {@link VkLatencySurfaceCapabilitiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkLatencySurfaceCapabilitiesNV
    extends IPointer
    permits VkLatencySurfaceCapabilitiesNV, VkLatencySurfaceCapabilitiesNV.Ptr
{}
