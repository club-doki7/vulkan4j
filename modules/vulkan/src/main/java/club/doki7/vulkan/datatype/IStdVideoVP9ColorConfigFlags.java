package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoVP9ColorConfigFlags} and {@link StdVideoVP9ColorConfigFlags.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoVP9ColorConfigFlags
    extends IPointer
    permits StdVideoVP9ColorConfigFlags, StdVideoVP9ColorConfigFlags.Ptr
{}
