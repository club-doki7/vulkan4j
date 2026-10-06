package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVertexInputBindingDescription} and {@link VkVertexInputBindingDescription.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVertexInputBindingDescription
    extends IPointer
    permits VkVertexInputBindingDescription, VkVertexInputBindingDescription.Ptr
{}
