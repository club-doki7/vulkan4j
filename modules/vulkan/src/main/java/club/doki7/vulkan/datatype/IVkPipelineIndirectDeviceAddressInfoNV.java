package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPipelineIndirectDeviceAddressInfoNV} and {@link VkPipelineIndirectDeviceAddressInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPipelineIndirectDeviceAddressInfoNV
    extends IPointer
    permits VkPipelineIndirectDeviceAddressInfoNV, VkPipelineIndirectDeviceAddressInfoNV.Ptr
{}
