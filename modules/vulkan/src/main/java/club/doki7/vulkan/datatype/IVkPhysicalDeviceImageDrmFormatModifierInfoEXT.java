package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT} and {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceImageDrmFormatModifierInfoEXT
    extends IPointer
    permits VkPhysicalDeviceImageDrmFormatModifierInfoEXT, VkPhysicalDeviceImageDrmFormatModifierInfoEXT.Ptr
{}
