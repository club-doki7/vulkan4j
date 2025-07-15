package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLMemAndroidNativeBufferHostPtr} and {@link CLMemAndroidNativeBufferHostPtr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLMemAndroidNativeBufferHostPtr
    extends IPointer
    permits CLMemAndroidNativeBufferHostPtr, CLMemAndroidNativeBufferHostPtr.Ptr
{}
