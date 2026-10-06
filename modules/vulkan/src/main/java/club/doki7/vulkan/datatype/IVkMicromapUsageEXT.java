package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkMicromapUsageEXT} and {@link VkMicromapUsageEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkMicromapUsageEXT
    extends IPointer
    permits VkMicromapUsageEXT, VkMicromapUsageEXT.Ptr
{}
