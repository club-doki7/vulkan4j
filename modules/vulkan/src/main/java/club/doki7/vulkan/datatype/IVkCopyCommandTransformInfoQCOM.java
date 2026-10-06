package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCopyCommandTransformInfoQCOM} and {@link VkCopyCommandTransformInfoQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCopyCommandTransformInfoQCOM
    extends IPointer
    permits VkCopyCommandTransformInfoQCOM, VkCopyCommandTransformInfoQCOM.Ptr
{}
