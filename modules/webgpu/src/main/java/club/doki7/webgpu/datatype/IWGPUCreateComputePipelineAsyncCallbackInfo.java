package club.doki7.webgpu.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link WGPUCreateComputePipelineAsyncCallbackInfo} and {@link WGPUCreateComputePipelineAsyncCallbackInfo.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IWGPUCreateComputePipelineAsyncCallbackInfo
    extends IPointer
    permits WGPUCreateComputePipelineAsyncCallbackInfo, WGPUCreateComputePipelineAsyncCallbackInfo.Ptr
{}
