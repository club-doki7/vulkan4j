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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLatencyTimingsFrameReportNV.html"><code>VkLatencyTimingsFrameReportNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkLatencyTimingsFrameReportNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint64_t presentID; // @link substring="presentID" target="#presentID"
///     uint64_t inputSampleTimeUs; // @link substring="inputSampleTimeUs" target="#inputSampleTimeUs"
///     uint64_t simStartTimeUs; // @link substring="simStartTimeUs" target="#simStartTimeUs"
///     uint64_t simEndTimeUs; // @link substring="simEndTimeUs" target="#simEndTimeUs"
///     uint64_t renderSubmitStartTimeUs; // @link substring="renderSubmitStartTimeUs" target="#renderSubmitStartTimeUs"
///     uint64_t renderSubmitEndTimeUs; // @link substring="renderSubmitEndTimeUs" target="#renderSubmitEndTimeUs"
///     uint64_t presentStartTimeUs; // @link substring="presentStartTimeUs" target="#presentStartTimeUs"
///     uint64_t presentEndTimeUs; // @link substring="presentEndTimeUs" target="#presentEndTimeUs"
///     uint64_t driverStartTimeUs; // @link substring="driverStartTimeUs" target="#driverStartTimeUs"
///     uint64_t driverEndTimeUs; // @link substring="driverEndTimeUs" target="#driverEndTimeUs"
///     uint64_t osRenderQueueStartTimeUs; // @link substring="osRenderQueueStartTimeUs" target="#osRenderQueueStartTimeUs"
///     uint64_t osRenderQueueEndTimeUs; // @link substring="osRenderQueueEndTimeUs" target="#osRenderQueueEndTimeUs"
///     uint64_t gpuRenderStartTimeUs; // @link substring="gpuRenderStartTimeUs" target="#gpuRenderStartTimeUs"
///     uint64_t gpuRenderEndTimeUs; // @link substring="gpuRenderEndTimeUs" target="#gpuRenderEndTimeUs"
/// } VkLatencyTimingsFrameReportNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_LATENCY_TIMINGS_FRAME_REPORT_NV`
///
/// The {@code allocate} ({@link VkLatencyTimingsFrameReportNV#allocate(Arena)}, {@link VkLatencyTimingsFrameReportNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkLatencyTimingsFrameReportNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLatencyTimingsFrameReportNV.html"><code>VkLatencyTimingsFrameReportNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkLatencyTimingsFrameReportNV(@NotNull MemorySegment segment) implements IVkLatencyTimingsFrameReportNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLatencyTimingsFrameReportNV.html"><code>VkLatencyTimingsFrameReportNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkLatencyTimingsFrameReportNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkLatencyTimingsFrameReportNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkLatencyTimingsFrameReportNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkLatencyTimingsFrameReportNV, Iterable<VkLatencyTimingsFrameReportNV> {
        public long size() {
            return segment.byteSize() / VkLatencyTimingsFrameReportNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkLatencyTimingsFrameReportNV at(long index) {
            return new VkLatencyTimingsFrameReportNV(segment.asSlice(index * VkLatencyTimingsFrameReportNV.BYTES, VkLatencyTimingsFrameReportNV.BYTES));
        }

        public VkLatencyTimingsFrameReportNV.Ptr at(long index, @NotNull Consumer<@NotNull VkLatencyTimingsFrameReportNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkLatencyTimingsFrameReportNV value) {
            MemorySegment s = segment.asSlice(index * VkLatencyTimingsFrameReportNV.BYTES, VkLatencyTimingsFrameReportNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkLatencyTimingsFrameReportNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkLatencyTimingsFrameReportNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkLatencyTimingsFrameReportNV.BYTES,
                (end - start) * VkLatencyTimingsFrameReportNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkLatencyTimingsFrameReportNV.BYTES));
        }

        public VkLatencyTimingsFrameReportNV[] toArray() {
            VkLatencyTimingsFrameReportNV[] ret = new VkLatencyTimingsFrameReportNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkLatencyTimingsFrameReportNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkLatencyTimingsFrameReportNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkLatencyTimingsFrameReportNV.BYTES;
            }

            @Override
            public VkLatencyTimingsFrameReportNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkLatencyTimingsFrameReportNV ret = new VkLatencyTimingsFrameReportNV(segment.asSlice(0, VkLatencyTimingsFrameReportNV.BYTES));
                segment = segment.asSlice(VkLatencyTimingsFrameReportNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkLatencyTimingsFrameReportNV allocate(Arena arena) {
        VkLatencyTimingsFrameReportNV ret = new VkLatencyTimingsFrameReportNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.LATENCY_TIMINGS_FRAME_REPORT_NV);
        return ret;
    }

    public static VkLatencyTimingsFrameReportNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkLatencyTimingsFrameReportNV.Ptr ret = new VkLatencyTimingsFrameReportNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.LATENCY_TIMINGS_FRAME_REPORT_NV);
        }
        return ret;
    }

    public static VkLatencyTimingsFrameReportNV clone(Arena arena, VkLatencyTimingsFrameReportNV src) {
        VkLatencyTimingsFrameReportNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.LATENCY_TIMINGS_FRAME_REPORT_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkLatencyTimingsFrameReportNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkLatencyTimingsFrameReportNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkLatencyTimingsFrameReportNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long presentID() {
        return segment.get(LAYOUT$presentID, OFFSET$presentID);
    }

    public VkLatencyTimingsFrameReportNV presentID(@Unsigned long value) {
        segment.set(LAYOUT$presentID, OFFSET$presentID, value);
        return this;
    }

    public @Unsigned long inputSampleTimeUs() {
        return segment.get(LAYOUT$inputSampleTimeUs, OFFSET$inputSampleTimeUs);
    }

    public VkLatencyTimingsFrameReportNV inputSampleTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$inputSampleTimeUs, OFFSET$inputSampleTimeUs, value);
        return this;
    }

    public @Unsigned long simStartTimeUs() {
        return segment.get(LAYOUT$simStartTimeUs, OFFSET$simStartTimeUs);
    }

    public VkLatencyTimingsFrameReportNV simStartTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$simStartTimeUs, OFFSET$simStartTimeUs, value);
        return this;
    }

    public @Unsigned long simEndTimeUs() {
        return segment.get(LAYOUT$simEndTimeUs, OFFSET$simEndTimeUs);
    }

    public VkLatencyTimingsFrameReportNV simEndTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$simEndTimeUs, OFFSET$simEndTimeUs, value);
        return this;
    }

    public @Unsigned long renderSubmitStartTimeUs() {
        return segment.get(LAYOUT$renderSubmitStartTimeUs, OFFSET$renderSubmitStartTimeUs);
    }

    public VkLatencyTimingsFrameReportNV renderSubmitStartTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$renderSubmitStartTimeUs, OFFSET$renderSubmitStartTimeUs, value);
        return this;
    }

    public @Unsigned long renderSubmitEndTimeUs() {
        return segment.get(LAYOUT$renderSubmitEndTimeUs, OFFSET$renderSubmitEndTimeUs);
    }

    public VkLatencyTimingsFrameReportNV renderSubmitEndTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$renderSubmitEndTimeUs, OFFSET$renderSubmitEndTimeUs, value);
        return this;
    }

    public @Unsigned long presentStartTimeUs() {
        return segment.get(LAYOUT$presentStartTimeUs, OFFSET$presentStartTimeUs);
    }

    public VkLatencyTimingsFrameReportNV presentStartTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$presentStartTimeUs, OFFSET$presentStartTimeUs, value);
        return this;
    }

    public @Unsigned long presentEndTimeUs() {
        return segment.get(LAYOUT$presentEndTimeUs, OFFSET$presentEndTimeUs);
    }

    public VkLatencyTimingsFrameReportNV presentEndTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$presentEndTimeUs, OFFSET$presentEndTimeUs, value);
        return this;
    }

    public @Unsigned long driverStartTimeUs() {
        return segment.get(LAYOUT$driverStartTimeUs, OFFSET$driverStartTimeUs);
    }

    public VkLatencyTimingsFrameReportNV driverStartTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$driverStartTimeUs, OFFSET$driverStartTimeUs, value);
        return this;
    }

    public @Unsigned long driverEndTimeUs() {
        return segment.get(LAYOUT$driverEndTimeUs, OFFSET$driverEndTimeUs);
    }

    public VkLatencyTimingsFrameReportNV driverEndTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$driverEndTimeUs, OFFSET$driverEndTimeUs, value);
        return this;
    }

    public @Unsigned long osRenderQueueStartTimeUs() {
        return segment.get(LAYOUT$osRenderQueueStartTimeUs, OFFSET$osRenderQueueStartTimeUs);
    }

    public VkLatencyTimingsFrameReportNV osRenderQueueStartTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$osRenderQueueStartTimeUs, OFFSET$osRenderQueueStartTimeUs, value);
        return this;
    }

    public @Unsigned long osRenderQueueEndTimeUs() {
        return segment.get(LAYOUT$osRenderQueueEndTimeUs, OFFSET$osRenderQueueEndTimeUs);
    }

    public VkLatencyTimingsFrameReportNV osRenderQueueEndTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$osRenderQueueEndTimeUs, OFFSET$osRenderQueueEndTimeUs, value);
        return this;
    }

    public @Unsigned long gpuRenderStartTimeUs() {
        return segment.get(LAYOUT$gpuRenderStartTimeUs, OFFSET$gpuRenderStartTimeUs);
    }

    public VkLatencyTimingsFrameReportNV gpuRenderStartTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$gpuRenderStartTimeUs, OFFSET$gpuRenderStartTimeUs, value);
        return this;
    }

    public @Unsigned long gpuRenderEndTimeUs() {
        return segment.get(LAYOUT$gpuRenderEndTimeUs, OFFSET$gpuRenderEndTimeUs);
    }

    public VkLatencyTimingsFrameReportNV gpuRenderEndTimeUs(@Unsigned long value) {
        segment.set(LAYOUT$gpuRenderEndTimeUs, OFFSET$gpuRenderEndTimeUs, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("presentID"),
        ValueLayout.JAVA_LONG.withName("inputSampleTimeUs"),
        ValueLayout.JAVA_LONG.withName("simStartTimeUs"),
        ValueLayout.JAVA_LONG.withName("simEndTimeUs"),
        ValueLayout.JAVA_LONG.withName("renderSubmitStartTimeUs"),
        ValueLayout.JAVA_LONG.withName("renderSubmitEndTimeUs"),
        ValueLayout.JAVA_LONG.withName("presentStartTimeUs"),
        ValueLayout.JAVA_LONG.withName("presentEndTimeUs"),
        ValueLayout.JAVA_LONG.withName("driverStartTimeUs"),
        ValueLayout.JAVA_LONG.withName("driverEndTimeUs"),
        ValueLayout.JAVA_LONG.withName("osRenderQueueStartTimeUs"),
        ValueLayout.JAVA_LONG.withName("osRenderQueueEndTimeUs"),
        ValueLayout.JAVA_LONG.withName("gpuRenderStartTimeUs"),
        ValueLayout.JAVA_LONG.withName("gpuRenderEndTimeUs")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$presentID = PathElement.groupElement("presentID");
    public static final PathElement PATH$inputSampleTimeUs = PathElement.groupElement("inputSampleTimeUs");
    public static final PathElement PATH$simStartTimeUs = PathElement.groupElement("simStartTimeUs");
    public static final PathElement PATH$simEndTimeUs = PathElement.groupElement("simEndTimeUs");
    public static final PathElement PATH$renderSubmitStartTimeUs = PathElement.groupElement("renderSubmitStartTimeUs");
    public static final PathElement PATH$renderSubmitEndTimeUs = PathElement.groupElement("renderSubmitEndTimeUs");
    public static final PathElement PATH$presentStartTimeUs = PathElement.groupElement("presentStartTimeUs");
    public static final PathElement PATH$presentEndTimeUs = PathElement.groupElement("presentEndTimeUs");
    public static final PathElement PATH$driverStartTimeUs = PathElement.groupElement("driverStartTimeUs");
    public static final PathElement PATH$driverEndTimeUs = PathElement.groupElement("driverEndTimeUs");
    public static final PathElement PATH$osRenderQueueStartTimeUs = PathElement.groupElement("osRenderQueueStartTimeUs");
    public static final PathElement PATH$osRenderQueueEndTimeUs = PathElement.groupElement("osRenderQueueEndTimeUs");
    public static final PathElement PATH$gpuRenderStartTimeUs = PathElement.groupElement("gpuRenderStartTimeUs");
    public static final PathElement PATH$gpuRenderEndTimeUs = PathElement.groupElement("gpuRenderEndTimeUs");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$presentID = (OfLong) LAYOUT.select(PATH$presentID);
    public static final OfLong LAYOUT$inputSampleTimeUs = (OfLong) LAYOUT.select(PATH$inputSampleTimeUs);
    public static final OfLong LAYOUT$simStartTimeUs = (OfLong) LAYOUT.select(PATH$simStartTimeUs);
    public static final OfLong LAYOUT$simEndTimeUs = (OfLong) LAYOUT.select(PATH$simEndTimeUs);
    public static final OfLong LAYOUT$renderSubmitStartTimeUs = (OfLong) LAYOUT.select(PATH$renderSubmitStartTimeUs);
    public static final OfLong LAYOUT$renderSubmitEndTimeUs = (OfLong) LAYOUT.select(PATH$renderSubmitEndTimeUs);
    public static final OfLong LAYOUT$presentStartTimeUs = (OfLong) LAYOUT.select(PATH$presentStartTimeUs);
    public static final OfLong LAYOUT$presentEndTimeUs = (OfLong) LAYOUT.select(PATH$presentEndTimeUs);
    public static final OfLong LAYOUT$driverStartTimeUs = (OfLong) LAYOUT.select(PATH$driverStartTimeUs);
    public static final OfLong LAYOUT$driverEndTimeUs = (OfLong) LAYOUT.select(PATH$driverEndTimeUs);
    public static final OfLong LAYOUT$osRenderQueueStartTimeUs = (OfLong) LAYOUT.select(PATH$osRenderQueueStartTimeUs);
    public static final OfLong LAYOUT$osRenderQueueEndTimeUs = (OfLong) LAYOUT.select(PATH$osRenderQueueEndTimeUs);
    public static final OfLong LAYOUT$gpuRenderStartTimeUs = (OfLong) LAYOUT.select(PATH$gpuRenderStartTimeUs);
    public static final OfLong LAYOUT$gpuRenderEndTimeUs = (OfLong) LAYOUT.select(PATH$gpuRenderEndTimeUs);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$presentID = LAYOUT$presentID.byteSize();
    public static final long SIZE$inputSampleTimeUs = LAYOUT$inputSampleTimeUs.byteSize();
    public static final long SIZE$simStartTimeUs = LAYOUT$simStartTimeUs.byteSize();
    public static final long SIZE$simEndTimeUs = LAYOUT$simEndTimeUs.byteSize();
    public static final long SIZE$renderSubmitStartTimeUs = LAYOUT$renderSubmitStartTimeUs.byteSize();
    public static final long SIZE$renderSubmitEndTimeUs = LAYOUT$renderSubmitEndTimeUs.byteSize();
    public static final long SIZE$presentStartTimeUs = LAYOUT$presentStartTimeUs.byteSize();
    public static final long SIZE$presentEndTimeUs = LAYOUT$presentEndTimeUs.byteSize();
    public static final long SIZE$driverStartTimeUs = LAYOUT$driverStartTimeUs.byteSize();
    public static final long SIZE$driverEndTimeUs = LAYOUT$driverEndTimeUs.byteSize();
    public static final long SIZE$osRenderQueueStartTimeUs = LAYOUT$osRenderQueueStartTimeUs.byteSize();
    public static final long SIZE$osRenderQueueEndTimeUs = LAYOUT$osRenderQueueEndTimeUs.byteSize();
    public static final long SIZE$gpuRenderStartTimeUs = LAYOUT$gpuRenderStartTimeUs.byteSize();
    public static final long SIZE$gpuRenderEndTimeUs = LAYOUT$gpuRenderEndTimeUs.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$presentID = LAYOUT.byteOffset(PATH$presentID);
    public static final long OFFSET$inputSampleTimeUs = LAYOUT.byteOffset(PATH$inputSampleTimeUs);
    public static final long OFFSET$simStartTimeUs = LAYOUT.byteOffset(PATH$simStartTimeUs);
    public static final long OFFSET$simEndTimeUs = LAYOUT.byteOffset(PATH$simEndTimeUs);
    public static final long OFFSET$renderSubmitStartTimeUs = LAYOUT.byteOffset(PATH$renderSubmitStartTimeUs);
    public static final long OFFSET$renderSubmitEndTimeUs = LAYOUT.byteOffset(PATH$renderSubmitEndTimeUs);
    public static final long OFFSET$presentStartTimeUs = LAYOUT.byteOffset(PATH$presentStartTimeUs);
    public static final long OFFSET$presentEndTimeUs = LAYOUT.byteOffset(PATH$presentEndTimeUs);
    public static final long OFFSET$driverStartTimeUs = LAYOUT.byteOffset(PATH$driverStartTimeUs);
    public static final long OFFSET$driverEndTimeUs = LAYOUT.byteOffset(PATH$driverEndTimeUs);
    public static final long OFFSET$osRenderQueueStartTimeUs = LAYOUT.byteOffset(PATH$osRenderQueueStartTimeUs);
    public static final long OFFSET$osRenderQueueEndTimeUs = LAYOUT.byteOffset(PATH$osRenderQueueEndTimeUs);
    public static final long OFFSET$gpuRenderStartTimeUs = LAYOUT.byteOffset(PATH$gpuRenderStartTimeUs);
    public static final long OFFSET$gpuRenderEndTimeUs = LAYOUT.byteOffset(PATH$gpuRenderEndTimeUs);
}
