package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkDeviceTensorMemoryRequirementsARM} and {@link VkDeviceTensorMemoryRequirementsARM.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkDeviceTensorMemoryRequirementsARM
    extends IPointer
    permits VkDeviceTensorMemoryRequirementsARM, VkDeviceTensorMemoryRequirementsARM.Ptr
{}
