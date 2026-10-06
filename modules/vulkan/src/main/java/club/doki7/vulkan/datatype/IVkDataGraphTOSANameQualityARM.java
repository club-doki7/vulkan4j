package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDataGraphTOSANameQualityARM} and {@link VkDataGraphTOSANameQualityARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDataGraphTOSANameQualityARM
    extends IPointer
    permits VkDataGraphTOSANameQualityARM, VkDataGraphTOSANameQualityARM.Ptr
{}
