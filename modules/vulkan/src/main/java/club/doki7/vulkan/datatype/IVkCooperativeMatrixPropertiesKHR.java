package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCooperativeMatrixPropertiesKHR} and {@link VkCooperativeMatrixPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCooperativeMatrixPropertiesKHR
    extends IPointer
    permits VkCooperativeMatrixPropertiesKHR, VkCooperativeMatrixPropertiesKHR.Ptr
{}
