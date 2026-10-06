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

/// Represents a pointer to a {@code StdVideoEncodeH265SliceSegmentHeader} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH265SliceSegmentHeader {
///     StdVideoEncodeH265SliceSegmentHeaderFlags flags; // @link substring="StdVideoEncodeH265SliceSegmentHeaderFlags" target="StdVideoEncodeH265SliceSegmentHeaderFlags" @link substring="flags" target="#flags"
///     StdVideoH265SliceType slice_type; // @link substring="StdVideoH265SliceType" target="StdVideoH265SliceType" @link substring="slice_type" target="#slice_type"
///     uint32_t slice_segment_address; // @link substring="slice_segment_address" target="#slice_segment_address"
///     uint8_t collocated_ref_idx; // @link substring="collocated_ref_idx" target="#collocated_ref_idx"
///     uint8_t MaxNumMergeCand; // @link substring="MaxNumMergeCand" target="#MaxNumMergeCand"
///     int8_t slice_cb_qp_offset; // @link substring="slice_cb_qp_offset" target="#slice_cb_qp_offset"
///     int8_t slice_cr_qp_offset; // @link substring="slice_cr_qp_offset" target="#slice_cr_qp_offset"
///     int8_t slice_beta_offset_div2; // @link substring="slice_beta_offset_div2" target="#slice_beta_offset_div2"
///     int8_t slice_tc_offset_div2; // @link substring="slice_tc_offset_div2" target="#slice_tc_offset_div2"
///     int8_t slice_act_y_qp_offset; // @link substring="slice_act_y_qp_offset" target="#slice_act_y_qp_offset"
///     int8_t slice_act_cb_qp_offset; // @link substring="slice_act_cb_qp_offset" target="#slice_act_cb_qp_offset"
///     int8_t slice_act_cr_qp_offset; // @link substring="slice_act_cr_qp_offset" target="#slice_act_cr_qp_offset"
///     int8_t slice_qp_delta; // @link substring="slice_qp_delta" target="#slice_qp_delta"
///     uint16_t reserved1;
///     StdVideoEncodeH265WeightTable const* pWeightTable; // optional // @link substring="StdVideoEncodeH265WeightTable" target="StdVideoEncodeH265WeightTable" @link substring="pWeightTable" target="#pWeightTable"
/// } StdVideoEncodeH265SliceSegmentHeader;
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
public record StdVideoEncodeH265SliceSegmentHeader(@NotNull MemorySegment segment) implements IStdVideoEncodeH265SliceSegmentHeader {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH265SliceSegmentHeader}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH265SliceSegmentHeader to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH265SliceSegmentHeader.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH265SliceSegmentHeader, Iterable<StdVideoEncodeH265SliceSegmentHeader> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH265SliceSegmentHeader.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH265SliceSegmentHeader at(long index) {
            return new StdVideoEncodeH265SliceSegmentHeader(segment.asSlice(index * StdVideoEncodeH265SliceSegmentHeader.BYTES, StdVideoEncodeH265SliceSegmentHeader.BYTES));
        }

        public StdVideoEncodeH265SliceSegmentHeader.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH265SliceSegmentHeader> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH265SliceSegmentHeader value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH265SliceSegmentHeader.BYTES, StdVideoEncodeH265SliceSegmentHeader.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH265SliceSegmentHeader.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH265SliceSegmentHeader.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH265SliceSegmentHeader.BYTES,
                (end - start) * StdVideoEncodeH265SliceSegmentHeader.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH265SliceSegmentHeader.BYTES));
        }

        public StdVideoEncodeH265SliceSegmentHeader[] toArray() {
            StdVideoEncodeH265SliceSegmentHeader[] ret = new StdVideoEncodeH265SliceSegmentHeader[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH265SliceSegmentHeader> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH265SliceSegmentHeader> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH265SliceSegmentHeader.BYTES;
            }

            @Override
            public StdVideoEncodeH265SliceSegmentHeader next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH265SliceSegmentHeader ret = new StdVideoEncodeH265SliceSegmentHeader(segment.asSlice(0, StdVideoEncodeH265SliceSegmentHeader.BYTES));
                segment = segment.asSlice(StdVideoEncodeH265SliceSegmentHeader.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH265SliceSegmentHeader allocate(Arena arena) {
        return new StdVideoEncodeH265SliceSegmentHeader(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH265SliceSegmentHeader.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH265SliceSegmentHeader.Ptr(segment);
    }

    public static StdVideoEncodeH265SliceSegmentHeader clone(Arena arena, StdVideoEncodeH265SliceSegmentHeader src) {
        StdVideoEncodeH265SliceSegmentHeader ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoEncodeH265SliceSegmentHeaderFlags flags() {
        return new StdVideoEncodeH265SliceSegmentHeaderFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoEncodeH265SliceSegmentHeader flags(@NotNull StdVideoEncodeH265SliceSegmentHeaderFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoEncodeH265SliceSegmentHeader flags(Consumer<@NotNull StdVideoEncodeH265SliceSegmentHeaderFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoH265SliceType.class) int slice_type() {
        return segment.get(LAYOUT$slice_type, OFFSET$slice_type);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_type(@EnumType(StdVideoH265SliceType.class) int value) {
        segment.set(LAYOUT$slice_type, OFFSET$slice_type, value);
        return this;
    }

    public @Unsigned int slice_segment_address() {
        return segment.get(LAYOUT$slice_segment_address, OFFSET$slice_segment_address);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_segment_address(@Unsigned int value) {
        segment.set(LAYOUT$slice_segment_address, OFFSET$slice_segment_address, value);
        return this;
    }

    public @Unsigned byte collocated_ref_idx() {
        return segment.get(LAYOUT$collocated_ref_idx, OFFSET$collocated_ref_idx);
    }

    public StdVideoEncodeH265SliceSegmentHeader collocated_ref_idx(@Unsigned byte value) {
        segment.set(LAYOUT$collocated_ref_idx, OFFSET$collocated_ref_idx, value);
        return this;
    }

    public @Unsigned byte MaxNumMergeCand() {
        return segment.get(LAYOUT$MaxNumMergeCand, OFFSET$MaxNumMergeCand);
    }

    public StdVideoEncodeH265SliceSegmentHeader MaxNumMergeCand(@Unsigned byte value) {
        segment.set(LAYOUT$MaxNumMergeCand, OFFSET$MaxNumMergeCand, value);
        return this;
    }

    public byte slice_cb_qp_offset() {
        return segment.get(LAYOUT$slice_cb_qp_offset, OFFSET$slice_cb_qp_offset);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_cb_qp_offset(byte value) {
        segment.set(LAYOUT$slice_cb_qp_offset, OFFSET$slice_cb_qp_offset, value);
        return this;
    }

    public byte slice_cr_qp_offset() {
        return segment.get(LAYOUT$slice_cr_qp_offset, OFFSET$slice_cr_qp_offset);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_cr_qp_offset(byte value) {
        segment.set(LAYOUT$slice_cr_qp_offset, OFFSET$slice_cr_qp_offset, value);
        return this;
    }

    public byte slice_beta_offset_div2() {
        return segment.get(LAYOUT$slice_beta_offset_div2, OFFSET$slice_beta_offset_div2);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_beta_offset_div2(byte value) {
        segment.set(LAYOUT$slice_beta_offset_div2, OFFSET$slice_beta_offset_div2, value);
        return this;
    }

    public byte slice_tc_offset_div2() {
        return segment.get(LAYOUT$slice_tc_offset_div2, OFFSET$slice_tc_offset_div2);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_tc_offset_div2(byte value) {
        segment.set(LAYOUT$slice_tc_offset_div2, OFFSET$slice_tc_offset_div2, value);
        return this;
    }

    public byte slice_act_y_qp_offset() {
        return segment.get(LAYOUT$slice_act_y_qp_offset, OFFSET$slice_act_y_qp_offset);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_act_y_qp_offset(byte value) {
        segment.set(LAYOUT$slice_act_y_qp_offset, OFFSET$slice_act_y_qp_offset, value);
        return this;
    }

    public byte slice_act_cb_qp_offset() {
        return segment.get(LAYOUT$slice_act_cb_qp_offset, OFFSET$slice_act_cb_qp_offset);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_act_cb_qp_offset(byte value) {
        segment.set(LAYOUT$slice_act_cb_qp_offset, OFFSET$slice_act_cb_qp_offset, value);
        return this;
    }

    public byte slice_act_cr_qp_offset() {
        return segment.get(LAYOUT$slice_act_cr_qp_offset, OFFSET$slice_act_cr_qp_offset);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_act_cr_qp_offset(byte value) {
        segment.set(LAYOUT$slice_act_cr_qp_offset, OFFSET$slice_act_cr_qp_offset, value);
        return this;
    }

    public byte slice_qp_delta() {
        return segment.get(LAYOUT$slice_qp_delta, OFFSET$slice_qp_delta);
    }

    public StdVideoEncodeH265SliceSegmentHeader slice_qp_delta(byte value) {
        segment.set(LAYOUT$slice_qp_delta, OFFSET$slice_qp_delta, value);
        return this;
    }


    public StdVideoEncodeH265SliceSegmentHeader pWeightTable(@Nullable IStdVideoEncodeH265WeightTable value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pWeightTableRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoEncodeH265WeightTable.Ptr pWeightTable(int assumedCount) {
        MemorySegment s = pWeightTableRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoEncodeH265WeightTable.BYTES);
        return new StdVideoEncodeH265WeightTable.Ptr(s);
    }

    public @Nullable StdVideoEncodeH265WeightTable pWeightTable() {
        MemorySegment s = pWeightTableRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoEncodeH265WeightTable(s);
    }

    public @Pointer(target=StdVideoEncodeH265WeightTable.class) @NotNull MemorySegment pWeightTableRaw() {
        return segment.get(LAYOUT$pWeightTable, OFFSET$pWeightTable);
    }

    public void pWeightTableRaw(@Pointer(target=StdVideoEncodeH265WeightTable.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pWeightTable, OFFSET$pWeightTable, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoEncodeH265SliceSegmentHeaderFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("slice_type"),
        ValueLayout.JAVA_INT.withName("slice_segment_address"),
        ValueLayout.JAVA_BYTE.withName("collocated_ref_idx"),
        ValueLayout.JAVA_BYTE.withName("MaxNumMergeCand"),
        ValueLayout.JAVA_BYTE.withName("slice_cb_qp_offset"),
        ValueLayout.JAVA_BYTE.withName("slice_cr_qp_offset"),
        ValueLayout.JAVA_BYTE.withName("slice_beta_offset_div2"),
        ValueLayout.JAVA_BYTE.withName("slice_tc_offset_div2"),
        ValueLayout.JAVA_BYTE.withName("slice_act_y_qp_offset"),
        ValueLayout.JAVA_BYTE.withName("slice_act_cb_qp_offset"),
        ValueLayout.JAVA_BYTE.withName("slice_act_cr_qp_offset"),
        ValueLayout.JAVA_BYTE.withName("slice_qp_delta"),
        ValueLayout.JAVA_SHORT.withName("reserved1"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoEncodeH265WeightTable.LAYOUT).withName("pWeightTable")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$slice_type = PathElement.groupElement("slice_type");
    public static final PathElement PATH$slice_segment_address = PathElement.groupElement("slice_segment_address");
    public static final PathElement PATH$collocated_ref_idx = PathElement.groupElement("collocated_ref_idx");
    public static final PathElement PATH$MaxNumMergeCand = PathElement.groupElement("MaxNumMergeCand");
    public static final PathElement PATH$slice_cb_qp_offset = PathElement.groupElement("slice_cb_qp_offset");
    public static final PathElement PATH$slice_cr_qp_offset = PathElement.groupElement("slice_cr_qp_offset");
    public static final PathElement PATH$slice_beta_offset_div2 = PathElement.groupElement("slice_beta_offset_div2");
    public static final PathElement PATH$slice_tc_offset_div2 = PathElement.groupElement("slice_tc_offset_div2");
    public static final PathElement PATH$slice_act_y_qp_offset = PathElement.groupElement("slice_act_y_qp_offset");
    public static final PathElement PATH$slice_act_cb_qp_offset = PathElement.groupElement("slice_act_cb_qp_offset");
    public static final PathElement PATH$slice_act_cr_qp_offset = PathElement.groupElement("slice_act_cr_qp_offset");
    public static final PathElement PATH$slice_qp_delta = PathElement.groupElement("slice_qp_delta");
    public static final PathElement PATH$pWeightTable = PathElement.groupElement("pWeightTable");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$slice_type = (OfInt) LAYOUT.select(PATH$slice_type);
    public static final OfInt LAYOUT$slice_segment_address = (OfInt) LAYOUT.select(PATH$slice_segment_address);
    public static final OfByte LAYOUT$collocated_ref_idx = (OfByte) LAYOUT.select(PATH$collocated_ref_idx);
    public static final OfByte LAYOUT$MaxNumMergeCand = (OfByte) LAYOUT.select(PATH$MaxNumMergeCand);
    public static final OfByte LAYOUT$slice_cb_qp_offset = (OfByte) LAYOUT.select(PATH$slice_cb_qp_offset);
    public static final OfByte LAYOUT$slice_cr_qp_offset = (OfByte) LAYOUT.select(PATH$slice_cr_qp_offset);
    public static final OfByte LAYOUT$slice_beta_offset_div2 = (OfByte) LAYOUT.select(PATH$slice_beta_offset_div2);
    public static final OfByte LAYOUT$slice_tc_offset_div2 = (OfByte) LAYOUT.select(PATH$slice_tc_offset_div2);
    public static final OfByte LAYOUT$slice_act_y_qp_offset = (OfByte) LAYOUT.select(PATH$slice_act_y_qp_offset);
    public static final OfByte LAYOUT$slice_act_cb_qp_offset = (OfByte) LAYOUT.select(PATH$slice_act_cb_qp_offset);
    public static final OfByte LAYOUT$slice_act_cr_qp_offset = (OfByte) LAYOUT.select(PATH$slice_act_cr_qp_offset);
    public static final OfByte LAYOUT$slice_qp_delta = (OfByte) LAYOUT.select(PATH$slice_qp_delta);
    public static final AddressLayout LAYOUT$pWeightTable = (AddressLayout) LAYOUT.select(PATH$pWeightTable);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$slice_type = LAYOUT$slice_type.byteSize();
    public static final long SIZE$slice_segment_address = LAYOUT$slice_segment_address.byteSize();
    public static final long SIZE$collocated_ref_idx = LAYOUT$collocated_ref_idx.byteSize();
    public static final long SIZE$MaxNumMergeCand = LAYOUT$MaxNumMergeCand.byteSize();
    public static final long SIZE$slice_cb_qp_offset = LAYOUT$slice_cb_qp_offset.byteSize();
    public static final long SIZE$slice_cr_qp_offset = LAYOUT$slice_cr_qp_offset.byteSize();
    public static final long SIZE$slice_beta_offset_div2 = LAYOUT$slice_beta_offset_div2.byteSize();
    public static final long SIZE$slice_tc_offset_div2 = LAYOUT$slice_tc_offset_div2.byteSize();
    public static final long SIZE$slice_act_y_qp_offset = LAYOUT$slice_act_y_qp_offset.byteSize();
    public static final long SIZE$slice_act_cb_qp_offset = LAYOUT$slice_act_cb_qp_offset.byteSize();
    public static final long SIZE$slice_act_cr_qp_offset = LAYOUT$slice_act_cr_qp_offset.byteSize();
    public static final long SIZE$slice_qp_delta = LAYOUT$slice_qp_delta.byteSize();
    public static final long SIZE$pWeightTable = LAYOUT$pWeightTable.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$slice_type = LAYOUT.byteOffset(PATH$slice_type);
    public static final long OFFSET$slice_segment_address = LAYOUT.byteOffset(PATH$slice_segment_address);
    public static final long OFFSET$collocated_ref_idx = LAYOUT.byteOffset(PATH$collocated_ref_idx);
    public static final long OFFSET$MaxNumMergeCand = LAYOUT.byteOffset(PATH$MaxNumMergeCand);
    public static final long OFFSET$slice_cb_qp_offset = LAYOUT.byteOffset(PATH$slice_cb_qp_offset);
    public static final long OFFSET$slice_cr_qp_offset = LAYOUT.byteOffset(PATH$slice_cr_qp_offset);
    public static final long OFFSET$slice_beta_offset_div2 = LAYOUT.byteOffset(PATH$slice_beta_offset_div2);
    public static final long OFFSET$slice_tc_offset_div2 = LAYOUT.byteOffset(PATH$slice_tc_offset_div2);
    public static final long OFFSET$slice_act_y_qp_offset = LAYOUT.byteOffset(PATH$slice_act_y_qp_offset);
    public static final long OFFSET$slice_act_cb_qp_offset = LAYOUT.byteOffset(PATH$slice_act_cb_qp_offset);
    public static final long OFFSET$slice_act_cr_qp_offset = LAYOUT.byteOffset(PATH$slice_act_cr_qp_offset);
    public static final long OFFSET$slice_qp_delta = LAYOUT.byteOffset(PATH$slice_qp_delta);
    public static final long OFFSET$pWeightTable = LAYOUT.byteOffset(PATH$pWeightTable);
}
