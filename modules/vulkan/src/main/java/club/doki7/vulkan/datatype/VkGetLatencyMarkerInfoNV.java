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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGetLatencyMarkerInfoNV.html"><code>VkGetLatencyMarkerInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGetLatencyMarkerInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t timingCount; // optional // @link substring="timingCount" target="#timingCount"
///     VkLatencyTimingsFrameReportNV* pTimings; // optional // @link substring="VkLatencyTimingsFrameReportNV" target="VkLatencyTimingsFrameReportNV" @link substring="pTimings" target="#pTimings"
/// } VkGetLatencyMarkerInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GET_LATENCY_MARKER_INFO_NV`
///
/// The {@code allocate} ({@link VkGetLatencyMarkerInfoNV#allocate(Arena)}, {@link VkGetLatencyMarkerInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGetLatencyMarkerInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGetLatencyMarkerInfoNV.html"><code>VkGetLatencyMarkerInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGetLatencyMarkerInfoNV(@NotNull MemorySegment segment) implements IVkGetLatencyMarkerInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGetLatencyMarkerInfoNV.html"><code>VkGetLatencyMarkerInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGetLatencyMarkerInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGetLatencyMarkerInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGetLatencyMarkerInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGetLatencyMarkerInfoNV, Iterable<VkGetLatencyMarkerInfoNV> {
        public long size() {
            return segment.byteSize() / VkGetLatencyMarkerInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGetLatencyMarkerInfoNV at(long index) {
            return new VkGetLatencyMarkerInfoNV(segment.asSlice(index * VkGetLatencyMarkerInfoNV.BYTES, VkGetLatencyMarkerInfoNV.BYTES));
        }

        public VkGetLatencyMarkerInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkGetLatencyMarkerInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGetLatencyMarkerInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkGetLatencyMarkerInfoNV.BYTES, VkGetLatencyMarkerInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGetLatencyMarkerInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGetLatencyMarkerInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGetLatencyMarkerInfoNV.BYTES,
                (end - start) * VkGetLatencyMarkerInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGetLatencyMarkerInfoNV.BYTES));
        }

        public VkGetLatencyMarkerInfoNV[] toArray() {
            VkGetLatencyMarkerInfoNV[] ret = new VkGetLatencyMarkerInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGetLatencyMarkerInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGetLatencyMarkerInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGetLatencyMarkerInfoNV.BYTES;
            }

            @Override
            public VkGetLatencyMarkerInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGetLatencyMarkerInfoNV ret = new VkGetLatencyMarkerInfoNV(segment.asSlice(0, VkGetLatencyMarkerInfoNV.BYTES));
                segment = segment.asSlice(VkGetLatencyMarkerInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGetLatencyMarkerInfoNV allocate(Arena arena) {
        VkGetLatencyMarkerInfoNV ret = new VkGetLatencyMarkerInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GET_LATENCY_MARKER_INFO_NV);
        return ret;
    }

    public static VkGetLatencyMarkerInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGetLatencyMarkerInfoNV.Ptr ret = new VkGetLatencyMarkerInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GET_LATENCY_MARKER_INFO_NV);
        }
        return ret;
    }

    public static VkGetLatencyMarkerInfoNV clone(Arena arena, VkGetLatencyMarkerInfoNV src) {
        VkGetLatencyMarkerInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GET_LATENCY_MARKER_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGetLatencyMarkerInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGetLatencyMarkerInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGetLatencyMarkerInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int timingCount() {
        return segment.get(LAYOUT$timingCount, OFFSET$timingCount);
    }

    public VkGetLatencyMarkerInfoNV timingCount(@Unsigned int value) {
        segment.set(LAYOUT$timingCount, OFFSET$timingCount, value);
        return this;
    }

    public VkGetLatencyMarkerInfoNV pTimings(@Nullable IVkLatencyTimingsFrameReportNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTimingsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkLatencyTimingsFrameReportNV.Ptr pTimings(int assumedCount) {
        MemorySegment s = pTimingsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkLatencyTimingsFrameReportNV.BYTES);
        return new VkLatencyTimingsFrameReportNV.Ptr(s);
    }

    public @Nullable VkLatencyTimingsFrameReportNV pTimings() {
        MemorySegment s = pTimingsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkLatencyTimingsFrameReportNV(s);
    }

    public @Pointer(target=VkLatencyTimingsFrameReportNV.class) @NotNull MemorySegment pTimingsRaw() {
        return segment.get(LAYOUT$pTimings, OFFSET$pTimings);
    }

    public void pTimingsRaw(@Pointer(target=VkLatencyTimingsFrameReportNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTimings, OFFSET$pTimings, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("timingCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkLatencyTimingsFrameReportNV.LAYOUT).withName("pTimings")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$timingCount = PathElement.groupElement("timingCount");
    public static final PathElement PATH$pTimings = PathElement.groupElement("pTimings");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$timingCount = (OfInt) LAYOUT.select(PATH$timingCount);
    public static final AddressLayout LAYOUT$pTimings = (AddressLayout) LAYOUT.select(PATH$pTimings);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$timingCount = LAYOUT$timingCount.byteSize();
    public static final long SIZE$pTimings = LAYOUT$pTimings.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$timingCount = LAYOUT.byteOffset(PATH$timingCount);
    public static final long OFFSET$pTimings = LAYOUT.byteOffset(PATH$pTimings);
}
