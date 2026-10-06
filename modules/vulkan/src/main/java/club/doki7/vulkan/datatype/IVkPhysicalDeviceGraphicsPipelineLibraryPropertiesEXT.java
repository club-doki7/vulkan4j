package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceGraphicsPipelineLibraryPropertiesEXT} and {@link VkPhysicalDeviceGraphicsPipelineLibraryPropertiesEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceGraphicsPipelineLibraryPropertiesEXT
    extends IPointer
    permits VkPhysicalDeviceGraphicsPipelineLibraryPropertiesEXT, VkPhysicalDeviceGraphicsPipelineLibraryPropertiesEXT.Ptr
{}
