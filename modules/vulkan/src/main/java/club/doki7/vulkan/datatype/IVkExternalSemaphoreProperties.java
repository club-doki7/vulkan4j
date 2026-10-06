package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkExternalSemaphoreProperties} and {@link VkExternalSemaphoreProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkExternalSemaphoreProperties
    extends IPointer
    permits VkExternalSemaphoreProperties, VkExternalSemaphoreProperties.Ptr
{}
