package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDataGraphOperationSupportARM} and {@link VkPhysicalDeviceDataGraphOperationSupportARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDataGraphOperationSupportARM
    extends IPointer
    permits VkPhysicalDeviceDataGraphOperationSupportARM, VkPhysicalDeviceDataGraphOperationSupportARM.Ptr
{}
