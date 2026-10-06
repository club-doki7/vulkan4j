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

/// Represents a pointer to a {@code StdVideoEncodeAV1DecoderModelInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeAV1DecoderModelInfo {
///     uint8_t buffer_delay_length_minus_1; // @link substring="buffer_delay_length_minus_1" target="#buffer_delay_length_minus_1"
///     uint8_t buffer_removal_time_length_minus_1; // @link substring="buffer_removal_time_length_minus_1" target="#buffer_removal_time_length_minus_1"
///     uint8_t frame_presentation_time_length_minus_1; // @link substring="frame_presentation_time_length_minus_1" target="#frame_presentation_time_length_minus_1"
///     uint8_t reserved1;
///     uint32_t num_units_in_decoding_tick; // @link substring="num_units_in_decoding_tick" target="#num_units_in_decoding_tick"
/// } StdVideoEncodeAV1DecoderModelInfo;
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
public record StdVideoEncodeAV1DecoderModelInfo(@NotNull MemorySegment segment) implements IStdVideoEncodeAV1DecoderModelInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeAV1DecoderModelInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeAV1DecoderModelInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeAV1DecoderModelInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeAV1DecoderModelInfo, Iterable<StdVideoEncodeAV1DecoderModelInfo> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeAV1DecoderModelInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeAV1DecoderModelInfo at(long index) {
            return new StdVideoEncodeAV1DecoderModelInfo(segment.asSlice(index * StdVideoEncodeAV1DecoderModelInfo.BYTES, StdVideoEncodeAV1DecoderModelInfo.BYTES));
        }

        public StdVideoEncodeAV1DecoderModelInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeAV1DecoderModelInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeAV1DecoderModelInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeAV1DecoderModelInfo.BYTES, StdVideoEncodeAV1DecoderModelInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeAV1DecoderModelInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeAV1DecoderModelInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeAV1DecoderModelInfo.BYTES,
                (end - start) * StdVideoEncodeAV1DecoderModelInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeAV1DecoderModelInfo.BYTES));
        }

        public StdVideoEncodeAV1DecoderModelInfo[] toArray() {
            StdVideoEncodeAV1DecoderModelInfo[] ret = new StdVideoEncodeAV1DecoderModelInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeAV1DecoderModelInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeAV1DecoderModelInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeAV1DecoderModelInfo.BYTES;
            }

            @Override
            public StdVideoEncodeAV1DecoderModelInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeAV1DecoderModelInfo ret = new StdVideoEncodeAV1DecoderModelInfo(segment.asSlice(0, StdVideoEncodeAV1DecoderModelInfo.BYTES));
                segment = segment.asSlice(StdVideoEncodeAV1DecoderModelInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeAV1DecoderModelInfo allocate(Arena arena) {
        return new StdVideoEncodeAV1DecoderModelInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeAV1DecoderModelInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeAV1DecoderModelInfo.Ptr(segment);
    }

    public static StdVideoEncodeAV1DecoderModelInfo clone(Arena arena, StdVideoEncodeAV1DecoderModelInfo src) {
        StdVideoEncodeAV1DecoderModelInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned byte buffer_delay_length_minus_1() {
        return segment.get(LAYOUT$buffer_delay_length_minus_1, OFFSET$buffer_delay_length_minus_1);
    }

    public StdVideoEncodeAV1DecoderModelInfo buffer_delay_length_minus_1(@Unsigned byte value) {
        segment.set(LAYOUT$buffer_delay_length_minus_1, OFFSET$buffer_delay_length_minus_1, value);
        return this;
    }

    public @Unsigned byte buffer_removal_time_length_minus_1() {
        return segment.get(LAYOUT$buffer_removal_time_length_minus_1, OFFSET$buffer_removal_time_length_minus_1);
    }

    public StdVideoEncodeAV1DecoderModelInfo buffer_removal_time_length_minus_1(@Unsigned byte value) {
        segment.set(LAYOUT$buffer_removal_time_length_minus_1, OFFSET$buffer_removal_time_length_minus_1, value);
        return this;
    }

    public @Unsigned byte frame_presentation_time_length_minus_1() {
        return segment.get(LAYOUT$frame_presentation_time_length_minus_1, OFFSET$frame_presentation_time_length_minus_1);
    }

    public StdVideoEncodeAV1DecoderModelInfo frame_presentation_time_length_minus_1(@Unsigned byte value) {
        segment.set(LAYOUT$frame_presentation_time_length_minus_1, OFFSET$frame_presentation_time_length_minus_1, value);
        return this;
    }


    public @Unsigned int num_units_in_decoding_tick() {
        return segment.get(LAYOUT$num_units_in_decoding_tick, OFFSET$num_units_in_decoding_tick);
    }

    public StdVideoEncodeAV1DecoderModelInfo num_units_in_decoding_tick(@Unsigned int value) {
        segment.set(LAYOUT$num_units_in_decoding_tick, OFFSET$num_units_in_decoding_tick, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_BYTE.withName("buffer_delay_length_minus_1"),
        ValueLayout.JAVA_BYTE.withName("buffer_removal_time_length_minus_1"),
        ValueLayout.JAVA_BYTE.withName("frame_presentation_time_length_minus_1"),
        ValueLayout.JAVA_BYTE.withName("reserved1"),
        ValueLayout.JAVA_INT.withName("num_units_in_decoding_tick")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$buffer_delay_length_minus_1 = PathElement.groupElement("buffer_delay_length_minus_1");
    public static final PathElement PATH$buffer_removal_time_length_minus_1 = PathElement.groupElement("buffer_removal_time_length_minus_1");
    public static final PathElement PATH$frame_presentation_time_length_minus_1 = PathElement.groupElement("frame_presentation_time_length_minus_1");
    public static final PathElement PATH$num_units_in_decoding_tick = PathElement.groupElement("num_units_in_decoding_tick");

    public static final OfByte LAYOUT$buffer_delay_length_minus_1 = (OfByte) LAYOUT.select(PATH$buffer_delay_length_minus_1);
    public static final OfByte LAYOUT$buffer_removal_time_length_minus_1 = (OfByte) LAYOUT.select(PATH$buffer_removal_time_length_minus_1);
    public static final OfByte LAYOUT$frame_presentation_time_length_minus_1 = (OfByte) LAYOUT.select(PATH$frame_presentation_time_length_minus_1);
    public static final OfInt LAYOUT$num_units_in_decoding_tick = (OfInt) LAYOUT.select(PATH$num_units_in_decoding_tick);

    public static final long SIZE$buffer_delay_length_minus_1 = LAYOUT$buffer_delay_length_minus_1.byteSize();
    public static final long SIZE$buffer_removal_time_length_minus_1 = LAYOUT$buffer_removal_time_length_minus_1.byteSize();
    public static final long SIZE$frame_presentation_time_length_minus_1 = LAYOUT$frame_presentation_time_length_minus_1.byteSize();
    public static final long SIZE$num_units_in_decoding_tick = LAYOUT$num_units_in_decoding_tick.byteSize();

    public static final long OFFSET$buffer_delay_length_minus_1 = LAYOUT.byteOffset(PATH$buffer_delay_length_minus_1);
    public static final long OFFSET$buffer_removal_time_length_minus_1 = LAYOUT.byteOffset(PATH$buffer_removal_time_length_minus_1);
    public static final long OFFSET$frame_presentation_time_length_minus_1 = LAYOUT.byteOffset(PATH$frame_presentation_time_length_minus_1);
    public static final long OFFSET$num_units_in_decoding_tick = LAYOUT.byteOffset(PATH$num_units_in_decoding_tick);
}
