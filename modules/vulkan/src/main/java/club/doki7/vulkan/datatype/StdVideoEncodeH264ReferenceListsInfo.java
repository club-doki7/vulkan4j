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

/// Represents a pointer to a {@code StdVideoEncodeH264ReferenceListsInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH264ReferenceListsInfo {
///     StdVideoEncodeH264ReferenceListsInfoFlags flags; // @link substring="StdVideoEncodeH264ReferenceListsInfoFlags" target="StdVideoEncodeH264ReferenceListsInfoFlags" @link substring="flags" target="#flags"
///     uint8_t num_ref_idx_l0_active_minus1; // @link substring="num_ref_idx_l0_active_minus1" target="#num_ref_idx_l0_active_minus1"
///     uint8_t num_ref_idx_l1_active_minus1; // @link substring="num_ref_idx_l1_active_minus1" target="#num_ref_idx_l1_active_minus1"
///     uint8_t[STD_VIDEO_H264_MAX_NUM_LIST_REF] RefPicList0; // @link substring="RefPicList0" target="#RefPicList0"
///     uint8_t[STD_VIDEO_H264_MAX_NUM_LIST_REF] RefPicList1; // @link substring="RefPicList1" target="#RefPicList1"
///     uint8_t refList0ModOpCount; // @link substring="refList0ModOpCount" target="#refList0ModOpCount"
///     uint8_t refList1ModOpCount; // @link substring="refList1ModOpCount" target="#refList1ModOpCount"
///     uint8_t refPicMarkingOpCount; // @link substring="refPicMarkingOpCount" target="#refPicMarkingOpCount"
///     uint8_t[7] reserved1;
///     StdVideoEncodeH264RefListModEntry const* pRefList0ModOperations; // @link substring="StdVideoEncodeH264RefListModEntry" target="StdVideoEncodeH264RefListModEntry" @link substring="pRefList0ModOperations" target="#pRefList0ModOperations"
///     StdVideoEncodeH264RefListModEntry const* pRefList1ModOperations; // @link substring="StdVideoEncodeH264RefListModEntry" target="StdVideoEncodeH264RefListModEntry" @link substring="pRefList1ModOperations" target="#pRefList1ModOperations"
///     StdVideoEncodeH264RefPicMarkingEntry const* pRefPicMarkingOperations; // @link substring="StdVideoEncodeH264RefPicMarkingEntry" target="StdVideoEncodeH264RefPicMarkingEntry" @link substring="pRefPicMarkingOperations" target="#pRefPicMarkingOperations"
/// } StdVideoEncodeH264ReferenceListsInfo;
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
public record StdVideoEncodeH264ReferenceListsInfo(@NotNull MemorySegment segment) implements IStdVideoEncodeH264ReferenceListsInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH264ReferenceListsInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH264ReferenceListsInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH264ReferenceListsInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH264ReferenceListsInfo, Iterable<StdVideoEncodeH264ReferenceListsInfo> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH264ReferenceListsInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH264ReferenceListsInfo at(long index) {
            return new StdVideoEncodeH264ReferenceListsInfo(segment.asSlice(index * StdVideoEncodeH264ReferenceListsInfo.BYTES, StdVideoEncodeH264ReferenceListsInfo.BYTES));
        }

        public StdVideoEncodeH264ReferenceListsInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH264ReferenceListsInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH264ReferenceListsInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH264ReferenceListsInfo.BYTES, StdVideoEncodeH264ReferenceListsInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH264ReferenceListsInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH264ReferenceListsInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH264ReferenceListsInfo.BYTES,
                (end - start) * StdVideoEncodeH264ReferenceListsInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH264ReferenceListsInfo.BYTES));
        }

        public StdVideoEncodeH264ReferenceListsInfo[] toArray() {
            StdVideoEncodeH264ReferenceListsInfo[] ret = new StdVideoEncodeH264ReferenceListsInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH264ReferenceListsInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH264ReferenceListsInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH264ReferenceListsInfo.BYTES;
            }

            @Override
            public StdVideoEncodeH264ReferenceListsInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH264ReferenceListsInfo ret = new StdVideoEncodeH264ReferenceListsInfo(segment.asSlice(0, StdVideoEncodeH264ReferenceListsInfo.BYTES));
                segment = segment.asSlice(StdVideoEncodeH264ReferenceListsInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH264ReferenceListsInfo allocate(Arena arena) {
        return new StdVideoEncodeH264ReferenceListsInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH264ReferenceListsInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH264ReferenceListsInfo.Ptr(segment);
    }

    public static StdVideoEncodeH264ReferenceListsInfo clone(Arena arena, StdVideoEncodeH264ReferenceListsInfo src) {
        StdVideoEncodeH264ReferenceListsInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoEncodeH264ReferenceListsInfoFlags flags() {
        return new StdVideoEncodeH264ReferenceListsInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoEncodeH264ReferenceListsInfo flags(@NotNull StdVideoEncodeH264ReferenceListsInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoEncodeH264ReferenceListsInfo flags(Consumer<@NotNull StdVideoEncodeH264ReferenceListsInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte num_ref_idx_l0_active_minus1() {
        return segment.get(LAYOUT$num_ref_idx_l0_active_minus1, OFFSET$num_ref_idx_l0_active_minus1);
    }

    public StdVideoEncodeH264ReferenceListsInfo num_ref_idx_l0_active_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_ref_idx_l0_active_minus1, OFFSET$num_ref_idx_l0_active_minus1, value);
        return this;
    }

    public @Unsigned byte num_ref_idx_l1_active_minus1() {
        return segment.get(LAYOUT$num_ref_idx_l1_active_minus1, OFFSET$num_ref_idx_l1_active_minus1);
    }

    public StdVideoEncodeH264ReferenceListsInfo num_ref_idx_l1_active_minus1(@Unsigned byte value) {
        segment.set(LAYOUT$num_ref_idx_l1_active_minus1, OFFSET$num_ref_idx_l1_active_minus1, value);
        return this;
    }

    public @Unsigned BytePtr RefPicList0() {
        return new BytePtr(RefPicList0Raw());
    }

    public StdVideoEncodeH264ReferenceListsInfo RefPicList0(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = RefPicList0();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoEncodeH264ReferenceListsInfo RefPicList0(@Unsigned BytePtr value) {
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

    public StdVideoEncodeH264ReferenceListsInfo RefPicList1(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = RefPicList1();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoEncodeH264ReferenceListsInfo RefPicList1(@Unsigned BytePtr value) {
        MemorySegment s = RefPicList1Raw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment RefPicList1Raw() {
        return segment.asSlice(OFFSET$RefPicList1, SIZE$RefPicList1);
    }

    public @Unsigned byte refList0ModOpCount() {
        return segment.get(LAYOUT$refList0ModOpCount, OFFSET$refList0ModOpCount);
    }

    public StdVideoEncodeH264ReferenceListsInfo refList0ModOpCount(@Unsigned byte value) {
        segment.set(LAYOUT$refList0ModOpCount, OFFSET$refList0ModOpCount, value);
        return this;
    }

    public @Unsigned byte refList1ModOpCount() {
        return segment.get(LAYOUT$refList1ModOpCount, OFFSET$refList1ModOpCount);
    }

    public StdVideoEncodeH264ReferenceListsInfo refList1ModOpCount(@Unsigned byte value) {
        segment.set(LAYOUT$refList1ModOpCount, OFFSET$refList1ModOpCount, value);
        return this;
    }

    public @Unsigned byte refPicMarkingOpCount() {
        return segment.get(LAYOUT$refPicMarkingOpCount, OFFSET$refPicMarkingOpCount);
    }

    public StdVideoEncodeH264ReferenceListsInfo refPicMarkingOpCount(@Unsigned byte value) {
        segment.set(LAYOUT$refPicMarkingOpCount, OFFSET$refPicMarkingOpCount, value);
        return this;
    }


    public StdVideoEncodeH264ReferenceListsInfo pRefList0ModOperations(@Nullable IStdVideoEncodeH264RefListModEntry value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRefList0ModOperationsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoEncodeH264RefListModEntry.Ptr pRefList0ModOperations(int assumedCount) {
        MemorySegment s = pRefList0ModOperationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoEncodeH264RefListModEntry.BYTES);
        return new StdVideoEncodeH264RefListModEntry.Ptr(s);
    }

    public @Nullable StdVideoEncodeH264RefListModEntry pRefList0ModOperations() {
        MemorySegment s = pRefList0ModOperationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoEncodeH264RefListModEntry(s);
    }

    public @Pointer(target=StdVideoEncodeH264RefListModEntry.class) @NotNull MemorySegment pRefList0ModOperationsRaw() {
        return segment.get(LAYOUT$pRefList0ModOperations, OFFSET$pRefList0ModOperations);
    }

    public void pRefList0ModOperationsRaw(@Pointer(target=StdVideoEncodeH264RefListModEntry.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRefList0ModOperations, OFFSET$pRefList0ModOperations, value);
    }

    public StdVideoEncodeH264ReferenceListsInfo pRefList1ModOperations(@Nullable IStdVideoEncodeH264RefListModEntry value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRefList1ModOperationsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoEncodeH264RefListModEntry.Ptr pRefList1ModOperations(int assumedCount) {
        MemorySegment s = pRefList1ModOperationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoEncodeH264RefListModEntry.BYTES);
        return new StdVideoEncodeH264RefListModEntry.Ptr(s);
    }

    public @Nullable StdVideoEncodeH264RefListModEntry pRefList1ModOperations() {
        MemorySegment s = pRefList1ModOperationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoEncodeH264RefListModEntry(s);
    }

    public @Pointer(target=StdVideoEncodeH264RefListModEntry.class) @NotNull MemorySegment pRefList1ModOperationsRaw() {
        return segment.get(LAYOUT$pRefList1ModOperations, OFFSET$pRefList1ModOperations);
    }

    public void pRefList1ModOperationsRaw(@Pointer(target=StdVideoEncodeH264RefListModEntry.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRefList1ModOperations, OFFSET$pRefList1ModOperations, value);
    }

    public StdVideoEncodeH264ReferenceListsInfo pRefPicMarkingOperations(@Nullable IStdVideoEncodeH264RefPicMarkingEntry value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRefPicMarkingOperationsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoEncodeH264RefPicMarkingEntry.Ptr pRefPicMarkingOperations(int assumedCount) {
        MemorySegment s = pRefPicMarkingOperationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoEncodeH264RefPicMarkingEntry.BYTES);
        return new StdVideoEncodeH264RefPicMarkingEntry.Ptr(s);
    }

    public @Nullable StdVideoEncodeH264RefPicMarkingEntry pRefPicMarkingOperations() {
        MemorySegment s = pRefPicMarkingOperationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoEncodeH264RefPicMarkingEntry(s);
    }

    public @Pointer(target=StdVideoEncodeH264RefPicMarkingEntry.class) @NotNull MemorySegment pRefPicMarkingOperationsRaw() {
        return segment.get(LAYOUT$pRefPicMarkingOperations, OFFSET$pRefPicMarkingOperations);
    }

    public void pRefPicMarkingOperationsRaw(@Pointer(target=StdVideoEncodeH264RefPicMarkingEntry.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRefPicMarkingOperations, OFFSET$pRefPicMarkingOperations, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoEncodeH264ReferenceListsInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("num_ref_idx_l0_active_minus1"),
        ValueLayout.JAVA_BYTE.withName("num_ref_idx_l1_active_minus1"),
        MemoryLayout.sequenceLayout(H264_MAX_NUM_LIST_REF, ValueLayout.JAVA_BYTE).withName("RefPicList0"),
        MemoryLayout.sequenceLayout(H264_MAX_NUM_LIST_REF, ValueLayout.JAVA_BYTE).withName("RefPicList1"),
        ValueLayout.JAVA_BYTE.withName("refList0ModOpCount"),
        ValueLayout.JAVA_BYTE.withName("refList1ModOpCount"),
        ValueLayout.JAVA_BYTE.withName("refPicMarkingOpCount"),
        MemoryLayout.sequenceLayout(7, ValueLayout.JAVA_BYTE).withName("reserved1"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoEncodeH264RefListModEntry.LAYOUT).withName("pRefList0ModOperations"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoEncodeH264RefListModEntry.LAYOUT).withName("pRefList1ModOperations"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoEncodeH264RefPicMarkingEntry.LAYOUT).withName("pRefPicMarkingOperations")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$num_ref_idx_l0_active_minus1 = PathElement.groupElement("num_ref_idx_l0_active_minus1");
    public static final PathElement PATH$num_ref_idx_l1_active_minus1 = PathElement.groupElement("num_ref_idx_l1_active_minus1");
    public static final PathElement PATH$RefPicList0 = PathElement.groupElement("RefPicList0");
    public static final PathElement PATH$RefPicList1 = PathElement.groupElement("RefPicList1");
    public static final PathElement PATH$refList0ModOpCount = PathElement.groupElement("refList0ModOpCount");
    public static final PathElement PATH$refList1ModOpCount = PathElement.groupElement("refList1ModOpCount");
    public static final PathElement PATH$refPicMarkingOpCount = PathElement.groupElement("refPicMarkingOpCount");
    public static final PathElement PATH$pRefList0ModOperations = PathElement.groupElement("pRefList0ModOperations");
    public static final PathElement PATH$pRefList1ModOperations = PathElement.groupElement("pRefList1ModOperations");
    public static final PathElement PATH$pRefPicMarkingOperations = PathElement.groupElement("pRefPicMarkingOperations");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$num_ref_idx_l0_active_minus1 = (OfByte) LAYOUT.select(PATH$num_ref_idx_l0_active_minus1);
    public static final OfByte LAYOUT$num_ref_idx_l1_active_minus1 = (OfByte) LAYOUT.select(PATH$num_ref_idx_l1_active_minus1);
    public static final SequenceLayout LAYOUT$RefPicList0 = (SequenceLayout) LAYOUT.select(PATH$RefPicList0);
    public static final SequenceLayout LAYOUT$RefPicList1 = (SequenceLayout) LAYOUT.select(PATH$RefPicList1);
    public static final OfByte LAYOUT$refList0ModOpCount = (OfByte) LAYOUT.select(PATH$refList0ModOpCount);
    public static final OfByte LAYOUT$refList1ModOpCount = (OfByte) LAYOUT.select(PATH$refList1ModOpCount);
    public static final OfByte LAYOUT$refPicMarkingOpCount = (OfByte) LAYOUT.select(PATH$refPicMarkingOpCount);
    public static final AddressLayout LAYOUT$pRefList0ModOperations = (AddressLayout) LAYOUT.select(PATH$pRefList0ModOperations);
    public static final AddressLayout LAYOUT$pRefList1ModOperations = (AddressLayout) LAYOUT.select(PATH$pRefList1ModOperations);
    public static final AddressLayout LAYOUT$pRefPicMarkingOperations = (AddressLayout) LAYOUT.select(PATH$pRefPicMarkingOperations);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$num_ref_idx_l0_active_minus1 = LAYOUT$num_ref_idx_l0_active_minus1.byteSize();
    public static final long SIZE$num_ref_idx_l1_active_minus1 = LAYOUT$num_ref_idx_l1_active_minus1.byteSize();
    public static final long SIZE$RefPicList0 = LAYOUT$RefPicList0.byteSize();
    public static final long SIZE$RefPicList1 = LAYOUT$RefPicList1.byteSize();
    public static final long SIZE$refList0ModOpCount = LAYOUT$refList0ModOpCount.byteSize();
    public static final long SIZE$refList1ModOpCount = LAYOUT$refList1ModOpCount.byteSize();
    public static final long SIZE$refPicMarkingOpCount = LAYOUT$refPicMarkingOpCount.byteSize();
    public static final long SIZE$pRefList0ModOperations = LAYOUT$pRefList0ModOperations.byteSize();
    public static final long SIZE$pRefList1ModOperations = LAYOUT$pRefList1ModOperations.byteSize();
    public static final long SIZE$pRefPicMarkingOperations = LAYOUT$pRefPicMarkingOperations.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$num_ref_idx_l0_active_minus1 = LAYOUT.byteOffset(PATH$num_ref_idx_l0_active_minus1);
    public static final long OFFSET$num_ref_idx_l1_active_minus1 = LAYOUT.byteOffset(PATH$num_ref_idx_l1_active_minus1);
    public static final long OFFSET$RefPicList0 = LAYOUT.byteOffset(PATH$RefPicList0);
    public static final long OFFSET$RefPicList1 = LAYOUT.byteOffset(PATH$RefPicList1);
    public static final long OFFSET$refList0ModOpCount = LAYOUT.byteOffset(PATH$refList0ModOpCount);
    public static final long OFFSET$refList1ModOpCount = LAYOUT.byteOffset(PATH$refList1ModOpCount);
    public static final long OFFSET$refPicMarkingOpCount = LAYOUT.byteOffset(PATH$refPicMarkingOpCount);
    public static final long OFFSET$pRefList0ModOperations = LAYOUT.byteOffset(PATH$pRefList0ModOperations);
    public static final long OFFSET$pRefList1ModOperations = LAYOUT.byteOffset(PATH$pRefList1ModOperations);
    public static final long OFFSET$pRefPicMarkingOperations = LAYOUT.byteOffset(PATH$pRefPicMarkingOperations);
}
