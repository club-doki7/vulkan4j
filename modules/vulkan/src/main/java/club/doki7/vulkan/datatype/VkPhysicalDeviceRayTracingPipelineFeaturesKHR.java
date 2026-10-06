package club.doki7.vulkan.datatype;

import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.IPointer;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingPipelineFeaturesKHR.html"><code>VkPhysicalDeviceRayTracingPipelineFeaturesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceRayTracingPipelineFeaturesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 rayTracingPipeline; // @link substring="rayTracingPipeline" target="#rayTracingPipeline"
///     VkBool32 rayTracingPipelineShaderGroupHandleCaptureReplay; // @link substring="rayTracingPipelineShaderGroupHandleCaptureReplay" target="#rayTracingPipelineShaderGroupHandleCaptureReplay"
///     VkBool32 rayTracingPipelineShaderGroupHandleCaptureReplayMixed; // @link substring="rayTracingPipelineShaderGroupHandleCaptureReplayMixed" target="#rayTracingPipelineShaderGroupHandleCaptureReplayMixed"
///     VkBool32 rayTracingPipelineTraceRaysIndirect; // @link substring="rayTracingPipelineTraceRaysIndirect" target="#rayTracingPipelineTraceRaysIndirect"
///     VkBool32 rayTraversalPrimitiveCulling; // @link substring="rayTraversalPrimitiveCulling" target="#rayTraversalPrimitiveCulling"
/// } VkPhysicalDeviceRayTracingPipelineFeaturesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_PIPELINE_FEATURES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceRayTracingPipelineFeaturesKHR#allocate(Arena)}, {@link VkPhysicalDeviceRayTracingPipelineFeaturesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceRayTracingPipelineFeaturesKHR#autoInit}
/// to initialize these fields manually for non-allocated instances.
///
/// ## Contracts
///
/// The property {@link #segment()} should always be not-null
/// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
/// {@code LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
/// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
///
/// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
/// perform any runtime check. The constructor can be useful for automatic code generators.
///
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingPipelineFeaturesKHR.html"><code>VkPhysicalDeviceRayTracingPipelineFeaturesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceRayTracingPipelineFeaturesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceRayTracingPipelineFeaturesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingPipelineFeaturesKHR.html"><code>VkPhysicalDeviceRayTracingPipelineFeaturesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceRayTracingPipelineFeaturesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceRayTracingPipelineFeaturesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceRayTracingPipelineFeaturesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceRayTracingPipelineFeaturesKHR, Iterable<VkPhysicalDeviceRayTracingPipelineFeaturesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceRayTracingPipelineFeaturesKHR at(long index) {
            return new VkPhysicalDeviceRayTracingPipelineFeaturesKHR(segment.asSlice(index * VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES, VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceRayTracingPipelineFeaturesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceRayTracingPipelineFeaturesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceRayTracingPipelineFeaturesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES, VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES);
            s.copyFrom(value.segment);
        }

        /// Assume the {@link Ptr} is capable of holding at least {@code newSize} structures,
        /// create a new view {@link Ptr} that uses the same backing storage as this
        /// {@link Ptr}, but with the new size. Since there is actually no way to really check
        /// whether the new size is valid, while buffer overflow is undefined behavior, this method is
        /// marked as {@link Unsafe}.
        ///
        /// This method could be useful when handling data returned from some C API, where the size of
        /// the data is not known in advance.
        ///
        /// If the size of the underlying segment is actually known in advance and correctly set, and
        /// you want to create a shrunk view, you may use {@link #slice(long)} (with validation)
        /// instead.
        @Unsafe
        public @NotNull Ptr reinterpret(long newSize) {
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES,
                (end - start) * VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceRayTracingPipelineFeaturesKHR[] toArray() {
            VkPhysicalDeviceRayTracingPipelineFeaturesKHR[] ret = new VkPhysicalDeviceRayTracingPipelineFeaturesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceRayTracingPipelineFeaturesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceRayTracingPipelineFeaturesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceRayTracingPipelineFeaturesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceRayTracingPipelineFeaturesKHR ret = new VkPhysicalDeviceRayTracingPipelineFeaturesKHR(segment.asSlice(0, VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceRayTracingPipelineFeaturesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceRayTracingPipelineFeaturesKHR allocate(Arena arena) {
        VkPhysicalDeviceRayTracingPipelineFeaturesKHR ret = new VkPhysicalDeviceRayTracingPipelineFeaturesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PIPELINE_FEATURES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceRayTracingPipelineFeaturesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceRayTracingPipelineFeaturesKHR.Ptr ret = new VkPhysicalDeviceRayTracingPipelineFeaturesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PIPELINE_FEATURES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceRayTracingPipelineFeaturesKHR clone(Arena arena, VkPhysicalDeviceRayTracingPipelineFeaturesKHR src) {
        VkPhysicalDeviceRayTracingPipelineFeaturesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PIPELINE_FEATURES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceRayTracingPipelineFeaturesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceRayTracingPipelineFeaturesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceRayTracingPipelineFeaturesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int rayTracingPipeline() {
        return segment.get(LAYOUT$rayTracingPipeline, OFFSET$rayTracingPipeline);
    }

    public VkPhysicalDeviceRayTracingPipelineFeaturesKHR rayTracingPipeline(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$rayTracingPipeline, OFFSET$rayTracingPipeline, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int rayTracingPipelineShaderGroupHandleCaptureReplay() {
        return segment.get(LAYOUT$rayTracingPipelineShaderGroupHandleCaptureReplay, OFFSET$rayTracingPipelineShaderGroupHandleCaptureReplay);
    }

    public VkPhysicalDeviceRayTracingPipelineFeaturesKHR rayTracingPipelineShaderGroupHandleCaptureReplay(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$rayTracingPipelineShaderGroupHandleCaptureReplay, OFFSET$rayTracingPipelineShaderGroupHandleCaptureReplay, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int rayTracingPipelineShaderGroupHandleCaptureReplayMixed() {
        return segment.get(LAYOUT$rayTracingPipelineShaderGroupHandleCaptureReplayMixed, OFFSET$rayTracingPipelineShaderGroupHandleCaptureReplayMixed);
    }

    public VkPhysicalDeviceRayTracingPipelineFeaturesKHR rayTracingPipelineShaderGroupHandleCaptureReplayMixed(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$rayTracingPipelineShaderGroupHandleCaptureReplayMixed, OFFSET$rayTracingPipelineShaderGroupHandleCaptureReplayMixed, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int rayTracingPipelineTraceRaysIndirect() {
        return segment.get(LAYOUT$rayTracingPipelineTraceRaysIndirect, OFFSET$rayTracingPipelineTraceRaysIndirect);
    }

    public VkPhysicalDeviceRayTracingPipelineFeaturesKHR rayTracingPipelineTraceRaysIndirect(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$rayTracingPipelineTraceRaysIndirect, OFFSET$rayTracingPipelineTraceRaysIndirect, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int rayTraversalPrimitiveCulling() {
        return segment.get(LAYOUT$rayTraversalPrimitiveCulling, OFFSET$rayTraversalPrimitiveCulling);
    }

    public VkPhysicalDeviceRayTracingPipelineFeaturesKHR rayTraversalPrimitiveCulling(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$rayTraversalPrimitiveCulling, OFFSET$rayTraversalPrimitiveCulling, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("rayTracingPipeline"),
        ValueLayout.JAVA_INT.withName("rayTracingPipelineShaderGroupHandleCaptureReplay"),
        ValueLayout.JAVA_INT.withName("rayTracingPipelineShaderGroupHandleCaptureReplayMixed"),
        ValueLayout.JAVA_INT.withName("rayTracingPipelineTraceRaysIndirect"),
        ValueLayout.JAVA_INT.withName("rayTraversalPrimitiveCulling")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$rayTracingPipeline = PathElement.groupElement("rayTracingPipeline");
    public static final PathElement PATH$rayTracingPipelineShaderGroupHandleCaptureReplay = PathElement.groupElement("rayTracingPipelineShaderGroupHandleCaptureReplay");
    public static final PathElement PATH$rayTracingPipelineShaderGroupHandleCaptureReplayMixed = PathElement.groupElement("rayTracingPipelineShaderGroupHandleCaptureReplayMixed");
    public static final PathElement PATH$rayTracingPipelineTraceRaysIndirect = PathElement.groupElement("rayTracingPipelineTraceRaysIndirect");
    public static final PathElement PATH$rayTraversalPrimitiveCulling = PathElement.groupElement("rayTraversalPrimitiveCulling");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$rayTracingPipeline = (OfInt) LAYOUT.select(PATH$rayTracingPipeline);
    public static final OfInt LAYOUT$rayTracingPipelineShaderGroupHandleCaptureReplay = (OfInt) LAYOUT.select(PATH$rayTracingPipelineShaderGroupHandleCaptureReplay);
    public static final OfInt LAYOUT$rayTracingPipelineShaderGroupHandleCaptureReplayMixed = (OfInt) LAYOUT.select(PATH$rayTracingPipelineShaderGroupHandleCaptureReplayMixed);
    public static final OfInt LAYOUT$rayTracingPipelineTraceRaysIndirect = (OfInt) LAYOUT.select(PATH$rayTracingPipelineTraceRaysIndirect);
    public static final OfInt LAYOUT$rayTraversalPrimitiveCulling = (OfInt) LAYOUT.select(PATH$rayTraversalPrimitiveCulling);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$rayTracingPipeline = LAYOUT$rayTracingPipeline.byteSize();
    public static final long SIZE$rayTracingPipelineShaderGroupHandleCaptureReplay = LAYOUT$rayTracingPipelineShaderGroupHandleCaptureReplay.byteSize();
    public static final long SIZE$rayTracingPipelineShaderGroupHandleCaptureReplayMixed = LAYOUT$rayTracingPipelineShaderGroupHandleCaptureReplayMixed.byteSize();
    public static final long SIZE$rayTracingPipelineTraceRaysIndirect = LAYOUT$rayTracingPipelineTraceRaysIndirect.byteSize();
    public static final long SIZE$rayTraversalPrimitiveCulling = LAYOUT$rayTraversalPrimitiveCulling.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$rayTracingPipeline = LAYOUT.byteOffset(PATH$rayTracingPipeline);
    public static final long OFFSET$rayTracingPipelineShaderGroupHandleCaptureReplay = LAYOUT.byteOffset(PATH$rayTracingPipelineShaderGroupHandleCaptureReplay);
    public static final long OFFSET$rayTracingPipelineShaderGroupHandleCaptureReplayMixed = LAYOUT.byteOffset(PATH$rayTracingPipelineShaderGroupHandleCaptureReplayMixed);
    public static final long OFFSET$rayTracingPipelineTraceRaysIndirect = LAYOUT.byteOffset(PATH$rayTracingPipelineTraceRaysIndirect);
    public static final long OFFSET$rayTraversalPrimitiveCulling = LAYOUT.byteOffset(PATH$rayTraversalPrimitiveCulling);
}
