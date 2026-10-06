package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceColorWriteEnableFeaturesEXT} and {@link VkPhysicalDeviceColorWriteEnableFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceColorWriteEnableFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceColorWriteEnableFeaturesEXT, VkPhysicalDeviceColorWriteEnableFeaturesEXT.Ptr
{}
