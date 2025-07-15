package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLImageFormat} and {@link CLImageFormat.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLImageFormat
    extends IPointer
    permits CLImageFormat, CLImageFormat.Ptr
{}
