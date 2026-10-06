package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSwapchainTimeDomainPropertiesEXT} and {@link VkSwapchainTimeDomainPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSwapchainTimeDomainPropertiesEXT
    extends IPointer
    permits VkSwapchainTimeDomainPropertiesEXT, VkSwapchainTimeDomainPropertiesEXT.Ptr
{}
