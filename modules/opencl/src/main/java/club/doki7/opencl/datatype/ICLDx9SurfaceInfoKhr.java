package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLDx9SurfaceInfoKhr} and {@link CLDx9SurfaceInfoKhr.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLDx9SurfaceInfoKhr
    extends IPointer
    permits CLDx9SurfaceInfoKhr, CLDx9SurfaceInfoKhr.Ptr
{}
