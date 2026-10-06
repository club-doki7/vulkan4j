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
import club.doki7.ffm.bits.BitfieldUtil;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a {@code StdVideoAV1SequenceHeaderFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1SequenceHeaderFlags {
///     uint32_t still_picture : 1; // @link substring="still_picture" target="#still_picture"
///     uint32_t reduced_still_picture_header : 1; // @link substring="reduced_still_picture_header" target="#reduced_still_picture_header"
///     uint32_t use_128x128_superblock : 1; // @link substring="use_128x128_superblock" target="#use_128x128_superblock"
///     uint32_t enable_filter_intra : 1; // @link substring="enable_filter_intra" target="#enable_filter_intra"
///     uint32_t enable_intra_edge_filter : 1; // @link substring="enable_intra_edge_filter" target="#enable_intra_edge_filter"
///     uint32_t enable_interintra_compound : 1; // @link substring="enable_interintra_compound" target="#enable_interintra_compound"
///     uint32_t enable_masked_compound : 1; // @link substring="enable_masked_compound" target="#enable_masked_compound"
///     uint32_t enable_warped_motion : 1; // @link substring="enable_warped_motion" target="#enable_warped_motion"
///     uint32_t enable_dual_filter : 1; // @link substring="enable_dual_filter" target="#enable_dual_filter"
///     uint32_t enable_order_hint : 1; // @link substring="enable_order_hint" target="#enable_order_hint"
///     uint32_t enable_jnt_comp : 1; // @link substring="enable_jnt_comp" target="#enable_jnt_comp"
///     uint32_t enable_ref_frame_mvs : 1; // @link substring="enable_ref_frame_mvs" target="#enable_ref_frame_mvs"
///     uint32_t frame_id_numbers_present_flag : 1; // @link substring="frame_id_numbers_present_flag" target="#frame_id_numbers_present_flag"
///     uint32_t enable_superres : 1; // @link substring="enable_superres" target="#enable_superres"
///     uint32_t enable_cdef : 1; // @link substring="enable_cdef" target="#enable_cdef"
///     uint32_t enable_restoration : 1; // @link substring="enable_restoration" target="#enable_restoration"
///     uint32_t film_grain_params_present : 1; // @link substring="film_grain_params_present" target="#film_grain_params_present"
///     uint32_t timing_info_present_flag : 1; // @link substring="timing_info_present_flag" target="#timing_info_present_flag"
///     uint32_t initial_display_delay_present_flag : 1; // @link substring="initial_display_delay_present_flag" target="#initial_display_delay_present_flag"
///     uint32_t reserved : 13;
/// } StdVideoAV1SequenceHeaderFlags;
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
public record StdVideoAV1SequenceHeaderFlags(@NotNull MemorySegment segment) implements IStdVideoAV1SequenceHeaderFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1SequenceHeaderFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1SequenceHeaderFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1SequenceHeaderFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1SequenceHeaderFlags, Iterable<StdVideoAV1SequenceHeaderFlags> {
        public long size() {
            return segment.byteSize() / StdVideoAV1SequenceHeaderFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1SequenceHeaderFlags at(long index) {
            return new StdVideoAV1SequenceHeaderFlags(segment.asSlice(index * StdVideoAV1SequenceHeaderFlags.BYTES, StdVideoAV1SequenceHeaderFlags.BYTES));
        }

        public StdVideoAV1SequenceHeaderFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1SequenceHeaderFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1SequenceHeaderFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1SequenceHeaderFlags.BYTES, StdVideoAV1SequenceHeaderFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1SequenceHeaderFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1SequenceHeaderFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1SequenceHeaderFlags.BYTES,
                (end - start) * StdVideoAV1SequenceHeaderFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1SequenceHeaderFlags.BYTES));
        }

        public StdVideoAV1SequenceHeaderFlags[] toArray() {
            StdVideoAV1SequenceHeaderFlags[] ret = new StdVideoAV1SequenceHeaderFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1SequenceHeaderFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1SequenceHeaderFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1SequenceHeaderFlags.BYTES;
            }

            @Override
            public StdVideoAV1SequenceHeaderFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1SequenceHeaderFlags ret = new StdVideoAV1SequenceHeaderFlags(segment.asSlice(0, StdVideoAV1SequenceHeaderFlags.BYTES));
                segment = segment.asSlice(StdVideoAV1SequenceHeaderFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1SequenceHeaderFlags allocate(Arena arena) {
        return new StdVideoAV1SequenceHeaderFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1SequenceHeaderFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1SequenceHeaderFlags.Ptr(segment);
    }

    public static StdVideoAV1SequenceHeaderFlags clone(Arena arena, StdVideoAV1SequenceHeaderFlags src) {
        StdVideoAV1SequenceHeaderFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean still_picture() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoAV1SequenceHeaderFlags still_picture(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean reduced_still_picture_header() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoAV1SequenceHeaderFlags reduced_still_picture_header(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean use_128x128_superblock() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoAV1SequenceHeaderFlags use_128x128_superblock(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean enable_filter_intra() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoAV1SequenceHeaderFlags enable_filter_intra(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean enable_intra_edge_filter() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoAV1SequenceHeaderFlags enable_intra_edge_filter(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean enable_interintra_compound() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoAV1SequenceHeaderFlags enable_interintra_compound(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean enable_masked_compound() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoAV1SequenceHeaderFlags enable_masked_compound(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean enable_warped_motion() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoAV1SequenceHeaderFlags enable_warped_motion(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 7, value);
        return this;
    }

    public boolean enable_dual_filter() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 8);
    }

    public StdVideoAV1SequenceHeaderFlags enable_dual_filter(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 8, value);
        return this;
    }

    public boolean enable_order_hint() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 9);
    }

    public StdVideoAV1SequenceHeaderFlags enable_order_hint(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 9, value);
        return this;
    }

    public boolean enable_jnt_comp() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 10);
    }

    public StdVideoAV1SequenceHeaderFlags enable_jnt_comp(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 10, value);
        return this;
    }

    public boolean enable_ref_frame_mvs() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 11);
    }

    public StdVideoAV1SequenceHeaderFlags enable_ref_frame_mvs(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 11, value);
        return this;
    }

    public boolean frame_id_numbers_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 12);
    }

    public StdVideoAV1SequenceHeaderFlags frame_id_numbers_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 12, value);
        return this;
    }

    public boolean enable_superres() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 13);
    }

    public StdVideoAV1SequenceHeaderFlags enable_superres(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 13, value);
        return this;
    }

    public boolean enable_cdef() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 14);
    }

    public StdVideoAV1SequenceHeaderFlags enable_cdef(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 14, value);
        return this;
    }

    public boolean enable_restoration() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 15);
    }

    public StdVideoAV1SequenceHeaderFlags enable_restoration(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 15, value);
        return this;
    }

    public boolean film_grain_params_present() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 16);
    }

    public StdVideoAV1SequenceHeaderFlags film_grain_params_present(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 16, value);
        return this;
    }

    public boolean timing_info_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 17);
    }

    public StdVideoAV1SequenceHeaderFlags timing_info_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 17, value);
        return this;
    }

    public boolean initial_display_delay_present_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        return BitfieldUtil.readBit(s, 18);
    }

    public StdVideoAV1SequenceHeaderFlags initial_display_delay_present_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$still_picture$reserved, LAYOUT$bitfield$still_picture$reserved);
        BitfieldUtil.writeBit(s, 18, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$still_picture$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$still_picture$reserved = PathElement.groupElement("still_picture$reserved");

    public static final OfInt LAYOUT$bitfield$still_picture$reserved = (OfInt) LAYOUT.select(PATH$bitfield$still_picture$reserved);


    public static final long OFFSET$bitfield$still_picture$reserved = LAYOUT.byteOffset(PATH$bitfield$still_picture$reserved);
}
