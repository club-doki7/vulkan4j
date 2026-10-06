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

/// Represents a pointer to a {@code StdVideoDecodeH265PictureInfoFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoDecodeH265PictureInfoFlags {
///     uint32_t IrapPicFlag : 1; // @link substring="IrapPicFlag" target="#IrapPicFlag"
///     uint32_t IdrPicFlag : 1; // @link substring="IdrPicFlag" target="#IdrPicFlag"
///     uint32_t IsReference : 1; // @link substring="IsReference" target="#IsReference"
///     uint32_t short_term_ref_pic_set_sps_flag : 1; // @link substring="short_term_ref_pic_set_sps_flag" target="#short_term_ref_pic_set_sps_flag"
/// } StdVideoDecodeH265PictureInfoFlags;
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
public record StdVideoDecodeH265PictureInfoFlags(@NotNull MemorySegment segment) implements IStdVideoDecodeH265PictureInfoFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoDecodeH265PictureInfoFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoDecodeH265PictureInfoFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoDecodeH265PictureInfoFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoDecodeH265PictureInfoFlags, Iterable<StdVideoDecodeH265PictureInfoFlags> {
        public long size() {
            return segment.byteSize() / StdVideoDecodeH265PictureInfoFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoDecodeH265PictureInfoFlags at(long index) {
            return new StdVideoDecodeH265PictureInfoFlags(segment.asSlice(index * StdVideoDecodeH265PictureInfoFlags.BYTES, StdVideoDecodeH265PictureInfoFlags.BYTES));
        }

        public StdVideoDecodeH265PictureInfoFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoDecodeH265PictureInfoFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoDecodeH265PictureInfoFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoDecodeH265PictureInfoFlags.BYTES, StdVideoDecodeH265PictureInfoFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoDecodeH265PictureInfoFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoDecodeH265PictureInfoFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoDecodeH265PictureInfoFlags.BYTES,
                (end - start) * StdVideoDecodeH265PictureInfoFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoDecodeH265PictureInfoFlags.BYTES));
        }

        public StdVideoDecodeH265PictureInfoFlags[] toArray() {
            StdVideoDecodeH265PictureInfoFlags[] ret = new StdVideoDecodeH265PictureInfoFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoDecodeH265PictureInfoFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoDecodeH265PictureInfoFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoDecodeH265PictureInfoFlags.BYTES;
            }

            @Override
            public StdVideoDecodeH265PictureInfoFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoDecodeH265PictureInfoFlags ret = new StdVideoDecodeH265PictureInfoFlags(segment.asSlice(0, StdVideoDecodeH265PictureInfoFlags.BYTES));
                segment = segment.asSlice(StdVideoDecodeH265PictureInfoFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoDecodeH265PictureInfoFlags allocate(Arena arena) {
        return new StdVideoDecodeH265PictureInfoFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoDecodeH265PictureInfoFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoDecodeH265PictureInfoFlags.Ptr(segment);
    }

    public static StdVideoDecodeH265PictureInfoFlags clone(Arena arena, StdVideoDecodeH265PictureInfoFlags src) {
        StdVideoDecodeH265PictureInfoFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean IrapPicFlag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag, LAYOUT$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoDecodeH265PictureInfoFlags IrapPicFlag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag, LAYOUT$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean IdrPicFlag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag, LAYOUT$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoDecodeH265PictureInfoFlags IdrPicFlag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag, LAYOUT$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public boolean IsReference() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag, LAYOUT$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);
        return BitfieldUtil.readBit(s, 2);
    }

    public StdVideoDecodeH265PictureInfoFlags IsReference(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag, LAYOUT$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);
        BitfieldUtil.writeBit(s, 2, value);
        return this;
    }

    public boolean short_term_ref_pic_set_sps_flag() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag, LAYOUT$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);
        return BitfieldUtil.readBit(s, 3);
    }

    public StdVideoDecodeH265PictureInfoFlags short_term_ref_pic_set_sps_flag(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag, LAYOUT$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);
        BitfieldUtil.writeBit(s, 3, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag = PathElement.groupElement("IrapPicFlag$short_term_ref_pic_set_sps_flag");

    public static final OfInt LAYOUT$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag = (OfInt) LAYOUT.select(PATH$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);


    public static final long OFFSET$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag = LAYOUT.byteOffset(PATH$bitfield$IrapPicFlag$short_term_ref_pic_set_sps_flag);
}
