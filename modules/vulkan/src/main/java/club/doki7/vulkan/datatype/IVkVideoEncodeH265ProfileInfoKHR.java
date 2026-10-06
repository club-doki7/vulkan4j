package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkVideoEncodeH265ProfileInfoKHR} and {@link VkVideoEncodeH265ProfileInfoKHR.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkVideoEncodeH265ProfileInfoKHR
    extends IPointer
    permits VkVideoEncodeH265ProfileInfoKHR, VkVideoEncodeH265ProfileInfoKHR.Ptr
{}
