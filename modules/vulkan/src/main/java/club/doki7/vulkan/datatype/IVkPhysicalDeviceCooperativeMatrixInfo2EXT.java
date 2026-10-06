package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceCooperativeMatrixInfo2EXT} and {@link VkPhysicalDeviceCooperativeMatrixInfo2EXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceCooperativeMatrixInfo2EXT
    extends IPointer
    permits VkPhysicalDeviceCooperativeMatrixInfo2EXT, VkPhysicalDeviceCooperativeMatrixInfo2EXT.Ptr
{}
