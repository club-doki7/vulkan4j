package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceFaultInfoEXT} and {@link VkDeviceFaultInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceFaultInfoEXT
    extends IPointer
    permits VkDeviceFaultInfoEXT, VkDeviceFaultInfoEXT.Ptr
{}
