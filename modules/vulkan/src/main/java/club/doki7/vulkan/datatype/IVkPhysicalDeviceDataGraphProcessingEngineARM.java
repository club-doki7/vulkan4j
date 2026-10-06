package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDataGraphProcessingEngineARM} and {@link VkPhysicalDeviceDataGraphProcessingEngineARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDataGraphProcessingEngineARM
    extends IPointer
    permits VkPhysicalDeviceDataGraphProcessingEngineARM, VkPhysicalDeviceDataGraphProcessingEngineARM.Ptr
{}
