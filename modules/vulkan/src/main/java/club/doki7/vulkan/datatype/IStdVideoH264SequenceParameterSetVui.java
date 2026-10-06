package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH264SequenceParameterSetVui} and {@link StdVideoH264SequenceParameterSetVui.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH264SequenceParameterSetVui
    extends IPointer
    permits StdVideoH264SequenceParameterSetVui, StdVideoH264SequenceParameterSetVui.Ptr
{}
