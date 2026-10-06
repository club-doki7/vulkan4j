package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDevicePipelinePropertiesFeaturesEXT} and {@link VkPhysicalDevicePipelinePropertiesFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDevicePipelinePropertiesFeaturesEXT
    extends IPointer
    permits VkPhysicalDevicePipelinePropertiesFeaturesEXT, VkPhysicalDevicePipelinePropertiesFeaturesEXT.Ptr
{}
