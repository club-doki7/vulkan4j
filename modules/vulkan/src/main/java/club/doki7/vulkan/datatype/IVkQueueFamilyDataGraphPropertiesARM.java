package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueueFamilyDataGraphPropertiesARM} and {@link VkQueueFamilyDataGraphPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueueFamilyDataGraphPropertiesARM
    extends IPointer
    permits VkQueueFamilyDataGraphPropertiesARM, VkQueueFamilyDataGraphPropertiesARM.Ptr
{}
