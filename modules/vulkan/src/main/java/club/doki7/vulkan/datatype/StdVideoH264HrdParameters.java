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

/// Represents a pointer to a {@code StdVideoH264HrdParameters} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH264HrdParameters {
///     uint8_t cpb_cnt_minus1; // @link substring="cpb_cnt_minus1" target="#cpb_cnt_minus1"
///     uint8_t bit_rate_scale; // @link substring="bit_rate_scale" target="#bit_rate_scale"
///     uint8_t cpb_size_scale; // @link substring="cpb_size_scale" target="#cpb_size_scale"
///     uint8_t reserved1;
///     uint32_t[STD_VIDEO_H264_CPB_CNT_LIST_SIZE] bit_rate_value_minus1; // @link substring="bit_rate_value_minus1" target="#bit_rate_value_minus1"
///     uint32_t[STD_VIDEO_H264_CPB_CNT_LIST_SIZE] cpb_size_value_minus1; // @link substring="cpb_size_value_minus1" target="#cpb_size_value_minus1"
///     uint8_t[STD_VIDEO_H264_CPB_CNT_LIST_SIZE] cbr_flag; // @link substring="cbr_flag" target="#cbr_flag"
///     uint32_t initial_cpb_removal_delay_length_minus1; // @link substring="initial_cpb_removal_delay_length_minus1" target="#initial_cpb_removal_delay_length_minus1"
///     uint32_t cpb_removal_delay_length_minus1; // @link substring="cpb_removal_delay_length_minus1" target="#cpb_removal_delay_length_minus1"
///     uint32_t dpb_output_delay_length_minus1; // @link substring="dpb_output_delay_length_minus1" target="#dpb_output_delay_length_minus1"
///     uint32_t time_offset_length; // @link substring="time_offset_length" target="#time_offset_length"
/// } StdVideoH264HrdParameters;
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
public record StdVideoH264HrdParameters(@NotNull MemorySegment segment) implements IStdVideoH264HrdParameters {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH264HrdParameters}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH264HrdParameters to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH264HrdParameters.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH264HrdParameters, Iterable<StdVideoH264HrdParameters> {
        public long size() {
            return segment.byteSize() / StdVideoH264HrdParameters.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH264HrdParameters at(long index) {
            return new StdVideoH264HrdParameters(segment.asSlice(index * StdVideoH264HrdParameters.BYTES, StdVideoH264HrdParameters.BYTES));
        }

        public StdVideoH264HrdParameters.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH264HrdParameters> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH264HrdParameters value) {
            MemorySegment s = segment.asSlice(index * StdVideoH264HrdParameters.BYTES, StdVideoH264HrdParameters.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH264HrdParameters.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH264HrdParameters.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH264HrdParameters.BYTES,
                (end - start) * StdVideoH264HrdParameters.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH264HrdParameters.BYTES));
        }

        public StdVideoH264HrdParameters[] toArray() {
            StdVideoH264HrdParameters[] ret = new StdVideoH264HrdParameters[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH264HrdParameters> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH264HrdParameters> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH264HrdParameters.BYTES;
            }

            @Override
            public StdVideoH264HrdParameters next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH264HrdParameters ret = new StdVideoH264HrdParameters(segment.asSlice(0, StdVideoH264HrdParameters.BYTES));
                segment = segment.asSlice(StdVideoH264HrdParameters.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH264HrdParameters allocate(Arena arena) {
        return new StdVideoH264HrdParameters(arena.allocate(LAYOUT));
    }

    public static StdVideoH264HrdParameters.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH264HrdParameters.Ptr(segment);
    }

    public static StdVideoH264HrdParameters clone(Arena arena, StdVideoH264HrdParameters src) {
        StdVideoH264HrdParameters ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned byte cpb_cnt_minus1() {
        return segment.get(LAYOUT$cpb_cnt_minus1, OFFSET$cpb_cnt_minus1);
    }

    public StdVideoH264HrdParameters cpb_cnt_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$cpb_cnt_minus1, OFFSET$cpb_cnt_minus1, value);
        return this;
    }

    public @Unsigned byte bit_rate_scale() {
        return segment.get(LAYOUT$bit_rate_scale, OFFSET$bit_rate_scale);
    }

    public StdVideoH264HrdParameters bit_rate_scale(@Unsigned byte value) {
        segment.set(LAYOUT$bit_rate_scale, OFFSET$bit_rate_scale, value);
        return this;
    }

    public @Unsigned byte cpb_size_scale() {
        return segment.get(LAYOUT$cpb_size_scale, OFFSET$cpb_size_scale);
    }

    public StdVideoH264HrdParameters cpb_size_scale(@Unsigned byte value) {
        segment.set(LAYOUT$cpb_size_scale, OFFSET$cpb_size_scale, value);
        return this;
    }


    public @Unsigned IntPtr bit_rate_value_minus1() {
        return new IntPtr(bit_rate_value_minus1Raw());
    }

    public StdVideoH264HrdParameters bit_rate_value_minus1(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = bit_rate_value_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH264HrdParameters bit_rate_value_minus1(@Unsigned IntPtr value) {
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

    public StdVideoH264HrdParameters cpb_size_value_minus1(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = cpb_size_value_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH264HrdParameters cpb_size_value_minus1(@Unsigned IntPtr value) {
        MemorySegment s = cpb_size_value_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cpb_size_value_minus1Raw() {
        return segment.asSlice(OFFSET$cpb_size_value_minus1, SIZE$cpb_size_value_minus1);
    }

    public @Unsigned BytePtr cbr_flag() {
        return new BytePtr(cbr_flagRaw());
    }

    public StdVideoH264HrdParameters cbr_flag(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = cbr_flag();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH264HrdParameters cbr_flag(@Unsigned BytePtr value) {
        MemorySegment s = cbr_flagRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment cbr_flagRaw() {
        return segment.asSlice(OFFSET$cbr_flag, SIZE$cbr_flag);
    }

    public @Unsigned int initial_cpb_removal_delay_length_minus1() {
        return segment.get(LAYOUT$initial_cpb_removal_delay_length_minus1, OFFSET$initial_cpb_removal_delay_length_minus1);
    }

    public StdVideoH264HrdParameters initial_cpb_removal_delay_length_minus1(@Unsigned int value) {
        segment.set(LAYOUT$initial_cpb_removal_delay_length_minus1, OFFSET$initial_cpb_removal_delay_length_minus1, value);
        return this;
    }

    public @Unsigned int cpb_removal_delay_length_minus1() {
        return segment.get(LAYOUT$cpb_removal_delay_length_minus1, OFFSET$cpb_removal_delay_length_minus1);
    }

    public StdVideoH264HrdParameters cpb_removal_delay_length_minus1(@Unsigned int value) {
        segment.set(LAYOUT$cpb_removal_delay_length_minus1, OFFSET$cpb_removal_delay_length_minus1, value);
        return this;
    }

    public @Unsigned int dpb_output_delay_length_minus1() {
        return segment.get(LAYOUT$dpb_output_delay_length_minus1, OFFSET$dpb_output_delay_length_minus1);
    }

    public StdVideoH264HrdParameters dpb_output_delay_length_minus1(@Unsigned int value) {
        segment.set(LAYOUT$dpb_output_delay_length_minus1, OFFSET$dpb_output_delay_length_minus1, value);
        return this;
    }

    public @Unsigned int time_offset_length() {
        return segment.get(LAYOUT$time_offset_length, OFFSET$time_offset_length);
    }

    public StdVideoH264HrdParameters time_offset_length(@Unsigned int value) {
        segment.set(LAYOUT$time_offset_length, OFFSET$time_offset_length, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_BYTE.withName("cpb_cnt_minus1"),
        ValueLayout.JAVA_BYTE.withName("bit_rate_scale"),
        ValueLayout.JAVA_BYTE.withName("cpb_size_scale"),
        ValueLayout.JAVA_BYTE.withName("reserved1"),
        MemoryLayout.sequenceLayout(H264_CPB_CNT_LIST_SIZE, ValueLayout.JAVA_INT).withName("bit_rate_value_minus1"),
        MemoryLayout.sequenceLayout(H264_CPB_CNT_LIST_SIZE, ValueLayout.JAVA_INT).withName("cpb_size_value_minus1"),
        MemoryLayout.sequenceLayout(H264_CPB_CNT_LIST_SIZE, ValueLayout.JAVA_BYTE).withName("cbr_flag"),
        ValueLayout.JAVA_INT.withName("initial_cpb_removal_delay_length_minus1"),
        ValueLayout.JAVA_INT.withName("cpb_removal_delay_length_minus1"),
        ValueLayout.JAVA_INT.withName("dpb_output_delay_length_minus1"),
        ValueLayout.JAVA_INT.withName("time_offset_length")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$cpb_cnt_minus1 = PathElement.groupElement("cpb_cnt_minus1");
    public static final PathElement PATH$bit_rate_scale = PathElement.groupElement("bit_rate_scale");
    public static final PathElement PATH$cpb_size_scale = PathElement.groupElement("cpb_size_scale");
    public static final PathElement PATH$bit_rate_value_minus1 = PathElement.groupElement("bit_rate_value_minus1");
    public static final PathElement PATH$cpb_size_value_minus1 = PathElement.groupElement("cpb_size_value_minus1");
    public static final PathElement PATH$cbr_flag = PathElement.groupElement("cbr_flag");
    public static final PathElement PATH$initial_cpb_removal_delay_length_minus1 = PathElement.groupElement("initial_cpb_removal_delay_length_minus1");
    public static final PathElement PATH$cpb_removal_delay_length_minus1 = PathElement.groupElement("cpb_removal_delay_length_minus1");
    public static final PathElement PATH$dpb_output_delay_length_minus1 = PathElement.groupElement("dpb_output_delay_length_minus1");
    public static final PathElement PATH$time_offset_length = PathElement.groupElement("time_offset_length");

    public static final OfByte LAYOUT$cpb_cnt_minus1 = (OfByte) LAYOUT.select(PATH$cpb_cnt_minus1);
    public static final OfByte LAYOUT$bit_rate_scale = (OfByte) LAYOUT.select(PATH$bit_rate_scale);
    public static final OfByte LAYOUT$cpb_size_scale = (OfByte) LAYOUT.select(PATH$cpb_size_scale);
    public static final SequenceLayout LAYOUT$bit_rate_value_minus1 = (SequenceLayout) LAYOUT.select(PATH$bit_rate_value_minus1);
    public static final SequenceLayout LAYOUT$cpb_size_value_minus1 = (SequenceLayout) LAYOUT.select(PATH$cpb_size_value_minus1);
    public static final SequenceLayout LAYOUT$cbr_flag = (SequenceLayout) LAYOUT.select(PATH$cbr_flag);
    public static final OfInt LAYOUT$initial_cpb_removal_delay_length_minus1 = (OfInt) LAYOUT.select(PATH$initial_cpb_removal_delay_length_minus1);
    public static final OfInt LAYOUT$cpb_removal_delay_length_minus1 = (OfInt) LAYOUT.select(PATH$cpb_removal_delay_length_minus1);
    public static final OfInt LAYOUT$dpb_output_delay_length_minus1 = (OfInt) LAYOUT.select(PATH$dpb_output_delay_length_minus1);
    public static final OfInt LAYOUT$time_offset_length = (OfInt) LAYOUT.select(PATH$time_offset_length);

    public static final long SIZE$cpb_cnt_minus1 = LAYOUT$cpb_cnt_minus1.byteSize();
    public static final long SIZE$bit_rate_scale = LAYOUT$bit_rate_scale.byteSize();
    public static final long SIZE$cpb_size_scale = LAYOUT$cpb_size_scale.byteSize();
    public static final long SIZE$bit_rate_value_minus1 = LAYOUT$bit_rate_value_minus1.byteSize();
    public static final long SIZE$cpb_size_value_minus1 = LAYOUT$cpb_size_value_minus1.byteSize();
    public static final long SIZE$cbr_flag = LAYOUT$cbr_flag.byteSize();
    public static final long SIZE$initial_cpb_removal_delay_length_minus1 = LAYOUT$initial_cpb_removal_delay_length_minus1.byteSize();
    public static final long SIZE$cpb_removal_delay_length_minus1 = LAYOUT$cpb_removal_delay_length_minus1.byteSize();
    public static final long SIZE$dpb_output_delay_length_minus1 = LAYOUT$dpb_output_delay_length_minus1.byteSize();
    public static final long SIZE$time_offset_length = LAYOUT$time_offset_length.byteSize();

    public static final long OFFSET$cpb_cnt_minus1 = LAYOUT.byteOffset(PATH$cpb_cnt_minus1);
    public static final long OFFSET$bit_rate_scale = LAYOUT.byteOffset(PATH$bit_rate_scale);
    public static final long OFFSET$cpb_size_scale = LAYOUT.byteOffset(PATH$cpb_size_scale);
    public static final long OFFSET$bit_rate_value_minus1 = LAYOUT.byteOffset(PATH$bit_rate_value_minus1);
    public static final long OFFSET$cpb_size_value_minus1 = LAYOUT.byteOffset(PATH$cpb_size_value_minus1);
    public static final long OFFSET$cbr_flag = LAYOUT.byteOffset(PATH$cbr_flag);
    public static final long OFFSET$initial_cpb_removal_delay_length_minus1 = LAYOUT.byteOffset(PATH$initial_cpb_removal_delay_length_minus1);
    public static final long OFFSET$cpb_removal_delay_length_minus1 = LAYOUT.byteOffset(PATH$cpb_removal_delay_length_minus1);
    public static final long OFFSET$dpb_output_delay_length_minus1 = LAYOUT.byteOffset(PATH$dpb_output_delay_length_minus1);
    public static final long OFFSET$time_offset_length = LAYOUT.byteOffset(PATH$time_offset_length);
}
