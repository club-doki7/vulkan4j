package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoSessionMemoryRequirementsKHR} and {@link VkVideoSessionMemoryRequirementsKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoSessionMemoryRequirementsKHR
    extends IPointer
    permits VkVideoSessionMemoryRequirementsKHR, VkVideoSessionMemoryRequirementsKHR.Ptr
{}
