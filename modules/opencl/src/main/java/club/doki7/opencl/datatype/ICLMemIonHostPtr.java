package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLMemIonHostPtr} and {@link CLMemIonHostPtr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLMemIonHostPtr
    extends IPointer
    permits CLMemIonHostPtr, CLMemIonHostPtr.Ptr
{}
