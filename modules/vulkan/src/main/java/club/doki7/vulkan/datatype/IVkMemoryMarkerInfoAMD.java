package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMemoryMarkerInfoAMD} and {@link VkMemoryMarkerInfoAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMemoryMarkerInfoAMD
    extends IPointer
    permits VkMemoryMarkerInfoAMD, VkMemoryMarkerInfoAMD.Ptr
{}
