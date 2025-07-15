package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLNameVersion} and {@link CLNameVersion.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLNameVersion
    extends IPointer
    permits CLNameVersion, CLNameVersion.Ptr
{}
