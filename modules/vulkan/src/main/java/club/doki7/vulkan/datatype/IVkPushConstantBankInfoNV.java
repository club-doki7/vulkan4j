package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkPushConstantBankInfoNV} and {@link VkPushConstantBankInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkPushConstantBankInfoNV
    extends IPointer
    permits VkPushConstantBankInfoNV, VkPushConstantBankInfoNV.Ptr
{}
