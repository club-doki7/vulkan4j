package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLMutableDispatchConfigKhr} and {@link CLMutableDispatchConfigKhr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLMutableDispatchConfigKhr
    extends IPointer
    permits CLMutableDispatchConfigKhr, CLMutableDispatchConfigKhr.Ptr
{}
