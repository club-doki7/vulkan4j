package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkSciSyncAttributesInfoNV} and {@link VkSciSyncAttributesInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkSciSyncAttributesInfoNV
    extends IPointer
    permits VkSciSyncAttributesInfoNV, VkSciSyncAttributesInfoNV.Ptr
{}
