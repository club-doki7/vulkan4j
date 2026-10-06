package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCooperativeMatrixPropertiesNV} and {@link VkCooperativeMatrixPropertiesNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCooperativeMatrixPropertiesNV
    extends IPointer
    permits VkCooperativeMatrixPropertiesNV, VkCooperativeMatrixPropertiesNV.Ptr
{}
