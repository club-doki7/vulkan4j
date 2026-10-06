package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceFaultCountsEXT} and {@link VkDeviceFaultCountsEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceFaultCountsEXT
    extends IPointer
    permits VkDeviceFaultCountsEXT, VkDeviceFaultCountsEXT.Ptr
{}
