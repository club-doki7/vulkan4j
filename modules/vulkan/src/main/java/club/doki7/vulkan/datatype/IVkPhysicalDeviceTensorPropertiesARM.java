package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceTensorPropertiesARM} and {@link VkPhysicalDeviceTensorPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceTensorPropertiesARM
    extends IPointer
    permits VkPhysicalDeviceTensorPropertiesARM, VkPhysicalDeviceTensorPropertiesARM.Ptr
{}
