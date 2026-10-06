package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceTileMemoryHeapFeaturesQCOM} and {@link VkPhysicalDeviceTileMemoryHeapFeaturesQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceTileMemoryHeapFeaturesQCOM
    extends IPointer
    permits VkPhysicalDeviceTileMemoryHeapFeaturesQCOM, VkPhysicalDeviceTileMemoryHeapFeaturesQCOM.Ptr
{}
