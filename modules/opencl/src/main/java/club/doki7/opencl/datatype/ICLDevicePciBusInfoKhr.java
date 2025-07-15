package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLDevicePciBusInfoKhr} and {@link CLDevicePciBusInfoKhr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLDevicePciBusInfoKhr
    extends IPointer
    permits CLDevicePciBusInfoKhr, CLDevicePciBusInfoKhr.Ptr
{}
