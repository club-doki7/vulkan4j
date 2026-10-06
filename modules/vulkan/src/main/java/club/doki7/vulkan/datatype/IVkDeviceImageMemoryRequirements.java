package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceImageMemoryRequirements} and {@link VkDeviceImageMemoryRequirements.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceImageMemoryRequirements
    extends IPointer
    permits VkDeviceImageMemoryRequirements, VkDeviceImageMemoryRequirements.Ptr
{}
