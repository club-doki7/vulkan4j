package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLBufferRegion} and {@link CLBufferRegion.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLBufferRegion
    extends IPointer
    permits CLBufferRegion, CLBufferRegion.Ptr
{}
