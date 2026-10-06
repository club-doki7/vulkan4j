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

/// Represents a pointer to a {@code StdVideoEncodeH264RefPicMarkingEntry} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH264RefPicMarkingEntry {
///     StdVideoH264MemMgmtControlOp memory_management_control_operation; // @link substring="StdVideoH264MemMgmtControlOp" target="StdVideoH264MemMgmtControlOp" @link substring="memory_management_control_operation" target="#memory_management_control_operation"
///     uint16_t difference_of_pic_nums_minus1; // @link substring="difference_of_pic_nums_minus1" target="#difference_of_pic_nums_minus1"
///     uint16_t long_term_pic_num; // @link substring="long_term_pic_num" target="#long_term_pic_num"
///     uint16_t long_term_frame_idx; // @link substring="long_term_frame_idx" target="#long_term_frame_idx"
///     uint16_t max_long_term_frame_idx_plus1; // @link substring="max_long_term_frame_idx_plus1" target="#max_long_term_frame_idx_plus1"
/// } StdVideoEncodeH264RefPicMarkingEntry;
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
public record StdVideoEncodeH264RefPicMarkingEntry(@NotNull MemorySegment segment) implements IStdVideoEncodeH264RefPicMarkingEntry {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH264RefPicMarkingEntry}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH264RefPicMarkingEntry to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH264RefPicMarkingEntry.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH264RefPicMarkingEntry, Iterable<StdVideoEncodeH264RefPicMarkingEntry> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH264RefPicMarkingEntry.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH264RefPicMarkingEntry at(long index) {
            return new StdVideoEncodeH264RefPicMarkingEntry(segment.asSlice(index * StdVideoEncodeH264RefPicMarkingEntry.BYTES, StdVideoEncodeH264RefPicMarkingEntry.BYTES));
        }

        public StdVideoEncodeH264RefPicMarkingEntry.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH264RefPicMarkingEntry> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH264RefPicMarkingEntry value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH264RefPicMarkingEntry.BYTES, StdVideoEncodeH264RefPicMarkingEntry.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH264RefPicMarkingEntry.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH264RefPicMarkingEntry.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH264RefPicMarkingEntry.BYTES,
                (end - start) * StdVideoEncodeH264RefPicMarkingEntry.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH264RefPicMarkingEntry.BYTES));
        }

        public StdVideoEncodeH264RefPicMarkingEntry[] toArray() {
            StdVideoEncodeH264RefPicMarkingEntry[] ret = new StdVideoEncodeH264RefPicMarkingEntry[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH264RefPicMarkingEntry> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH264RefPicMarkingEntry> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH264RefPicMarkingEntry.BYTES;
            }

            @Override
            public StdVideoEncodeH264RefPicMarkingEntry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH264RefPicMarkingEntry ret = new StdVideoEncodeH264RefPicMarkingEntry(segment.asSlice(0, StdVideoEncodeH264RefPicMarkingEntry.BYTES));
                segment = segment.asSlice(StdVideoEncodeH264RefPicMarkingEntry.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH264RefPicMarkingEntry allocate(Arena arena) {
        return new StdVideoEncodeH264RefPicMarkingEntry(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH264RefPicMarkingEntry.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH264RefPicMarkingEntry.Ptr(segment);
    }

    public static StdVideoEncodeH264RefPicMarkingEntry clone(Arena arena, StdVideoEncodeH264RefPicMarkingEntry src) {
        StdVideoEncodeH264RefPicMarkingEntry ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(StdVideoH264MemMgmtControlOp.class) int memory_management_control_operation() {
        return segment.get(LAYOUT$memory_management_control_operation, OFFSET$memory_management_control_operation);
    }

    public StdVideoEncodeH264RefPicMarkingEntry memory_management_control_operation(@EnumType(StdVideoH264MemMgmtControlOp.class) int value) {
        segment.set(LAYOUT$memory_management_control_operation, OFFSET$memory_management_control_operation, value);
        return this;
    }

    public @Unsigned short difference_of_pic_nums_minus1() {
        return segment.get(LAYOUT$difference_of_pic_nums_minus1, OFFSET$difference_of_pic_nums_minus1);
    }

    public StdVideoEncodeH264RefPicMarkingEntry difference_of_pic_nums_minus1(@Unsigned short value) {
        segment.set(LAYOUT$difference_of_pic_nums_minus1, OFFSET$difference_of_pic_nums_minus1, value);
        return this;
    }

    public @Unsigned short long_term_pic_num() {
        return segment.get(LAYOUT$long_term_pic_num, OFFSET$long_term_pic_num);
    }

    public StdVideoEncodeH264RefPicMarkingEntry long_term_pic_num(@Unsigned short value) {
        segment.set(LAYOUT$long_term_pic_num, OFFSET$long_term_pic_num, value);
        return this;
    }

    public @Unsigned short long_term_frame_idx() {
        return segment.get(LAYOUT$long_term_frame_idx, OFFSET$long_term_frame_idx);
    }

    public StdVideoEncodeH264RefPicMarkingEntry long_term_frame_idx(@Unsigned short value) {
        segment.set(LAYOUT$long_term_frame_idx, OFFSET$long_term_frame_idx, value);
        return this;
    }

    public @Unsigned short max_long_term_frame_idx_plus1() {
        return segment.get(LAYOUT$max_long_term_frame_idx_plus1, OFFSET$max_long_term_frame_idx_plus1);
    }

    public StdVideoEncodeH264RefPicMarkingEntry max_long_term_frame_idx_plus1(@Unsigned short value) {
        segment.set(LAYOUT$max_long_term_frame_idx_plus1, OFFSET$max_long_term_frame_idx_plus1, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("memory_management_control_operation"),
        ValueLayout.JAVA_SHORT.withName("difference_of_pic_nums_minus1"),
        ValueLayout.JAVA_SHORT.withName("long_term_pic_num"),
        ValueLayout.JAVA_SHORT.withName("long_term_frame_idx"),
        ValueLayout.JAVA_SHORT.withName("max_long_term_frame_idx_plus1")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$memory_management_control_operation = PathElement.groupElement("memory_management_control_operation");
    public static final PathElement PATH$difference_of_pic_nums_minus1 = PathElement.groupElement("difference_of_pic_nums_minus1");
    public static final PathElement PATH$long_term_pic_num = PathElement.groupElement("long_term_pic_num");
    public static final PathElement PATH$long_term_frame_idx = PathElement.groupElement("long_term_frame_idx");
    public static final PathElement PATH$max_long_term_frame_idx_plus1 = PathElement.groupElement("max_long_term_frame_idx_plus1");

    public static final OfInt LAYOUT$memory_management_control_operation = (OfInt) LAYOUT.select(PATH$memory_management_control_operation);
    public static final OfShort LAYOUT$difference_of_pic_nums_minus1 = (OfShort) LAYOUT.select(PATH$difference_of_pic_nums_minus1);
    public static final OfShort LAYOUT$long_term_pic_num = (OfShort) LAYOUT.select(PATH$long_term_pic_num);
    public static final OfShort LAYOUT$long_term_frame_idx = (OfShort) LAYOUT.select(PATH$long_term_frame_idx);
    public static final OfShort LAYOUT$max_long_term_frame_idx_plus1 = (OfShort) LAYOUT.select(PATH$max_long_term_frame_idx_plus1);

    public static final long SIZE$memory_management_control_operation = LAYOUT$memory_management_control_operation.byteSize();
    public static final long SIZE$difference_of_pic_nums_minus1 = LAYOUT$difference_of_pic_nums_minus1.byteSize();
    public static final long SIZE$long_term_pic_num = LAYOUT$long_term_pic_num.byteSize();
    public static final long SIZE$long_term_frame_idx = LAYOUT$long_term_frame_idx.byteSize();
    public static final long SIZE$max_long_term_frame_idx_plus1 = LAYOUT$max_long_term_frame_idx_plus1.byteSize();

    public static final long OFFSET$memory_management_control_operation = LAYOUT.byteOffset(PATH$memory_management_control_operation);
    public static final long OFFSET$difference_of_pic_nums_minus1 = LAYOUT.byteOffset(PATH$difference_of_pic_nums_minus1);
    public static final long OFFSET$long_term_pic_num = LAYOUT.byteOffset(PATH$long_term_pic_num);
    public static final long OFFSET$long_term_frame_idx = LAYOUT.byteOffset(PATH$long_term_frame_idx);
    public static final long OFFSET$max_long_term_frame_idx_plus1 = LAYOUT.byteOffset(PATH$max_long_term_frame_idx_plus1);
}
