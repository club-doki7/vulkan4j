package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkQueueFamilyOwnershipTransferPropertiesKHR} and {@link VkQueueFamilyOwnershipTransferPropertiesKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkQueueFamilyOwnershipTransferPropertiesKHR
    extends IPointer
    permits VkQueueFamilyOwnershipTransferPropertiesKHR, VkQueueFamilyOwnershipTransferPropertiesKHR.Ptr
{}
