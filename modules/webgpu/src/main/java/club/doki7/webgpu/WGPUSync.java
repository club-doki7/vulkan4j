package club.doki7.webgpu;

import club.doki7.ffm.annotation.Bitmask;
import club.doki7.ffm.annotation.EnumType;
import club.doki7.ffm.annotation.NativeType;
import club.doki7.ffm.annotation.Pointer;
import club.doki7.webgpu.bitmask.WGPUMapMode;
import club.doki7.webgpu.datatype.*;
import club.doki7.webgpu.enumtype.WGPUMapAsyncStatus;
import club.doki7.webgpu.enumtype.WGPURequestAdapterStatus;
import club.doki7.webgpu.enumtype.WGPURequestDeviceStatus;
import club.doki7.webgpu.handle.WGPUAdapter;
import club.doki7.webgpu.handle.WGPUBuffer;
import club.doki7.webgpu.handle.WGPUDevice;
import club.doki7.webgpu.handle.WGPUInstance;
import org.jetbrains.annotations.Nullable;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Objects;

public final class WGPUSync {
    public static final class RequestAdapterResult {
        public final @EnumType(WGPURequestAdapterStatus.class) int status;
        public final @Nullable WGPUAdapter adapter;
        public final @Nullable String message;

        public RequestAdapterResult(
                @EnumType(WGPURequestAdapterStatus.class) int status,
                @Nullable WGPUAdapter adapter,
                @Nullable String message
        ) {
            this.status = status;
            this.adapter = adapter;
            this.message = message;
        }
    }

    public static RequestAdapterResult instanceRequestAdapter(
            WGPU wgpu,
            WGPUInstance instance,
            WGPURequestAdapterOptions options
    ) {
        Ref<RequestAdapterResult> saveSlot = new Ref<>();
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment pfn = Linker.nativeLinker().upcallStub(
                    MH_onRequestAdapterEnded.bindTo(saveSlot),
                    WGPUFunctionTypes.WGPURequestAdapterCallback,
                    arena
            );

            WGPURequestAdapterCallbackInfo info = WGPURequestAdapterCallbackInfo.allocate(arena)
                    .callback(pfn);
            WGPUFuture ignoredFuture = wgpu.instanceRequestAdapter(arena, instance, options, info);
            return Objects.requireNonNull(saveSlot.value, ASYNC_NOT_SYNC);
        }
    }

    public static final class RequestDeviceResult {
        public final @EnumType(WGPURequestDeviceStatus.class) int status;
        public final @Nullable WGPUDevice device;
        public final @Nullable String message;

        public RequestDeviceResult(
                @EnumType(WGPURequestDeviceStatus.class) int status,
                @Nullable WGPUDevice device,
                @Nullable String message
        ) {
            this.status = status;
            this.device = device;
            this.message = message;
        }
    }

    public static RequestDeviceResult adapterRequestDevice(
            WGPU wgpu,
            WGPUAdapter adapter,
            WGPUDeviceDescriptor descriptor
    ) {
        Ref<RequestDeviceResult> saveSlot = new Ref<>();
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment pfn = Linker.nativeLinker().upcallStub(
                    MH_onRequestDeviceEnded.bindTo(saveSlot),
                    WGPUFunctionTypes.WGPURequestDeviceCallback,
                    arena
            );

            WGPURequestDeviceCallbackInfo info = WGPURequestDeviceCallbackInfo.allocate(arena)
                    .callback(pfn);
            WGPUFuture ignoredFuture = wgpu.adapterRequestDevice(arena, adapter, descriptor, info);
            return Objects.requireNonNull(saveSlot.value, ASYNC_NOT_SYNC);
        }
    }

    public static final class BufferMapResult {
        public final @EnumType(WGPUMapAsyncStatus.class) int status;
        public final @Nullable String message;

        public BufferMapResult(int status, @Nullable String message) {
            this.status = status;
            this.message = message;
        }
    }

    public static BufferMapResult bufferMap(
            WGPU wgpu,
            WGPUInstance instance,
            WGPUBuffer buffer,
            @Bitmask(WGPUMapMode.class) long mode,
            long offset,
            long size
    ) {
        Ref<BufferMapResult> saveSlot = new Ref<>();
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment pfn = Linker.nativeLinker().upcallStub(
                    MH_onBufferMapEnded.bindTo(saveSlot),
                    WGPUFunctionTypes.WGPUBufferMapCallback,
                    arena
            );

            WGPUBufferMapCallbackInfo info = WGPUBufferMapCallbackInfo.allocate(arena)
                    .callback(pfn);
            WGPUFuture future = wgpu.bufferMapAsync(arena, buffer, mode, offset, size, info);
            while (saveSlot.value == null) {
                wgpu.instanceProcessEvents(instance);
            }
            return Objects.requireNonNull(saveSlot.value, ASYNC_NOT_SYNC);
        }
    }

    private static final class Ref<T> { @Nullable T value = null; }

    private static void onRequestAdapterFinished(
            Ref<RequestAdapterResult> saveSlot,
            @EnumType(WGPURequestAdapterStatus.class) int status,
            @NativeType("WGPUAdapter") MemorySegment adapter,
            @NativeType("WGPUStringView") MemorySegment message,
            @Pointer(comment="void*") MemorySegment ignoredUserData1,
            @Pointer(comment="void*") MemorySegment ignoredUserData2
    ) {
        @Nullable WGPUAdapter adapterHandle = adapter == MemorySegment.NULL
                ? null
                : new WGPUAdapter(MemorySegment.ofAddress(adapter.address()));
        @Nullable String messageString = WGPUUtil.readStringView(message);
        saveSlot.value = new RequestAdapterResult(status, adapterHandle, messageString);
    }

    private static void onRequestDeviceFinished(
            Ref<RequestDeviceResult> saveSlot,
            @EnumType(WGPURequestDeviceStatus.class) int status,
            @NativeType("WGPUDevice") MemorySegment device,
            @NativeType("WGPUStringView") MemorySegment message,
            @Pointer(comment="void*") MemorySegment ignoredUserData1,
            @Pointer(comment="void*") MemorySegment ignoredUserData2
    ) {
        @Nullable WGPUDevice deviceHandle = device == MemorySegment.NULL
                ? null
                : new WGPUDevice(MemorySegment.ofAddress(device.address()));
        @Nullable String messageString = WGPUUtil.readStringView(message);
        saveSlot.value = new RequestDeviceResult(status, deviceHandle, messageString);
    }

    private static void onBufferMapFinished(
            Ref<BufferMapResult> saveSlot,
            @EnumType(WGPUMapAsyncStatus.class) int status,
            @NativeType("WGPUStringView") MemorySegment message,
            @Pointer(comment="void*") MemorySegment ignoredUserData1,
            @Pointer(comment="void*") MemorySegment ignoredUserData2
    ) {
        @Nullable String messageString = WGPUUtil.readStringView(message);
        saveSlot.value = new BufferMapResult(status, messageString);
    }

    private static final MethodHandle MH_onRequestAdapterEnded;
    private static final MethodHandle MH_onRequestDeviceEnded;
    private static final MethodHandle MH_onBufferMapEnded;
    private static final String ASYNC_NOT_SYNC
            = "On native platform, such WebGPU async requests should finish synchronously immediately";

    static {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MH_onRequestAdapterEnded = lookup.findStatic(
                    WGPUSync.class,
                    "onRequestAdapterFinished",
                    WGPUFunctionTypes.WGPURequestAdapterCallback
                            .toMethodType()
                            .insertParameterTypes(0, Ref.class)
            );
            MH_onRequestDeviceEnded = lookup.findStatic(
                    WGPUSync.class,
                    "onRequestDeviceFinished",
                    WGPUFunctionTypes.WGPURequestDeviceCallback
                            .toMethodType()
                            .insertParameterTypes(0, Ref.class)
            );
            MH_onBufferMapEnded = lookup.findStatic(
                    WGPUSync.class,
                    "onBufferMapFinished",
                    WGPUFunctionTypes.WGPUBufferMapCallback
                            .toMethodType()
                            .insertParameterTypes(0, Ref.class)
            );
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private WGPUSync() {}
}
