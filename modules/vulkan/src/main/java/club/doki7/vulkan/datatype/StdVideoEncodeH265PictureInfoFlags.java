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

/// Represents a pointer to a {@code StdVideoEncodeH265PictureInfoFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH265PictureInfoFlags {
///     uint32_t is_reference : 1; // @link substring="is_reference" target="#is_reference"
///     uint32_t IrapPicFlag : 1; // @link substring="IrapPicFlag" target="#IrapPicFlag"
///     uint32_t used_for_long_term_reference : 1; // @link substring="used_for_long_term_reference" target="#used_for_long_term_reference"
///     uint32_t discardable_flag : 1; // @link substring="discardable_flag" target="#discardable_flag"
///     uint32_t cross_layer_bla_flag : 1; // @link substring="cross_layer_bla_flag" target="#cross_layer_bla_flag"
///     uint32_t pic_output_flag : 1; // @link substring="pic_output_flag" target="#pic_output_flag"
///     uint32_t no_output_of_prior_pics_flag : 1; // @link substring="no_output_of_prior_pics_flag" target="#no_output_of_prior_pics_flag"
///     uint32_t short_term_ref_pic_set_sps_flag : 1; // @link substring="short_term_ref_pic_set_sps_flag" target="#short_term_ref_pic_set_sps_flag"
///     uint32_t slice_temporal_mvp_enabled_flag : 1; // @link substring="slice_temporal_mvp_enabled_flag" target="#slice_temporal_mvp_enabled_flag"
///     uint32_t reserved : 23;
/// } StdVideoEncodeH265PictureInfoFlags;
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
public record StdVideoEncodeH265PictureInfoFlags(@NotNull MemorySegment segment) implements IStdVideoEncodeH265PictureInfoFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH265PictureInfoFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH265PictureInfoFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH265PictureInfoFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH265PictureInfoFlags, Iterable<StdVideoEncodeH265PictureInfoFlags> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH265PictureInfoFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH265PictureInfoFlags at(long index) {
            return new StdVideoEncodeH265PictureInfoFlags(segment.asSlice(index * StdVideoEncodeH265PictureInfoFlags.BYTES, StdVideoEncodeH265PictureInfoFlags.BYTES));
        }

        public StdVideoEncodeH265PictureInfoFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH265PictureInfoFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH265PictureInfoFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH265PictureInfoFlags.BYTES, StdVideoEncodeH265PictureInfoFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH265PictureInfoFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH265PictureInfoFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH265PictureInfoFlags.BYTES,
                (end - start) * StdVideoEncodeH265PictureInfoFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH265PictureInfoFlags.BYTES));
        }

        public StdVideoEncodeH265PictureInfoFlags[] toArray() {
            StdVideoEncodeH265PictureInfoFlags[] ret = new StdVideoEncodeH265PictureInfoFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH265PictureInfoFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH265PictureInfoFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH265PictureInfoFlags.BYTES;
            }

            @Override
            public StdVideoEncodeH265PictureInfoFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH265PictureInfoFlags ret = new StdVideoEncodeH265PictureInfoFlags(segment.asSlice(0, StdVideoEncodeH265PictureInfoFlags.BYTES));
                segment = segment.asSlice(StdVideoEncodeH265PictureInfoFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH265PictureInfoFlags allocate(Arena arena) {
        return new StdVideoEncodeH265PictureInfoFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH265PictureInfoFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH265PictureInfoFlags.Ptr(segment);
    }

    public static StdVideoEncodeH265PictureInfoFlags clone(Arena arena, StdVideoEncodeH265PictureInfoFlags src) {
        StdVideoEncodeH265PictureInfoFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean is_reference() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoEncodeH265PictureInfoFlags is_reference(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean IrapPicFlag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoEncodeH265PictureInfoFlags IrapPicFlag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean used_for_long_term_reference() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoEncodeH265PictureInfoFlags used_for_long_term_reference(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean discardable_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoEncodeH265PictureInfoFlags discardable_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public boolean cross_layer_bla_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        return BitfieldUtil.readBit(s, 4);
    }

    public StdVideoEncodeH265PictureInfoFlags cross_layer_bla_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        BitfieldUtil.writeBit(s, 4, value);
        return this;
    }

    public boolean pic_output_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        return BitfieldUtil.readBit(s, 5);
    }

    public StdVideoEncodeH265PictureInfoFlags pic_output_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        BitfieldUtil.writeBit(s, 5, value);
        return this;
    }

    public boolean no_output_of_prior_pics_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        return BitfieldUtil.readBit(s, 6);
    }

    public StdVideoEncodeH265PictureInfoFlags no_output_of_prior_pics_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        BitfieldUtil.writeBit(s, 6, value);
        return this;
    }

    public boolean short_term_ref_pic_set_sps_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        return BitfieldUtil.readBit(s, 7);
    }

    public StdVideoEncodeH265PictureInfoFlags short_term_ref_pic_set_sps_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        BitfieldUtil.writeBit(s, 7, value);
        return this;
    }

    public boolean slice_temporal_mvp_enabled_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        return BitfieldUtil.readBit(s, 8);
    }

    public StdVideoEncodeH265PictureInfoFlags slice_temporal_mvp_enabled_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$is_reference$reserved, LAYOUT$bitfield$is_reference$reserved);
        BitfieldUtil.writeBit(s, 8, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$is_reference$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$is_reference$reserved = PathElement.groupElement("is_reference$reserved");

    public static final OfInt LAYOUT$bitfield$is_reference$reserved = (OfInt) LAYOUT.select(PATH$bitfield$is_reference$reserved);


    public static final long OFFSET$bitfield$is_reference$reserved = LAYOUT.byteOffset(PATH$bitfield$is_reference$reserved);
}
