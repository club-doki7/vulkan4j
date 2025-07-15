package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLMemExtHostPtr} and {@link CLMemExtHostPtr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLMemExtHostPtr
    extends IPointer
    permits CLMemExtHostPtr, CLMemExtHostPtr.Ptr
{}
