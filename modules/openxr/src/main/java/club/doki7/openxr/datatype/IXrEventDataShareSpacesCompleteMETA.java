package club.doki7.openxr.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link XrEventDataShareSpacesCompleteMETA} and {@link XrEventDataShareSpacesCompleteMETA.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IXrEventDataShareSpacesCompleteMETA
    extends IPointer
    permits XrEventDataShareSpacesCompleteMETA, XrEventDataShareSpacesCompleteMETA.Ptr
{}
