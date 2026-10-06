package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkCommandBufferInheritanceDescriptorHeapInfoEXT} and {@link VkCommandBufferInheritanceDescriptorHeapInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkCommandBufferInheritanceDescriptorHeapInfoEXT
    extends IPointer
    permits VkCommandBufferInheritanceDescriptorHeapInfoEXT, VkCommandBufferInheritanceDescriptorHeapInfoEXT.Ptr
{}
