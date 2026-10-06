package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceSubpassMergeFeedbackFeaturesEXT} and {@link VkPhysicalDeviceSubpassMergeFeedbackFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceSubpassMergeFeedbackFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceSubpassMergeFeedbackFeaturesEXT, VkPhysicalDeviceSubpassMergeFeedbackFeaturesEXT.Ptr
{}
