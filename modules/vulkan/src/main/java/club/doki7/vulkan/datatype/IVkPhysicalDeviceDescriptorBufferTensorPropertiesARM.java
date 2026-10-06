package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPhysicalDeviceDescriptorBufferTensorPropertiesARM} and {@link VkPhysicalDeviceDescriptorBufferTensorPropertiesARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPhysicalDeviceDescriptorBufferTensorPropertiesARM
    extends IPointer
    permits VkPhysicalDeviceDescriptorBufferTensorPropertiesARM, VkPhysicalDeviceDescriptorBufferTensorPropertiesARM.Ptr
{}
