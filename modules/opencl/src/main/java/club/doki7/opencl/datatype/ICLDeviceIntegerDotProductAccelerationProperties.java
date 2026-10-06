package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLDeviceIntegerDotProductAccelerationProperties} and {@link CLDeviceIntegerDotProductAccelerationProperties.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLDeviceIntegerDotProductAccelerationProperties
    extends IPointer
    permits CLDeviceIntegerDotProductAccelerationProperties, CLDeviceIntegerDotProductAccelerationProperties.Ptr
{}
