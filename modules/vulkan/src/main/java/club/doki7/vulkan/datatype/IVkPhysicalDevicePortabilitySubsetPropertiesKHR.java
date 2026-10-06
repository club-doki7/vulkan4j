package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePortabilitySubsetPropertiesKHR} and {@link VkPhysicalDevicePortabilitySubsetPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePortabilitySubsetPropertiesKHR
    extends IPointer
    permits VkPhysicalDevicePortabilitySubsetPropertiesKHR, VkPhysicalDevicePortabilitySubsetPropertiesKHR.Ptr
{}
