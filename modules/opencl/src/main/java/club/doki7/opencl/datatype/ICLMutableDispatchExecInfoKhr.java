package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLMutableDispatchExecInfoKhr} and {@link CLMutableDispatchExecInfoKhr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLMutableDispatchExecInfoKhr
    extends IPointer
    permits CLMutableDispatchExecInfoKhr, CLMutableDispatchExecInfoKhr.Ptr
{}
