package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLNameVersionKhr} and {@link CLNameVersionKhr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLNameVersionKhr
    extends IPointer
    permits CLNameVersionKhr, CLNameVersionKhr.Ptr
{}
