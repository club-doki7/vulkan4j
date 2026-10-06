package club.doki7.vulkan.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link StdVideoVP9ColorConfig} and {@link StdVideoVP9ColorConfig.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IStdVideoVP9ColorConfig
    extends IPointer
    permits StdVideoVP9ColorConfig, StdVideoVP9ColorConfig.Ptr
{}
