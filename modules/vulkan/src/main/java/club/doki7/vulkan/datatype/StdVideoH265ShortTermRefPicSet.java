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

/// Represents a pointer to a {@code StdVideoH265ShortTermRefPicSet} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265ShortTermRefPicSet {
///     StdVideoH265ShortTermRefPicSetFlags flags; // @link substring="StdVideoH265ShortTermRefPicSetFlags" target="StdVideoH265ShortTermRefPicSetFlags" @link substring="flags" target="#flags"
///     uint32_t delta_idx_minus1; // @link substring="delta_idx_minus1" target="#delta_idx_minus1"
///     uint16_t use_delta_flag; // @link substring="use_delta_flag" target="#use_delta_flag"
///     uint16_t abs_delta_rps_minus1; // @link substring="abs_delta_rps_minus1" target="#abs_delta_rps_minus1"
///     uint16_t used_by_curr_pic_flag; // @link substring="used_by_curr_pic_flag" target="#used_by_curr_pic_flag"
///     uint16_t used_by_curr_pic_s0_flag; // @link substring="used_by_curr_pic_s0_flag" target="#used_by_curr_pic_s0_flag"
///     uint16_t used_by_curr_pic_s1_flag; // @link substring="used_by_curr_pic_s1_flag" target="#used_by_curr_pic_s1_flag"
///     uint16_t reserved1;
///     uint8_t reserved2;
///     uint8_t reserved3;
///     uint8_t num_negative_pics; // @link substring="num_negative_pics" target="#num_negative_pics"
///     uint8_t num_positive_pics; // @link substring="num_positive_pics" target="#num_positive_pics"
///     uint16_t[STD_VIDEO_H265_MAX_DPB_SIZE] delta_poc_s0_minus1; // @link substring="delta_poc_s0_minus1" target="#delta_poc_s0_minus1"
///     uint16_t[STD_VIDEO_H265_MAX_DPB_SIZE] delta_poc_s1_minus1; // @link substring="delta_poc_s1_minus1" target="#delta_poc_s1_minus1"
/// } StdVideoH265ShortTermRefPicSet;
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
public record StdVideoH265ShortTermRefPicSet(@NotNull MemorySegment segment) implements IStdVideoH265ShortTermRefPicSet {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265ShortTermRefPicSet}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265ShortTermRefPicSet to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265ShortTermRefPicSet.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265ShortTermRefPicSet, Iterable<StdVideoH265ShortTermRefPicSet> {
        public long size() {
            return segment.byteSize() / StdVideoH265ShortTermRefPicSet.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265ShortTermRefPicSet at(long index) {
            return new StdVideoH265ShortTermRefPicSet(segment.asSlice(index * StdVideoH265ShortTermRefPicSet.BYTES, StdVideoH265ShortTermRefPicSet.BYTES));
        }

        public StdVideoH265ShortTermRefPicSet.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265ShortTermRefPicSet> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265ShortTermRefPicSet value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265ShortTermRefPicSet.BYTES, StdVideoH265ShortTermRefPicSet.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265ShortTermRefPicSet.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265ShortTermRefPicSet.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265ShortTermRefPicSet.BYTES,
                (end - start) * StdVideoH265ShortTermRefPicSet.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265ShortTermRefPicSet.BYTES));
        }

        public StdVideoH265ShortTermRefPicSet[] toArray() {
            StdVideoH265ShortTermRefPicSet[] ret = new StdVideoH265ShortTermRefPicSet[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265ShortTermRefPicSet> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265ShortTermRefPicSet> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265ShortTermRefPicSet.BYTES;
            }

            @Override
            public StdVideoH265ShortTermRefPicSet next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265ShortTermRefPicSet ret = new StdVideoH265ShortTermRefPicSet(segment.asSlice(0, StdVideoH265ShortTermRefPicSet.BYTES));
                segment = segment.asSlice(StdVideoH265ShortTermRefPicSet.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265ShortTermRefPicSet allocate(Arena arena) {
        return new StdVideoH265ShortTermRefPicSet(arena.allocate(LAYOUT));
    }

    public static StdVideoH265ShortTermRefPicSet.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265ShortTermRefPicSet.Ptr(segment);
    }

    public static StdVideoH265ShortTermRefPicSet clone(Arena arena, StdVideoH265ShortTermRefPicSet src) {
        StdVideoH265ShortTermRefPicSet ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoH265ShortTermRefPicSetFlags flags() {
        return new StdVideoH265ShortTermRefPicSetFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoH265ShortTermRefPicSet flags(@NotNull StdVideoH265ShortTermRefPicSetFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoH265ShortTermRefPicSet flags(Consumer<@NotNull StdVideoH265ShortTermRefPicSetFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned int delta_idx_minus1() {
        return segment.get(LAYOUT$delta_idx_minus1, OFFSET$delta_idx_minus1);
    }

    public StdVideoH265ShortTermRefPicSet delta_idx_minus1(@Unsigned int value) {
        segment.set(LAYOUT$delta_idx_minus1, OFFSET$delta_idx_minus1, value);
        return this;
    }

    public @Unsigned short use_delta_flag() {
        return segment.get(LAYOUT$use_delta_flag, OFFSET$use_delta_flag);
    }

    public StdVideoH265ShortTermRefPicSet use_delta_flag(@Unsigned short value) {
        segment.set(LAYOUT$use_delta_flag, OFFSET$use_delta_flag, value);
        return this;
    }

    public @Unsigned short abs_delta_rps_minus1() {
        return segment.get(LAYOUT$abs_delta_rps_minus1, OFFSET$abs_delta_rps_minus1);
    }

    public StdVideoH265ShortTermRefPicSet abs_delta_rps_minus1(@Unsigned short value) {
        segment.set(LAYOUT$abs_delta_rps_minus1, OFFSET$abs_delta_rps_minus1, value);
        return this;
    }

    public @Unsigned short used_by_curr_pic_flag() {
        return segment.get(LAYOUT$used_by_curr_pic_flag, OFFSET$used_by_curr_pic_flag);
    }

    public StdVideoH265ShortTermRefPicSet used_by_curr_pic_flag(@Unsigned short value) {
        segment.set(LAYOUT$used_by_curr_pic_flag, OFFSET$used_by_curr_pic_flag, value);
        return this;
    }

    public @Unsigned short used_by_curr_pic_s0_flag() {
        return segment.get(LAYOUT$used_by_curr_pic_s0_flag, OFFSET$used_by_curr_pic_s0_flag);
    }

    public StdVideoH265ShortTermRefPicSet used_by_curr_pic_s0_flag(@Unsigned short value) {
        segment.set(LAYOUT$used_by_curr_pic_s0_flag, OFFSET$used_by_curr_pic_s0_flag, value);
        return this;
    }

    public @Unsigned short used_by_curr_pic_s1_flag() {
        return segment.get(LAYOUT$used_by_curr_pic_s1_flag, OFFSET$used_by_curr_pic_s1_flag);
    }

    public StdVideoH265ShortTermRefPicSet used_by_curr_pic_s1_flag(@Unsigned short value) {
        segment.set(LAYOUT$used_by_curr_pic_s1_flag, OFFSET$used_by_curr_pic_s1_flag, value);
        return this;
    }




    public @Unsigned byte num_negative_pics() {
        return segment.get(LAYOUT$num_negative_pics, OFFSET$num_negative_pics);
    }

    public StdVideoH265ShortTermRefPicSet num_negative_pics(@Unsigned byte value) {
        segment.set(LAYOUT$num_negative_pics, OFFSET$num_negative_pics, value);
        return this;
    }

    public @Unsigned byte num_positive_pics() {
        return segment.get(LAYOUT$num_positive_pics, OFFSET$num_positive_pics);
    }

    public StdVideoH265ShortTermRefPicSet num_positive_pics(@Unsigned byte value) {
        segment.set(LAYOUT$num_positive_pics, OFFSET$num_positive_pics, value);
        return this;
    }

    public @Unsigned ShortPtr delta_poc_s0_minus1() {
        return new ShortPtr(delta_poc_s0_minus1Raw());
    }

    public StdVideoH265ShortTermRefPicSet delta_poc_s0_minus1(@NotNull Consumer<ShortPtr> consumer) {
        @Unsigned ShortPtr ptr = delta_poc_s0_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265ShortTermRefPicSet delta_poc_s0_minus1(@Unsigned ShortPtr value) {
        MemorySegment s = delta_poc_s0_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment delta_poc_s0_minus1Raw() {
        return segment.asSlice(OFFSET$delta_poc_s0_minus1, SIZE$delta_poc_s0_minus1);
    }

    public @Unsigned ShortPtr delta_poc_s1_minus1() {
        return new ShortPtr(delta_poc_s1_minus1Raw());
    }

    public StdVideoH265ShortTermRefPicSet delta_poc_s1_minus1(@NotNull Consumer<ShortPtr> consumer) {
        @Unsigned ShortPtr ptr = delta_poc_s1_minus1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoH265ShortTermRefPicSet delta_poc_s1_minus1(@Unsigned ShortPtr value) {
        MemorySegment s = delta_poc_s1_minus1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment delta_poc_s1_minus1Raw() {
        return segment.asSlice(OFFSET$delta_poc_s1_minus1, SIZE$delta_poc_s1_minus1);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoH265ShortTermRefPicSetFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("delta_idx_minus1"),
        ValueLayout.JAVA_SHORT.withName("use_delta_flag"),
        ValueLayout.JAVA_SHORT.withName("abs_delta_rps_minus1"),
        ValueLayout.JAVA_SHORT.withName("used_by_curr_pic_flag"),
        ValueLayout.JAVA_SHORT.withName("used_by_curr_pic_s0_flag"),
        ValueLayout.JAVA_SHORT.withName("used_by_curr_pic_s1_flag"),
        ValueLayout.JAVA_SHORT.withName("reserved1"),
        ValueLayout.JAVA_BYTE.withName("reserved2"),
        ValueLayout.JAVA_BYTE.withName("reserved3"),
        ValueLayout.JAVA_BYTE.withName("num_negative_pics"),
        ValueLayout.JAVA_BYTE.withName("num_positive_pics"),
        MemoryLayout.sequenceLayout(H265_MAX_DPB_SIZE, ValueLayout.JAVA_SHORT).withName("delta_poc_s0_minus1"),
        MemoryLayout.sequenceLayout(H265_MAX_DPB_SIZE, ValueLayout.JAVA_SHORT).withName("delta_poc_s1_minus1")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$delta_idx_minus1 = PathElement.groupElement("delta_idx_minus1");
    public static final PathElement PATH$use_delta_flag = PathElement.groupElement("use_delta_flag");
    public static final PathElement PATH$abs_delta_rps_minus1 = PathElement.groupElement("abs_delta_rps_minus1");
    public static final PathElement PATH$used_by_curr_pic_flag = PathElement.groupElement("used_by_curr_pic_flag");
    public static final PathElement PATH$used_by_curr_pic_s0_flag = PathElement.groupElement("used_by_curr_pic_s0_flag");
    public static final PathElement PATH$used_by_curr_pic_s1_flag = PathElement.groupElement("used_by_curr_pic_s1_flag");
    public static final PathElement PATH$num_negative_pics = PathElement.groupElement("num_negative_pics");
    public static final PathElement PATH$num_positive_pics = PathElement.groupElement("num_positive_pics");
    public static final PathElement PATH$delta_poc_s0_minus1 = PathElement.groupElement("delta_poc_s0_minus1");
    public static final PathElement PATH$delta_poc_s1_minus1 = PathElement.groupElement("delta_poc_s1_minus1");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$delta_idx_minus1 = (OfInt) LAYOUT.select(PATH$delta_idx_minus1);
    public static final OfShort LAYOUT$use_delta_flag = (OfShort) LAYOUT.select(PATH$use_delta_flag);
    public static final OfShort LAYOUT$abs_delta_rps_minus1 = (OfShort) LAYOUT.select(PATH$abs_delta_rps_minus1);
    public static final OfShort LAYOUT$used_by_curr_pic_flag = (OfShort) LAYOUT.select(PATH$used_by_curr_pic_flag);
    public static final OfShort LAYOUT$used_by_curr_pic_s0_flag = (OfShort) LAYOUT.select(PATH$used_by_curr_pic_s0_flag);
    public static final OfShort LAYOUT$used_by_curr_pic_s1_flag = (OfShort) LAYOUT.select(PATH$used_by_curr_pic_s1_flag);
    public static final OfByte LAYOUT$num_negative_pics = (OfByte) LAYOUT.select(PATH$num_negative_pics);
    public static final OfByte LAYOUT$num_positive_pics = (OfByte) LAYOUT.select(PATH$num_positive_pics);
    public static final SequenceLayout LAYOUT$delta_poc_s0_minus1 = (SequenceLayout) LAYOUT.select(PATH$delta_poc_s0_minus1);
    public static final SequenceLayout LAYOUT$delta_poc_s1_minus1 = (SequenceLayout) LAYOUT.select(PATH$delta_poc_s1_minus1);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$delta_idx_minus1 = LAYOUT$delta_idx_minus1.byteSize();
    public static final long SIZE$use_delta_flag = LAYOUT$use_delta_flag.byteSize();
    public static final long SIZE$abs_delta_rps_minus1 = LAYOUT$abs_delta_rps_minus1.byteSize();
    public static final long SIZE$used_by_curr_pic_flag = LAYOUT$used_by_curr_pic_flag.byteSize();
    public static final long SIZE$used_by_curr_pic_s0_flag = LAYOUT$used_by_curr_pic_s0_flag.byteSize();
    public static final long SIZE$used_by_curr_pic_s1_flag = LAYOUT$used_by_curr_pic_s1_flag.byteSize();
    public static final long SIZE$num_negative_pics = LAYOUT$num_negative_pics.byteSize();
    public static final long SIZE$num_positive_pics = LAYOUT$num_positive_pics.byteSize();
    public static final long SIZE$delta_poc_s0_minus1 = LAYOUT$delta_poc_s0_minus1.byteSize();
    public static final long SIZE$delta_poc_s1_minus1 = LAYOUT$delta_poc_s1_minus1.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$delta_idx_minus1 = LAYOUT.byteOffset(PATH$delta_idx_minus1);
    public static final long OFFSET$use_delta_flag = LAYOUT.byteOffset(PATH$use_delta_flag);
    public static final long OFFSET$abs_delta_rps_minus1 = LAYOUT.byteOffset(PATH$abs_delta_rps_minus1);
    public static final long OFFSET$used_by_curr_pic_flag = LAYOUT.byteOffset(PATH$used_by_curr_pic_flag);
    public static final long OFFSET$used_by_curr_pic_s0_flag = LAYOUT.byteOffset(PATH$used_by_curr_pic_s0_flag);
    public static final long OFFSET$used_by_curr_pic_s1_flag = LAYOUT.byteOffset(PATH$used_by_curr_pic_s1_flag);
    public static final long OFFSET$num_negative_pics = LAYOUT.byteOffset(PATH$num_negative_pics);
    public static final long OFFSET$num_positive_pics = LAYOUT.byteOffset(PATH$num_positive_pics);
    public static final long OFFSET$delta_poc_s0_minus1 = LAYOUT.byteOffset(PATH$delta_poc_s0_minus1);
    public static final long OFFSET$delta_poc_s1_minus1 = LAYOUT.byteOffset(PATH$delta_poc_s1_minus1);
}
