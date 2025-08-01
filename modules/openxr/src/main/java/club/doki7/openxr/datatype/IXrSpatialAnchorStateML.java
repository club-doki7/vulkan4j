package club.doki7.openxr.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link XrSpatialAnchorStateML} and {@link XrSpatialAnchorStateML.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IXrSpatialAnchorStateML
    extends IPointer
    permits XrSpatialAnchorStateML, XrSpatialAnchorStateML.Ptr
{}
