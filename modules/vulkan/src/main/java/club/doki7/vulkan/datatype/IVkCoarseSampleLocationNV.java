package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCoarseSampleLocationNV} and {@link VkCoarseSampleLocationNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCoarseSampleLocationNV
    extends IPointer
    permits VkCoarseSampleLocationNV, VkCoarseSampleLocationNV.Ptr
{}
