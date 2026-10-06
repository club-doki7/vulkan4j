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

/// Represents a pointer to a {@code StdVideoEncodeH265ReferenceListsInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH265ReferenceListsInfo {
///     StdVideoEncodeH265ReferenceListsInfoFlags flags; // @link substring="StdVideoEncodeH265ReferenceListsInfoFlags" target="StdVideoEncodeH265ReferenceListsInfoFlags" @link substring="flags" target="#flags"
///     uint8_t num_ref_idx_l0_active_minus1; // @link substring="num_ref_idx_l0_active_minus1" target="#num_ref_idx_l0_active_minus1"
///     uint8_t num_ref_idx_l1_active_minus1; // @link substring="num_ref_idx_l1_active_minus1" target="#num_ref_idx_l1_active_minus1"
///     uint8_t[STD_VIDEO_H265_MAX_NUM_LIST_REF] RefPicList0; // @link substring="RefPicList0" target="#RefPicList0"
///     uint8_t[STD_VIDEO_H265_MAX_NUM_LIST_REF] RefPicList1; // @link substring="RefPicList1" target="#RefPicList1"
///     uint8_t[STD_VIDEO_H265_MAX_NUM_LIST_REF] list_entry_l0; // @link substring="list_entry_l0" target="#list_entry_l0"
///     uint8_t[STD_VIDEO_H265_MAX_NUM_LIST_REF] list_entry_l1; // @link substring="list_entry_l1" target="#list_entry_l1"
/// } StdVideoEncodeH265ReferenceListsInfo;
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
public record StdVideoEncodeH265ReferenceListsInfo(@NotNull MemorySegment segment) implements IStdVideoEncodeH265ReferenceListsInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH265ReferenceListsInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH265ReferenceListsInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH265ReferenceListsInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH265ReferenceListsInfo, Iterable<StdVideoEncodeH265ReferenceListsInfo> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH265ReferenceListsInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH265ReferenceListsInfo at(long index) {
            return new StdVideoEncodeH265ReferenceListsInfo(segment.asSlice(index * StdVideoEncodeH265ReferenceListsInfo.BYTES, StdVideoEncodeH265ReferenceListsInfo.BYTES));
        }

        public StdVideoEncodeH265ReferenceListsInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH265ReferenceListsInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH265ReferenceListsInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH265ReferenceListsInfo.BYTES, StdVideoEncodeH265ReferenceListsInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH265ReferenceListsInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH265ReferenceListsInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH265ReferenceListsInfo.BYTES,
                (end - start) * StdVideoEncodeH265ReferenceListsInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH265ReferenceListsInfo.BYTES));
        }

        public StdVideoEncodeH265ReferenceListsInfo[] toArray() {
            StdVideoEncodeH265ReferenceListsInfo[] ret = new StdVideoEncodeH265ReferenceListsInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH265ReferenceListsInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH265ReferenceListsInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH265ReferenceListsInfo.BYTES;
            }

            @Override
            public StdVideoEncodeH265ReferenceListsInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH265ReferenceListsInfo ret = new StdVideoEncodeH265ReferenceListsInfo(segment.asSlice(0, StdVideoEncodeH265ReferenceListsInfo.BYTES));
                segment = segment.asSlice(StdVideoEncodeH265ReferenceListsInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH265ReferenceListsInfo allocate(Arena arena) {
        return new StdVideoEncodeH265ReferenceListsInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH265ReferenceListsInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH265ReferenceListsInfo.Ptr(segment);
    }

    public static StdVideoEncodeH265ReferenceListsInfo clone(Arena arena, StdVideoEncodeH265ReferenceListsInfo src) {
        StdVideoEncodeH265ReferenceListsInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoEncodeH265ReferenceListsInfoFlags flags() {
        return new StdVideoEncodeH265ReferenceListsInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoEncodeH265ReferenceListsInfo flags(@NotNull StdVideoEncodeH265ReferenceListsInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoEncodeH265ReferenceListsInfo flags(Consumer<@NotNull StdVideoEncodeH265ReferenceListsInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte num_ref_idx_l0_active_minus1() {
        return segment.get(LAYOUT$num_ref_idx_l0_active_minus1, OFFSET$num_ref_idx_l0_active_minus1);
    }

    public StdVideoEncodeH265ReferenceListsInfo num_ref_idx_l0_active_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_ref_idx_l0_active_minus1, OFFSET$num_ref_idx_l0_active_minus1, value);
        return this;
    }

    public @Unsigned byte num_ref_idx_l1_active_minus1() {
        return segment.get(LAYOUT$num_ref_idx_l1_active_minus1, OFFSET$num_ref_idx_l1_active_minus1);
    }

    public StdVideoEncodeH265ReferenceListsInfo num_ref_idx_l1_active_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_ref_idx_l1_active_minus1, OFFSET$num_ref_idx_l1_active_minus1, value);
        return this;
    }

    public @Unsigned BytePtr RefPicList0() {
        return new BytePtr(RefPicList0Raw());
    }

    public StdVideoEncodeH265ReferenceListsInfo RefPicList0(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = RefPicList0();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoEncodeH265ReferenceListsInfo RefPicList0(@Unsigned BytePtr value) {
        MemorySegment s = RefPicList0Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment RefPicList0Raw() {
        return segment.asSlice(OFFSET$RefPicList0, SIZE$RefPicList0);
    }

    public @Unsigned BytePtr RefPicList1() {
        return new BytePtr(RefPicList1Raw());
    }

    public StdVideoEncodeH265ReferenceListsInfo RefPicList1(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = RefPicList1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoEncodeH265ReferenceListsInfo RefPicList1(@Unsigned BytePtr value) {
        MemorySegment s = RefPicList1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment RefPicList1Raw() {
        return segment.asSlice(OFFSET$RefPicList1, SIZE$RefPicList1);
    }

    public @Unsigned BytePtr list_entry_l0() {
        return new BytePtr(list_entry_l0Raw());
    }

    public StdVideoEncodeH265ReferenceListsInfo list_entry_l0(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = list_entry_l0();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoEncodeH265ReferenceListsInfo list_entry_l0(@Unsigned BytePtr value) {
        MemorySegment s = list_entry_l0Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment list_entry_l0Raw() {
        return segment.asSlice(OFFSET$list_entry_l0, SIZE$list_entry_l0);
    }

    public @Unsigned BytePtr list_entry_l1() {
        return new BytePtr(list_entry_l1Raw());
    }

    public StdVideoEncodeH265ReferenceListsInfo list_entry_l1(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = list_entry_l1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoEncodeH265ReferenceListsInfo list_entry_l1(@Unsigned BytePtr value) {
        MemorySegment s = list_entry_l1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment list_entry_l1Raw() {
        return segment.asSlice(OFFSET$list_entry_l1, SIZE$list_entry_l1);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoEncodeH265ReferenceListsInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("num_ref_idx_l0_active_minus1"),
        ValueLayout.JAVA_BYTE.withName("num_ref_idx_l1_active_minus1"),
        MemoryLayout.sequenceLayout(H265_MAX_NUM_LIST_REF, ValueLayout.JAVA_BYTE).withName("RefPicList0"),
        MemoryLayout.sequenceLayout(H265_MAX_NUM_LIST_REF, ValueLayout.JAVA_BYTE).withName("RefPicList1"),
        MemoryLayout.sequenceLayout(H265_MAX_NUM_LIST_REF, ValueLayout.JAVA_BYTE).withName("list_entry_l0"),
        MemoryLayout.sequenceLayout(H265_MAX_NUM_LIST_REF, ValueLayout.JAVA_BYTE).withName("list_entry_l1")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$num_ref_idx_l0_active_minus1 = PathElement.groupElement("num_ref_idx_l0_active_minus1");
    public static final PathElement PATH$num_ref_idx_l1_active_minus1 = PathElement.groupElement("num_ref_idx_l1_active_minus1");
    public static final PathElement PATH$RefPicList0 = PathElement.groupElement("RefPicList0");
    public static final PathElement PATH$RefPicList1 = PathElement.groupElement("RefPicList1");
    public static final PathElement PATH$list_entry_l0 = PathElement.groupElement("list_entry_l0");
    public static final PathElement PATH$list_entry_l1 = PathElement.groupElement("list_entry_l1");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$num_ref_idx_l0_active_minus1 = (OfByte) LAYOUT.select(PATH$num_ref_idx_l0_active_minus1);
    public static final OfByte LAYOUT$num_ref_idx_l1_active_minus1 = (OfByte) LAYOUT.select(PATH$num_ref_idx_l1_active_minus1);
    public static final SequenceLayout LAYOUT$RefPicList0 = (SequenceLayout) LAYOUT.select(PATH$RefPicList0);
    public static final SequenceLayout LAYOUT$RefPicList1 = (SequenceLayout) LAYOUT.select(PATH$RefPicList1);
    public static final SequenceLayout LAYOUT$list_entry_l0 = (SequenceLayout) LAYOUT.select(PATH$list_entry_l0);
    public static final SequenceLayout LAYOUT$list_entry_l1 = (SequenceLayout) LAYOUT.select(PATH$list_entry_l1);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$num_ref_idx_l0_active_minus1 = LAYOUT$num_ref_idx_l0_active_minus1.byteSize();
    public static final long SIZE$num_ref_idx_l1_active_minus1 = LAYOUT$num_ref_idx_l1_active_minus1.byteSize();
    public static final long SIZE$RefPicList0 = LAYOUT$RefPicList0.byteSize();
    public static final long SIZE$RefPicList1 = LAYOUT$RefPicList1.byteSize();
    public static final long SIZE$list_entry_l0 = LAYOUT$list_entry_l0.byteSize();
    public static final long SIZE$list_entry_l1 = LAYOUT$list_entry_l1.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$num_ref_idx_l0_active_minus1 = LAYOUT.byteOffset(PATH$num_ref_idx_l0_active_minus1);
    public static final long OFFSET$num_ref_idx_l1_active_minus1 = LAYOUT.byteOffset(PATH$num_ref_idx_l1_active_minus1);
    public static final long OFFSET$RefPicList0 = LAYOUT.byteOffset(PATH$RefPicList0);
    public static final long OFFSET$RefPicList1 = LAYOUT.byteOffset(PATH$RefPicList1);
    public static final long OFFSET$list_entry_l0 = LAYOUT.byteOffset(PATH$list_entry_l0);
    public static final long OFFSET$list_entry_l1 = LAYOUT.byteOffset(PATH$list_entry_l1);
}
