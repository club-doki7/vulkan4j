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

/// Represents a pointer to a {@code StdVideoDecodeH264PictureInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoDecodeH264PictureInfo {
///     StdVideoDecodeH264PictureInfoFlags flags; // @link substring="StdVideoDecodeH264PictureInfoFlags" target="StdVideoDecodeH264PictureInfoFlags" @link substring="flags" target="#flags"
///     uint8_t seq_parameter_set_id; // @link substring="seq_parameter_set_id" target="#seq_parameter_set_id"
///     uint8_t pic_parameter_set_id; // @link substring="pic_parameter_set_id" target="#pic_parameter_set_id"
///     uint8_t reserved1;
///     uint8_t reserved2;
///     uint16_t frame_num; // @link substring="frame_num" target="#frame_num"
///     uint16_t idr_pic_id; // @link substring="idr_pic_id" target="#idr_pic_id"
///     int32_t[STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_LIST_SIZE] PicOrderCnt; // @link substring="PicOrderCnt" target="#PicOrderCnt"
/// } StdVideoDecodeH264PictureInfo;
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
public record StdVideoDecodeH264PictureInfo(@NotNull MemorySegment segment) implements IStdVideoDecodeH264PictureInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoDecodeH264PictureInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoDecodeH264PictureInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoDecodeH264PictureInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoDecodeH264PictureInfo, Iterable<StdVideoDecodeH264PictureInfo> {
        public long size() {
            return segment.byteSize() / StdVideoDecodeH264PictureInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoDecodeH264PictureInfo at(long index) {
            return new StdVideoDecodeH264PictureInfo(segment.asSlice(index * StdVideoDecodeH264PictureInfo.BYTES, StdVideoDecodeH264PictureInfo.BYTES));
        }

        public StdVideoDecodeH264PictureInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoDecodeH264PictureInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoDecodeH264PictureInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoDecodeH264PictureInfo.BYTES, StdVideoDecodeH264PictureInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoDecodeH264PictureInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoDecodeH264PictureInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoDecodeH264PictureInfo.BYTES,
                (end - start) * StdVideoDecodeH264PictureInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoDecodeH264PictureInfo.BYTES));
        }

        public StdVideoDecodeH264PictureInfo[] toArray() {
            StdVideoDecodeH264PictureInfo[] ret = new StdVideoDecodeH264PictureInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoDecodeH264PictureInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoDecodeH264PictureInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoDecodeH264PictureInfo.BYTES;
            }

            @Override
            public StdVideoDecodeH264PictureInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoDecodeH264PictureInfo ret = new StdVideoDecodeH264PictureInfo(segment.asSlice(0, StdVideoDecodeH264PictureInfo.BYTES));
                segment = segment.asSlice(StdVideoDecodeH264PictureInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoDecodeH264PictureInfo allocate(Arena arena) {
        return new StdVideoDecodeH264PictureInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoDecodeH264PictureInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoDecodeH264PictureInfo.Ptr(segment);
    }

    public static StdVideoDecodeH264PictureInfo clone(Arena arena, StdVideoDecodeH264PictureInfo src) {
        StdVideoDecodeH264PictureInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoDecodeH264PictureInfoFlags flags() {
        return new StdVideoDecodeH264PictureInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoDecodeH264PictureInfo flags(@NotNull StdVideoDecodeH264PictureInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoDecodeH264PictureInfo flags(Consumer<@NotNull StdVideoDecodeH264PictureInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte seq_parameter_set_id() {
        return segment.get(LAYOUT$seq_parameter_set_id, OFFSET$seq_parameter_set_id);
    }

    public StdVideoDecodeH264PictureInfo seq_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$seq_parameter_set_id, OFFSET$seq_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte pic_parameter_set_id() {
        return segment.get(LAYOUT$pic_parameter_set_id, OFFSET$pic_parameter_set_id);
    }

    public StdVideoDecodeH264PictureInfo pic_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$pic_parameter_set_id, OFFSET$pic_parameter_set_id, value);
        return this;
    }



    public @Unsigned short frame_num() {
        return segment.get(LAYOUT$frame_num, OFFSET$frame_num);
    }

    public StdVideoDecodeH264PictureInfo frame_num(@Unsigned short value) {
        segment.set(LAYOUT$frame_num, OFFSET$frame_num, value);
        return this;
    }

    public @Unsigned short idr_pic_id() {
        return segment.get(LAYOUT$idr_pic_id, OFFSET$idr_pic_id);
    }

    public StdVideoDecodeH264PictureInfo idr_pic_id(@Unsigned short value) {
        segment.set(LAYOUT$idr_pic_id, OFFSET$idr_pic_id, value);
        return this;
    }

    public IntPtr PicOrderCnt() {
        return new IntPtr(PicOrderCntRaw());
    }

    public StdVideoDecodeH264PictureInfo PicOrderCnt(@NotNull Consumer<IntPtr> consumer) {
        IntPtr ptr = PicOrderCnt();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoDecodeH264PictureInfo PicOrderCnt(IntPtr value) {
        MemorySegment s = PicOrderCntRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment PicOrderCntRaw() {
        return segment.asSlice(OFFSET$PicOrderCnt, SIZE$PicOrderCnt);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoDecodeH264PictureInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("seq_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("pic_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("reserved1"),
        ValueLayout.JAVA_BYTE.withName("reserved2"),
        ValueLayout.JAVA_SHORT.withName("frame_num"),
        ValueLayout.JAVA_SHORT.withName("idr_pic_id"),
        MemoryLayout.sequenceLayout(DECODE_H264_FIELD_ORDER_COUNT_LIST_SIZE, ValueLayout.JAVA_INT).withName("PicOrderCnt")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$seq_parameter_set_id = PathElement.groupElement("seq_parameter_set_id");
    public static final PathElement PATH$pic_parameter_set_id = PathElement.groupElement("pic_parameter_set_id");
    public static final PathElement PATH$frame_num = PathElement.groupElement("frame_num");
    public static final PathElement PATH$idr_pic_id = PathElement.groupElement("idr_pic_id");
    public static final PathElement PATH$PicOrderCnt = PathElement.groupElement("PicOrderCnt");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$seq_parameter_set_id = (OfByte) LAYOUT.select(PATH$seq_parameter_set_id);
    public static final OfByte LAYOUT$pic_parameter_set_id = (OfByte) LAYOUT.select(PATH$pic_parameter_set_id);
    public static final OfShort LAYOUT$frame_num = (OfShort) LAYOUT.select(PATH$frame_num);
    public static final OfShort LAYOUT$idr_pic_id = (OfShort) LAYOUT.select(PATH$idr_pic_id);
    public static final SequenceLayout LAYOUT$PicOrderCnt = (SequenceLayout) LAYOUT.select(PATH$PicOrderCnt);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$seq_parameter_set_id = LAYOUT$seq_parameter_set_id.byteSize();
    public static final long SIZE$pic_parameter_set_id = LAYOUT$pic_parameter_set_id.byteSize();
    public static final long SIZE$frame_num = LAYOUT$frame_num.byteSize();
    public static final long SIZE$idr_pic_id = LAYOUT$idr_pic_id.byteSize();
    public static final long SIZE$PicOrderCnt = LAYOUT$PicOrderCnt.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$seq_parameter_set_id = LAYOUT.byteOffset(PATH$seq_parameter_set_id);
    public static final long OFFSET$pic_parameter_set_id = LAYOUT.byteOffset(PATH$pic_parameter_set_id);
    public static final long OFFSET$frame_num = LAYOUT.byteOffset(PATH$frame_num);
    public static final long OFFSET$idr_pic_id = LAYOUT.byteOffset(PATH$idr_pic_id);
    public static final long OFFSET$PicOrderCnt = LAYOUT.byteOffset(PATH$PicOrderCnt);
}
