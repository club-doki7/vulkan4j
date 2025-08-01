package club.doki7.openxr.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link XrPlaneDetectorCreateInfoEXT} and {@link XrPlaneDetectorCreateInfoEXT.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IXrPlaneDetectorCreateInfoEXT
    extends IPointer
    permits XrPlaneDetectorCreateInfoEXT, XrPlaneDetectorCreateInfoEXT.Ptr
{}
