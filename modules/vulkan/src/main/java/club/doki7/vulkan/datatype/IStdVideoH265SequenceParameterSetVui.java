package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoH265SequenceParameterSetVui} and {@link StdVideoH265SequenceParameterSetVui.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoH265SequenceParameterSetVui
    extends IPointer
    permits StdVideoH265SequenceParameterSetVui, StdVideoH265SequenceParameterSetVui.Ptr
{}
