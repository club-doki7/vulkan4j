package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLImageDesc} and {@link CLImageDesc.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLImageDesc
    extends IPointer
    permits CLImageDesc, CLImageDesc.Ptr
{}
