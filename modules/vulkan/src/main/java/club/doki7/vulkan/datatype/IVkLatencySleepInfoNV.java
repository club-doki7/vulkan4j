package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkLatencySleepInfoNV} and {@link VkLatencySleepInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkLatencySleepInfoNV
    extends IPointer
    permits VkLatencySleepInfoNV, VkLatencySleepInfoNV.Ptr
{}
