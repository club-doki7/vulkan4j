package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLDeviceIntegerDotProductAccelerationPropertiesKhr} and {@link CLDeviceIntegerDotProductAccelerationPropertiesKhr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLDeviceIntegerDotProductAccelerationPropertiesKhr
    extends IPointer
    permits CLDeviceIntegerDotProductAccelerationPropertiesKhr, CLDeviceIntegerDotProductAccelerationPropertiesKhr.Ptr
{}
