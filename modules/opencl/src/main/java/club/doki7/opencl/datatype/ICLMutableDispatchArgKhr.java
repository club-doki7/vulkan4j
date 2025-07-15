package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLMutableDispatchArgKhr} and {@link CLMutableDispatchArgKhr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLMutableDispatchArgKhr
    extends IPointer
    permits CLMutableDispatchArgKhr, CLMutableDispatchArgKhr.Ptr
{}
