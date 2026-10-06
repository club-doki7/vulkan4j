package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDirectDriverLoadingInfoLUNARG} and {@link VkDirectDriverLoadingInfoLUNARG.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDirectDriverLoadingInfoLUNARG
    extends IPointer
    permits VkDirectDriverLoadingInfoLUNARG, VkDirectDriverLoadingInfoLUNARG.Ptr
{}
