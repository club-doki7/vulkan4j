package club.doki7.openxr.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link XrFoveationApplyInfoHTC} and {@link XrFoveationApplyInfoHTC.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IXrFoveationApplyInfoHTC
    extends IPointer
    permits XrFoveationApplyInfoHTC, XrFoveationApplyInfoHTC.Ptr
{}
