package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoEncodeH264RefListModEntry} and {@link StdVideoEncodeH264RefListModEntry.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoEncodeH264RefListModEntry
    extends IPointer
    permits StdVideoEncodeH264RefListModEntry, StdVideoEncodeH264RefListModEntry.Ptr
{}
