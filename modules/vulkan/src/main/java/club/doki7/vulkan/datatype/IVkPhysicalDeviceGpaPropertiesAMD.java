package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceGpaPropertiesAMD} and {@link VkPhysicalDeviceGpaPropertiesAMD.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceGpaPropertiesAMD
    extends IPointer
    permits VkPhysicalDeviceGpaPropertiesAMD, VkPhysicalDeviceGpaPropertiesAMD.Ptr
{}
