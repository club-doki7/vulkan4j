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

/// Represents a pointer to a {@code StdVideoAV1CDEF} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1CDEF {
///     uint8_t cdef_damping_minus_3; // @link substring="cdef_damping_minus_3" target="#cdef_damping_minus_3"
///     uint8_t cdef_bits; // @link substring="cdef_bits" target="#cdef_bits"
///     uint8_t[STD_VIDEO_AV1_MAX_CDEF_FILTER_STRENGTHS] cdef_y_pri_strength; // @link substring="cdef_y_pri_strength" target="#cdef_y_pri_strength"
///     uint8_t[STD_VIDEO_AV1_MAX_CDEF_FILTER_STRENGTHS] cdef_y_sec_strength; // @link substring="cdef_y_sec_strength" target="#cdef_y_sec_strength"
///     uint8_t[STD_VIDEO_AV1_MAX_CDEF_FILTER_STRENGTHS] cdef_uv_pri_strength; // @link substring="cdef_uv_pri_strength" target="#cdef_uv_pri_strength"
///     uint8_t[STD_VIDEO_AV1_MAX_CDEF_FILTER_STRENGTHS] cdef_uv_sec_strength; // @link substring="cdef_uv_sec_strength" target="#cdef_uv_sec_strength"
/// } StdVideoAV1CDEF;
/// }
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
@ValueBasedCandidate
@UnsafeConstructor
public record StdVideoAV1CDEF(@NotNull MemorySegment segment) implements IStdVideoAV1CDEF {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1CDEF}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1CDEF to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1CDEF.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1CDEF, Iterable<StdVideoAV1CDEF> {
        public long size() {
            return segment.byteSize() / StdVideoAV1CDEF.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1CDEF at(long index) {
            return new StdVideoAV1CDEF(segment.asSlice(index * StdVideoAV1CDEF.BYTES, StdVideoAV1CDEF.BYTES));
        }

        public StdVideoAV1CDEF.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1CDEF> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1CDEF value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1CDEF.BYTES, StdVideoAV1CDEF.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1CDEF.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1CDEF.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1CDEF.BYTES,
                (end - start) * StdVideoAV1CDEF.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1CDEF.BYTES));
        }

        public StdVideoAV1CDEF[] toArray() {
            StdVideoAV1CDEF[] ret = new StdVideoAV1CDEF[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1CDEF> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1CDEF> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1CDEF.BYTES;
            }

            @Override
            public StdVideoAV1CDEF next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1CDEF ret = new StdVideoAV1CDEF(segment.asSlice(0, StdVideoAV1CDEF.BYTES));
                segment = segment.asSlice(StdVideoAV1CDEF.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1CDEF allocate(Arena arena) {
        return new StdVideoAV1CDEF(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1CDEF.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1CDEF.Ptr(segment);
    }

    public static StdVideoAV1CDEF clone(Arena arena, StdVideoAV1CDEF src) {
        StdVideoAV1CDEF ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned byte cdef_damping_minus_3() {
        return segment.get(LAYOUT$cdef_damping_minus_3, OFFSET$cdef_damping_minus_3);
    }

    public StdVideoAV1CDEF cdef_damping_minus_3(@Unsigned byte value) {
        segment.set(LAYOUT$cdef_damping_minus_3, OFFSET$cdef_damping_minus_3, value);
        return this;
    }

    public @Unsigned byte cdef_bits() {
        return segment.get(LAYOUT$cdef_bits, OFFSET$cdef_bits);
    }

    public StdVideoAV1CDEF cdef_bits(@Unsigned byte value) {
        segment.set(LAYOUT$cdef_bits, OFFSET$cdef_bits, value);
        return this;
    }

    public @Unsigned BytePtr cdef_y_pri_strength() {
        return new BytePtr(cdef_y_pri_strengthRaw());
    }

    public StdVideoAV1CDEF cdef_y_pri_strength(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = cdef_y_pri_strength();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1CDEF cdef_y_pri_strength(@Unsigned BytePtr value) {
        MemorySegment s = cdef_y_pri_strengthRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cdef_y_pri_strengthRaw() {
        return segment.asSlice(OFFSET$cdef_y_pri_strength, SIZE$cdef_y_pri_strength);
    }

    public @Unsigned BytePtr cdef_y_sec_strength() {
        return new BytePtr(cdef_y_sec_strengthRaw());
    }

    public StdVideoAV1CDEF cdef_y_sec_strength(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = cdef_y_sec_strength();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1CDEF cdef_y_sec_strength(@Unsigned BytePtr value) {
        MemorySegment s = cdef_y_sec_strengthRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cdef_y_sec_strengthRaw() {
        return segment.asSlice(OFFSET$cdef_y_sec_strength, SIZE$cdef_y_sec_strength);
    }

    public @Unsigned BytePtr cdef_uv_pri_strength() {
        return new BytePtr(cdef_uv_pri_strengthRaw());
    }

    public StdVideoAV1CDEF cdef_uv_pri_strength(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = cdef_uv_pri_strength();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1CDEF cdef_uv_pri_strength(@Unsigned BytePtr value) {
        MemorySegment s = cdef_uv_pri_strengthRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cdef_uv_pri_strengthRaw() {
        return segment.asSlice(OFFSET$cdef_uv_pri_strength, SIZE$cdef_uv_pri_strength);
    }

    public @Unsigned BytePtr cdef_uv_sec_strength() {
        return new BytePtr(cdef_uv_sec_strengthRaw());
    }

    public StdVideoAV1CDEF cdef_uv_sec_strength(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = cdef_uv_sec_strength();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1CDEF cdef_uv_sec_strength(@Unsigned BytePtr value) {
        MemorySegment s = cdef_uv_sec_strengthRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cdef_uv_sec_strengthRaw() {
        return segment.asSlice(OFFSET$cdef_uv_sec_strength, SIZE$cdef_uv_sec_strength);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_BYTE.withName("cdef_damping_minus_3"),
        ValueLayout.JAVA_BYTE.withName("cdef_bits"),
        MemoryLayout.sequenceLayout(AV1_MAX_CDEF_FILTER_STRENGTHS, ValueLayout.JAVA_BYTE).withName("cdef_y_pri_strength"),
        MemoryLayout.sequenceLayout(AV1_MAX_CDEF_FILTER_STRENGTHS, ValueLayout.JAVA_BYTE).withName("cdef_y_sec_strength"),
        MemoryLayout.sequenceLayout(AV1_MAX_CDEF_FILTER_STRENGTHS, ValueLayout.JAVA_BYTE).withName("cdef_uv_pri_strength"),
        MemoryLayout.sequenceLayout(AV1_MAX_CDEF_FILTER_STRENGTHS, ValueLayout.JAVA_BYTE).withName("cdef_uv_sec_strength")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$cdef_damping_minus_3 = PathElement.groupElement("cdef_damping_minus_3");
    public static final PathElement PATH$cdef_bits = PathElement.groupElement("cdef_bits");
    public static final PathElement PATH$cdef_y_pri_strength = PathElement.groupElement("cdef_y_pri_strength");
    public static final PathElement PATH$cdef_y_sec_strength = PathElement.groupElement("cdef_y_sec_strength");
    public static final PathElement PATH$cdef_uv_pri_strength = PathElement.groupElement("cdef_uv_pri_strength");
    public static final PathElement PATH$cdef_uv_sec_strength = PathElement.groupElement("cdef_uv_sec_strength");

    public static final OfByte LAYOUT$cdef_damping_minus_3 = (OfByte) LAYOUT.select(PATH$cdef_damping_minus_3);
    public static final OfByte LAYOUT$cdef_bits = (OfByte) LAYOUT.select(PATH$cdef_bits);
    public static final SequenceLayout LAYOUT$cdef_y_pri_strength = (SequenceLayout) LAYOUT.select(PATH$cdef_y_pri_strength);
    public static final SequenceLayout LAYOUT$cdef_y_sec_strength = (SequenceLayout) LAYOUT.select(PATH$cdef_y_sec_strength);
    public static final SequenceLayout LAYOUT$cdef_uv_pri_strength = (SequenceLayout) LAYOUT.select(PATH$cdef_uv_pri_strength);
    public static final SequenceLayout LAYOUT$cdef_uv_sec_strength = (SequenceLayout) LAYOUT.select(PATH$cdef_uv_sec_strength);

    public static final long SIZE$cdef_damping_minus_3 = LAYOUT$cdef_damping_minus_3.byteSize();
    public static final long SIZE$cdef_bits = LAYOUT$cdef_bits.byteSize();
    public static final long SIZE$cdef_y_pri_strength = LAYOUT$cdef_y_pri_strength.byteSize();
    public static final long SIZE$cdef_y_sec_strength = LAYOUT$cdef_y_sec_strength.byteSize();
    public static final long SIZE$cdef_uv_pri_strength = LAYOUT$cdef_uv_pri_strength.byteSize();
    public static final long SIZE$cdef_uv_sec_strength = LAYOUT$cdef_uv_sec_strength.byteSize();

    public static final long OFFSET$cdef_damping_minus_3 = LAYOUT.byteOffset(PATH$cdef_damping_minus_3);
    public static final long OFFSET$cdef_bits = LAYOUT.byteOffset(PATH$cdef_bits);
    public static final long OFFSET$cdef_y_pri_strength = LAYOUT.byteOffset(PATH$cdef_y_pri_strength);
    public static final long OFFSET$cdef_y_sec_strength = LAYOUT.byteOffset(PATH$cdef_y_sec_strength);
    public static final long OFFSET$cdef_uv_pri_strength = LAYOUT.byteOffset(PATH$cdef_uv_pri_strength);
    public static final long OFFSET$cdef_uv_sec_strength = LAYOUT.byteOffset(PATH$cdef_uv_sec_strength);
}
