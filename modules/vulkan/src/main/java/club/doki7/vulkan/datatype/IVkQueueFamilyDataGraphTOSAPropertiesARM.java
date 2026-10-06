package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueueFamilyDataGraphTOSAPropertiesARM} and {@link VkQueueFamilyDataGraphTOSAPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueueFamilyDataGraphTOSAPropertiesARM
    extends IPointer
    permits VkQueueFamilyDataGraphTOSAPropertiesARM, VkQueueFamilyDataGraphTOSAPropertiesARM.Ptr
{}
