package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkGpaSampleBeginInfoAMD} and {@link VkGpaSampleBeginInfoAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkGpaSampleBeginInfoAMD
    extends IPointer
    permits VkGpaSampleBeginInfoAMD, VkGpaSampleBeginInfoAMD.Ptr
{}
