package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSpecializationMapEntry} and {@link VkSpecializationMapEntry.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSpecializationMapEntry
    extends IPointer
    permits VkSpecializationMapEntry, VkSpecializationMapEntry.Ptr
{}
