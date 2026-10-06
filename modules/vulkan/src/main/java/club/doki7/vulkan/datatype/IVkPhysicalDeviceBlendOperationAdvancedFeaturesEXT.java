package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT} and {@link VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceBlendOperationAdvancedFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT, VkPhysicalDeviceBlendOperationAdvancedFeaturesEXT.Ptr
{}
