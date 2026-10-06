package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkValidationFeaturesEXT} and {@link VkValidationFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkValidationFeaturesEXT
    extends IPointer
    permits VkValidationFeaturesEXT, VkValidationFeaturesEXT.Ptr
{}
