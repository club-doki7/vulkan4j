package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDataGraphModelFeaturesQCOM} and {@link VkPhysicalDeviceDataGraphModelFeaturesQCOM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDataGraphModelFeaturesQCOM
    extends IPointer
    permits VkPhysicalDeviceDataGraphModelFeaturesQCOM, VkPhysicalDeviceDataGraphModelFeaturesQCOM.Ptr
{}
