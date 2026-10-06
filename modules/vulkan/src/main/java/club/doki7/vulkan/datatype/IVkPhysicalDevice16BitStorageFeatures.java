package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevice16BitStorageFeatures} and {@link VkPhysicalDevice16BitStorageFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevice16BitStorageFeatures
    extends IPointer
    permits VkPhysicalDevice16BitStorageFeatures, VkPhysicalDevice16BitStorageFeatures.Ptr
{}
