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

/// Represents a pointer to a {@code StdVideoH265SubLayerHrdParameters} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265SubLayerHrdParameters {
///     uint32_t[STD_VIDEO_H265_CPB_CNT_LIST_SIZE] bit_rate_value_minus1; // @link substring="bit_rate_value_minus1" target="#bit_rate_value_minus1"
///     uint32_t[STD_VIDEO_H265_CPB_CNT_LIST_SIZE] cpb_size_value_minus1; // @link substring="cpb_size_value_minus1" target="#cpb_size_value_minus1"
///     uint32_t[STD_VIDEO_H265_CPB_CNT_LIST_SIZE] cpb_size_du_value_minus1; // @link substring="cpb_size_du_value_minus1" target="#cpb_size_du_value_minus1"
///     uint32_t[STD_VIDEO_H265_CPB_CNT_LIST_SIZE] bit_rate_du_value_minus1; // @link substring="bit_rate_du_value_minus1" target="#bit_rate_du_value_minus1"
///     uint32_t cbr_flag; // @link substring="cbr_flag" target="#cbr_flag"
/// } StdVideoH265SubLayerHrdParameters;
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
public record StdVideoH265SubLayerHrdParameters(@NotNull MemorySegment segment) implements IStdVideoH265SubLayerHrdParameters {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265SubLayerHrdParameters}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265SubLayerHrdParameters to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265SubLayerHrdParameters.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265SubLayerHrdParameters, Iterable<StdVideoH265SubLayerHrdParameters> {
        public long size() {
            return segment.byteSize() / StdVideoH265SubLayerHrdParameters.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265SubLayerHrdParameters at(long index) {
            return new StdVideoH265SubLayerHrdParameters(segment.asSlice(index * StdVideoH265SubLayerHrdParameters.BYTES, StdVideoH265SubLayerHrdParameters.BYTES));
        }

        public StdVideoH265SubLayerHrdParameters.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265SubLayerHrdParameters> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265SubLayerHrdParameters value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265SubLayerHrdParameters.BYTES, StdVideoH265SubLayerHrdParameters.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265SubLayerHrdParameters.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265SubLayerHrdParameters.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265SubLayerHrdParameters.BYTES,
                (end - start) * StdVideoH265SubLayerHrdParameters.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265SubLayerHrdParameters.BYTES));
        }

        public StdVideoH265SubLayerHrdParameters[] toArray() {
            StdVideoH265SubLayerHrdParameters[] ret = new StdVideoH265SubLayerHrdParameters[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265SubLayerHrdParameters> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265SubLayerHrdParameters> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265SubLayerHrdParameters.BYTES;
            }

            @Override
            public StdVideoH265SubLayerHrdParameters next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265SubLayerHrdParameters ret = new StdVideoH265SubLayerHrdParameters(segment.asSlice(0, StdVideoH265SubLayerHrdParameters.BYTES));
                segment = segment.asSlice(StdVideoH265SubLayerHrdParameters.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265SubLayerHrdParameters allocate(Arena arena) {
        return new StdVideoH265SubLayerHrdParameters(arena.allocate(LAYOUT));
    }

    public static StdVideoH265SubLayerHrdParameters.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265SubLayerHrdParameters.Ptr(segment);
    }

    public static StdVideoH265SubLayerHrdParameters clone(Arena arena, StdVideoH265SubLayerHrdParameters src) {
        StdVideoH265SubLayerHrdParameters ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned IntPtr bit_rate_value_minus1() {
        return new IntPtr(bit_rate_value_minus1Raw());
    }

    public StdVideoH265SubLayerHrdParameters bit_rate_value_minus1(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = bit_rate_value_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265SubLayerHrdParameters bit_rate_value_minus1(@Unsigned IntPtr value) {
        MemorySegment s = bit_rate_value_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment bit_rate_value_minus1Raw() {
        return segment.asSlice(OFFSET$bit_rate_value_minus1, SIZE$bit_rate_value_minus1);
    }

    public @Unsigned IntPtr cpb_size_value_minus1() {
        return new IntPtr(cpb_size_value_minus1Raw());
    }

    public StdVideoH265SubLayerHrdParameters cpb_size_value_minus1(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = cpb_size_value_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265SubLayerHrdParameters cpb_size_value_minus1(@Unsigned IntPtr value) {
        MemorySegment s = cpb_size_value_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cpb_size_value_minus1Raw() {
        return segment.asSlice(OFFSET$cpb_size_value_minus1, SIZE$cpb_size_value_minus1);
    }

    public @Unsigned IntPtr cpb_size_du_value_minus1() {
        return new IntPtr(cpb_size_du_value_minus1Raw());
    }

    public StdVideoH265SubLayerHrdParameters cpb_size_du_value_minus1(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = cpb_size_du_value_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265SubLayerHrdParameters cpb_size_du_value_minus1(@Unsigned IntPtr value) {
        MemorySegment s = cpb_size_du_value_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cpb_size_du_value_minus1Raw() {
        return segment.asSlice(OFFSET$cpb_size_du_value_minus1, SIZE$cpb_size_du_value_minus1);
    }

    public @Unsigned IntPtr bit_rate_du_value_minus1() {
        return new IntPtr(bit_rate_du_value_minus1Raw());
    }

    public StdVideoH265SubLayerHrdParameters bit_rate_du_value_minus1(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = bit_rate_du_value_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265SubLayerHrdParameters bit_rate_du_value_minus1(@Unsigned IntPtr value) {
        MemorySegment s = bit_rate_du_value_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment bit_rate_du_value_minus1Raw() {
        return segment.asSlice(OFFSET$bit_rate_du_value_minus1, SIZE$bit_rate_du_value_minus1);
    }

    public @Unsigned int cbr_flag() {
        return segment.get(LAYOUT$cbr_flag, OFFSET$cbr_flag);
    }

    public StdVideoH265SubLayerHrdParameters cbr_flag(@Unsigned int value) {
        segment.set(LAYOUT$cbr_flag, OFFSET$cbr_flag, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(H265_CPB_CNT_LIST_SIZE, ValueLayout.JAVA_INT).withName("bit_rate_value_minus1"),
        MemoryLayout.sequenceLayout(H265_CPB_CNT_LIST_SIZE, ValueLayout.JAVA_INT).withName("cpb_size_value_minus1"),
        MemoryLayout.sequenceLayout(H265_CPB_CNT_LIST_SIZE, ValueLayout.JAVA_INT).withName("cpb_size_du_value_minus1"),
        MemoryLayout.sequenceLayout(H265_CPB_CNT_LIST_SIZE, ValueLayout.JAVA_INT).withName("bit_rate_du_value_minus1"),
        ValueLayout.JAVA_INT.withName("cbr_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bit_rate_value_minus1 = PathElement.groupElement("bit_rate_value_minus1");
    public static final PathElement PATH$cpb_size_value_minus1 = PathElement.groupElement("cpb_size_value_minus1");
    public static final PathElement PATH$cpb_size_du_value_minus1 = PathElement.groupElement("cpb_size_du_value_minus1");
    public static final PathElement PATH$bit_rate_du_value_minus1 = PathElement.groupElement("bit_rate_du_value_minus1");
    public static final PathElement PATH$cbr_flag = PathElement.groupElement("cbr_flag");

    public static final SequenceLayout LAYOUT$bit_rate_value_minus1 = (SequenceLayout) LAYOUT.select(PATH$bit_rate_value_minus1);
    public static final SequenceLayout LAYOUT$cpb_size_value_minus1 = (SequenceLayout) LAYOUT.select(PATH$cpb_size_value_minus1);
    public static final SequenceLayout LAYOUT$cpb_size_du_value_minus1 = (SequenceLayout) LAYOUT.select(PATH$cpb_size_du_value_minus1);
    public static final SequenceLayout LAYOUT$bit_rate_du_value_minus1 = (SequenceLayout) LAYOUT.select(PATH$bit_rate_du_value_minus1);
    public static final OfInt LAYOUT$cbr_flag = (OfInt) LAYOUT.select(PATH$cbr_flag);

    public static final long SIZE$bit_rate_value_minus1 = LAYOUT$bit_rate_value_minus1.byteSize();
    public static final long SIZE$cpb_size_value_minus1 = LAYOUT$cpb_size_value_minus1.byteSize();
    public static final long SIZE$cpb_size_du_value_minus1 = LAYOUT$cpb_size_du_value_minus1.byteSize();
    public static final long SIZE$bit_rate_du_value_minus1 = LAYOUT$bit_rate_du_value_minus1.byteSize();
    public static final long SIZE$cbr_flag = LAYOUT$cbr_flag.byteSize();

    public static final long OFFSET$bit_rate_value_minus1 = LAYOUT.byteOffset(PATH$bit_rate_value_minus1);
    public static final long OFFSET$cpb_size_value_minus1 = LAYOUT.byteOffset(PATH$cpb_size_value_minus1);
    public static final long OFFSET$cpb_size_du_value_minus1 = LAYOUT.byteOffset(PATH$cpb_size_du_value_minus1);
    public static final long OFFSET$bit_rate_du_value_minus1 = LAYOUT.byteOffset(PATH$bit_rate_du_value_minus1);
    public static final long OFFSET$cbr_flag = LAYOUT.byteOffset(PATH$cbr_flag);
}
