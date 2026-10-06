package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkProtectedSubmitInfo} and {@link VkProtectedSubmitInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkProtectedSubmitInfo
    extends IPointer
    permits VkProtectedSubmitInfo, VkProtectedSubmitInfo.Ptr
{}
