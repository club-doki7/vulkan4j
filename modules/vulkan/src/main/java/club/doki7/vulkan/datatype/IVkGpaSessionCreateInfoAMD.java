package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGpaSessionCreateInfoAMD} and {@link VkGpaSessionCreateInfoAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGpaSessionCreateInfoAMD
    extends IPointer
    permits VkGpaSessionCreateInfoAMD, VkGpaSessionCreateInfoAMD.Ptr
{}
