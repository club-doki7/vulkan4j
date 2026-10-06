package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMicromapVersionInfoEXT} and {@link VkMicromapVersionInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMicromapVersionInfoEXT
    extends IPointer
    permits VkMicromapVersionInfoEXT, VkMicromapVersionInfoEXT.Ptr
{}
