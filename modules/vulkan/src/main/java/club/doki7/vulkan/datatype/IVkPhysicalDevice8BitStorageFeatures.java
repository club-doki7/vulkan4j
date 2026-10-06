package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevice8BitStorageFeatures} and {@link VkPhysicalDevice8BitStorageFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevice8BitStorageFeatures
    extends IPointer
    permits VkPhysicalDevice8BitStorageFeatures, VkPhysicalDevice8BitStorageFeatures.Ptr
{}
