package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkConvertCooperativeVectorMatrixInfoNV} and {@link VkConvertCooperativeVectorMatrixInfoNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkConvertCooperativeVectorMatrixInfoNV
    extends IPointer
    permits VkConvertCooperativeVectorMatrixInfoNV, VkConvertCooperativeVectorMatrixInfoNV.Ptr
{}
