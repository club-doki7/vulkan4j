package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceGraphicsPipelineLibraryFeaturesEXT} and {@link VkPhysicalDeviceGraphicsPipelineLibraryFeaturesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceGraphicsPipelineLibraryFeaturesEXT
    extends IPointer
    permits VkPhysicalDeviceGraphicsPipelineLibraryFeaturesEXT, VkPhysicalDeviceGraphicsPipelineLibraryFeaturesEXT.Ptr
{}
