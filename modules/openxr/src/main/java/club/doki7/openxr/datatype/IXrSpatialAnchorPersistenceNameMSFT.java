package club.doki7.openxr.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link XrSpatialAnchorPersistenceNameMSFT} and {@link XrSpatialAnchorPersistenceNameMSFT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IXrSpatialAnchorPersistenceNameMSFT
    extends IPointer
    permits XrSpatialAnchorPersistenceNameMSFT, XrSpatialAnchorPersistenceNameMSFT.Ptr
{}
