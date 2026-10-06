package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264RefPicMarkingEntry} and {@link StdVideoEncodeH264RefPicMarkingEntry.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264RefPicMarkingEntry
    extends IPointer
    permits StdVideoEncodeH264RefPicMarkingEntry, StdVideoEncodeH264RefPicMarkingEntry.Ptr
{}
