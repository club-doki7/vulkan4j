package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link CLQueueFamilyPropertiesIntel} and {@link CLQueueFamilyPropertiesIntel.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface ICLQueueFamilyPropertiesIntel
    extends IPointer
    permits CLQueueFamilyPropertiesIntel, CLQueueFamilyPropertiesIntel.Ptr
{}
