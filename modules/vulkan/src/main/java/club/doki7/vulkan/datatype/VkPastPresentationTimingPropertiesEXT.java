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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPastPresentationTimingPropertiesEXT.html"><code>VkPastPresentationTimingPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPastPresentationTimingPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint64_t timingPropertiesCounter; // @link substring="timingPropertiesCounter" target="#timingPropertiesCounter"
///     uint64_t timeDomainsCounter; // @link substring="timeDomainsCounter" target="#timeDomainsCounter"
///     uint32_t presentationTimingCount; // @link substring="presentationTimingCount" target="#presentationTimingCount"
///     VkPastPresentationTimingEXT* pPresentationTimings; // @link substring="VkPastPresentationTimingEXT" target="VkPastPresentationTimingEXT" @link substring="pPresentationTimings" target="#pPresentationTimings"
/// } VkPastPresentationTimingPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PAST_PRESENTATION_TIMING_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPastPresentationTimingPropertiesEXT#allocate(Arena)}, {@link VkPastPresentationTimingPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPastPresentationTimingPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPastPresentationTimingPropertiesEXT.html"><code>VkPastPresentationTimingPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPastPresentationTimingPropertiesEXT(@NotNull MemorySegment segment) implements IVkPastPresentationTimingPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPastPresentationTimingPropertiesEXT.html"><code>VkPastPresentationTimingPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPastPresentationTimingPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPastPresentationTimingPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPastPresentationTimingPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPastPresentationTimingPropertiesEXT, Iterable<VkPastPresentationTimingPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPastPresentationTimingPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPastPresentationTimingPropertiesEXT at(long index) {
            return new VkPastPresentationTimingPropertiesEXT(segment.asSlice(index * VkPastPresentationTimingPropertiesEXT.BYTES, VkPastPresentationTimingPropertiesEXT.BYTES));
        }

        public VkPastPresentationTimingPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPastPresentationTimingPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPastPresentationTimingPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPastPresentationTimingPropertiesEXT.BYTES, VkPastPresentationTimingPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPastPresentationTimingPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPastPresentationTimingPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPastPresentationTimingPropertiesEXT.BYTES,
                (end - start) * VkPastPresentationTimingPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPastPresentationTimingPropertiesEXT.BYTES));
        }

        public VkPastPresentationTimingPropertiesEXT[] toArray() {
            VkPastPresentationTimingPropertiesEXT[] ret = new VkPastPresentationTimingPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPastPresentationTimingPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPastPresentationTimingPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPastPresentationTimingPropertiesEXT.BYTES;
            }

            @Override
            public VkPastPresentationTimingPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPastPresentationTimingPropertiesEXT ret = new VkPastPresentationTimingPropertiesEXT(segment.asSlice(0, VkPastPresentationTimingPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPastPresentationTimingPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPastPresentationTimingPropertiesEXT allocate(Arena arena) {
        VkPastPresentationTimingPropertiesEXT ret = new VkPastPresentationTimingPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PAST_PRESENTATION_TIMING_PROPERTIES_EXT);
        return ret;
    }

    public static VkPastPresentationTimingPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPastPresentationTimingPropertiesEXT.Ptr ret = new VkPastPresentationTimingPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PAST_PRESENTATION_TIMING_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPastPresentationTimingPropertiesEXT clone(Arena arena, VkPastPresentationTimingPropertiesEXT src) {
        VkPastPresentationTimingPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PAST_PRESENTATION_TIMING_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPastPresentationTimingPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPastPresentationTimingPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPastPresentationTimingPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long timingPropertiesCounter() {
        return segment.get(LAYOUT$timingPropertiesCounter, OFFSET$timingPropertiesCounter);
    }

    public VkPastPresentationTimingPropertiesEXT timingPropertiesCounter(@Unsigned long value) {
        segment.set(LAYOUT$timingPropertiesCounter, OFFSET$timingPropertiesCounter, value);
        return this;
    }

    public @Unsigned long timeDomainsCounter() {
        return segment.get(LAYOUT$timeDomainsCounter, OFFSET$timeDomainsCounter);
    }

    public VkPastPresentationTimingPropertiesEXT timeDomainsCounter(@Unsigned long value) {
        segment.set(LAYOUT$timeDomainsCounter, OFFSET$timeDomainsCounter, value);
        return this;
    }

    public @Unsigned int presentationTimingCount() {
        return segment.get(LAYOUT$presentationTimingCount, OFFSET$presentationTimingCount);
    }

    public VkPastPresentationTimingPropertiesEXT presentationTimingCount(@Unsigned int value) {
        segment.set(LAYOUT$presentationTimingCount, OFFSET$presentationTimingCount, value);
        return this;
    }

    public VkPastPresentationTimingPropertiesEXT pPresentationTimings(@Nullable IVkPastPresentationTimingEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPresentationTimingsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPastPresentationTimingEXT.Ptr pPresentationTimings(int assumedCount) {
        MemorySegment s = pPresentationTimingsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPastPresentationTimingEXT.BYTES);
        return new VkPastPresentationTimingEXT.Ptr(s);
    }

    public @Nullable VkPastPresentationTimingEXT pPresentationTimings() {
        MemorySegment s = pPresentationTimingsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPastPresentationTimingEXT(s);
    }

    public @Pointer(target=VkPastPresentationTimingEXT.class) @NotNull MemorySegment pPresentationTimingsRaw() {
        return segment.get(LAYOUT$pPresentationTimings, OFFSET$pPresentationTimings);
    }

    public void pPresentationTimingsRaw(@Pointer(target=VkPastPresentationTimingEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPresentationTimings, OFFSET$pPresentationTimings, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("timingPropertiesCounter"),
        ValueLayout.JAVA_LONG.withName("timeDomainsCounter"),
        ValueLayout.JAVA_INT.withName("presentationTimingCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPastPresentationTimingEXT.LAYOUT).withName("pPresentationTimings")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$timingPropertiesCounter = PathElement.groupElement("timingPropertiesCounter");
    public static final PathElement PATH$timeDomainsCounter = PathElement.groupElement("timeDomainsCounter");
    public static final PathElement PATH$presentationTimingCount = PathElement.groupElement("presentationTimingCount");
    public static final PathElement PATH$pPresentationTimings = PathElement.groupElement("pPresentationTimings");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$timingPropertiesCounter = (OfLong) LAYOUT.select(PATH$timingPropertiesCounter);
    public static final OfLong LAYOUT$timeDomainsCounter = (OfLong) LAYOUT.select(PATH$timeDomainsCounter);
    public static final OfInt LAYOUT$presentationTimingCount = (OfInt) LAYOUT.select(PATH$presentationTimingCount);
    public static final AddressLayout LAYOUT$pPresentationTimings = (AddressLayout) LAYOUT.select(PATH$pPresentationTimings);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$timingPropertiesCounter = LAYOUT$timingPropertiesCounter.byteSize();
    public static final long SIZE$timeDomainsCounter = LAYOUT$timeDomainsCounter.byteSize();
    public static final long SIZE$presentationTimingCount = LAYOUT$presentationTimingCount.byteSize();
    public static final long SIZE$pPresentationTimings = LAYOUT$pPresentationTimings.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$timingPropertiesCounter = LAYOUT.byteOffset(PATH$timingPropertiesCounter);
    public static final long OFFSET$timeDomainsCounter = LAYOUT.byteOffset(PATH$timeDomainsCounter);
    public static final long OFFSET$presentationTimingCount = LAYOUT.byteOffset(PATH$presentationTimingCount);
    public static final long OFFSET$pPresentationTimings = LAYOUT.byteOffset(PATH$pPresentationTimings);
}
