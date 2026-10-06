package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSparseProperties} and {@link VkPhysicalDeviceSparseProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSparseProperties
    extends IPointer
    permits VkPhysicalDeviceSparseProperties, VkPhysicalDeviceSparseProperties.Ptr
{}
