package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePrimitiveRestartIndexFeaturesEXT} and {@link VkPhysicalDevicePrimitiveRestartIndexFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePrimitiveRestartIndexFeaturesEXT
    extends IPointer
    permits VkPhysicalDevicePrimitiveRestartIndexFeaturesEXT, VkPhysicalDevicePrimitiveRestartIndexFeaturesEXT.Ptr
{}
