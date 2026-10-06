package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceVariablePointersFeatures} and {@link VkPhysicalDeviceVariablePointersFeatures.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceVariablePointersFeatures
    extends IPointer
    permits VkPhysicalDeviceVariablePointersFeatures, VkPhysicalDeviceVariablePointersFeatures.Ptr
{}
