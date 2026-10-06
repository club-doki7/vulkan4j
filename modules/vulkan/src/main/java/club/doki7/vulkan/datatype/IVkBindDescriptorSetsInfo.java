package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkBindDescriptorSetsInfo} and {@link VkBindDescriptorSetsInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkBindDescriptorSetsInfo
    extends IPointer
    permits VkBindDescriptorSetsInfo, VkBindDescriptorSetsInfo.Ptr
{}
