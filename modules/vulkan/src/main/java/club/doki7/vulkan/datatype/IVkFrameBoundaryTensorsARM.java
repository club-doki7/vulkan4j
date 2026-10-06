package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkFrameBoundaryTensorsARM} and {@link VkFrameBoundaryTensorsARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkFrameBoundaryTensorsARM
    extends IPointer
    permits VkFrameBoundaryTensorsARM, VkFrameBoundaryTensorsARM.Ptr
{}
