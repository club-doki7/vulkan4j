package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCooperativeMatrixProperties2EXT} and {@link VkCooperativeMatrixProperties2EXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCooperativeMatrixProperties2EXT
    extends IPointer
    permits VkCooperativeMatrixProperties2EXT, VkCooperativeMatrixProperties2EXT.Ptr
{}
