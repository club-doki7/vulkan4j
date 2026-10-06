package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VkLatencySubmissionPresentIdNV} and {@link VkLatencySubmissionPresentIdNV.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVkLatencySubmissionPresentIdNV
    extends IPointer
    permits VkLatencySubmissionPresentIdNV, VkLatencySubmissionPresentIdNV.Ptr
{}
