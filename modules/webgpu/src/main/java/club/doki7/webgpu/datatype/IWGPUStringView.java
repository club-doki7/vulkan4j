package club.doki7.webgpu.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link WGPUStringView} and {@link WGPUStringView.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IWGPUStringView
    extends IPointer
    permits WGPUStringView, WGPUStringView.Ptr
{}
