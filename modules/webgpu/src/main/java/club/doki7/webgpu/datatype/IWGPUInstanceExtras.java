package club.doki7.webgpu.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link WGPUInstanceExtras} and {@link WGPUInstanceExtras.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IWGPUInstanceExtras
    extends IPointer
    permits WGPUInstanceExtras, WGPUInstanceExtras.Ptr
{}
