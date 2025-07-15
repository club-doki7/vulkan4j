package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLImageDescBufferOrMemObject} and {@link CLImageDescBufferOrMemObject.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLImageDescBufferOrMemObject
    extends IPointer
    permits CLImageDescBufferOrMemObject, CLImageDescBufferOrMemObject.Ptr
{}
