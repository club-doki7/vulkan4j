package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLKernelAllocationInfoIntel} and {@link CLKernelAllocationInfoIntel.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLKernelAllocationInfoIntel
    extends IPointer
    permits CLKernelAllocationInfoIntel, CLKernelAllocationInfoIntel.Ptr
{}
