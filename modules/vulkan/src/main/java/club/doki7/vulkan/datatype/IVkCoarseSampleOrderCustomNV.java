package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCoarseSampleOrderCustomNV} and {@link VkCoarseSampleOrderCustomNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCoarseSampleOrderCustomNV
    extends IPointer
    permits VkCoarseSampleOrderCustomNV, VkCoarseSampleOrderCustomNV.Ptr
{}
