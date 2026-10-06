package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkAntiLagDataAMD} and {@link VkAntiLagDataAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkAntiLagDataAMD
    extends IPointer
    permits VkAntiLagDataAMD, VkAntiLagDataAMD.Ptr
{}
