package club.doki7.openxr.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link XrEventDataSpatialAnchorCreateCompleteFB} and {@link XrEventDataSpatialAnchorCreateCompleteFB.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IXrEventDataSpatialAnchorCreateCompleteFB
    extends IPointer
    permits XrEventDataSpatialAnchorCreateCompleteFB, XrEventDataSpatialAnchorCreateCompleteFB.Ptr
{}
