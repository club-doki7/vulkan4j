package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceMemoryOverallocationCreateInfoAMD} and {@link VkDeviceMemoryOverallocationCreateInfoAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceMemoryOverallocationCreateInfoAMD
    extends IPointer
    permits VkDeviceMemoryOverallocationCreateInfoAMD, VkDeviceMemoryOverallocationCreateInfoAMD.Ptr
{}
