package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDescriptorPoolSize} and {@link VkDescriptorPoolSize.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDescriptorPoolSize
    extends IPointer
    permits VkDescriptorPoolSize, VkDescriptorPoolSize.Ptr
{}
