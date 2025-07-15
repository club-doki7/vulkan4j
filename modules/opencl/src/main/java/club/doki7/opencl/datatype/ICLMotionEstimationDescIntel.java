package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLMotionEstimationDescIntel} and {@link CLMotionEstimationDescIntel.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLMotionEstimationDescIntel
    extends IPointer
    permits CLMotionEstimationDescIntel, CLMotionEstimationDescIntel.Ptr
{}
