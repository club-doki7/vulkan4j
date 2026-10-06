package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDirectDriverLoadingListLUNARG} and {@link VkDirectDriverLoadingListLUNARG.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDirectDriverLoadingListLUNARG
    extends IPointer
    permits VkDirectDriverLoadingListLUNARG, VkDirectDriverLoadingListLUNARG.Ptr
{}
