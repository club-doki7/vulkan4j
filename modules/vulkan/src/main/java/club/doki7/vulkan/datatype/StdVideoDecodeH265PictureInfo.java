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

/// Represents a pointer to a {@code StdVideoDecodeH265PictureInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoDecodeH265PictureInfo {
///     StdVideoDecodeH265PictureInfoFlags flags; // @link substring="StdVideoDecodeH265PictureInfoFlags" target="StdVideoDecodeH265PictureInfoFlags" @link substring="flags" target="#flags"
///     uint8_t sps_video_parameter_set_id; // @link substring="sps_video_parameter_set_id" target="#sps_video_parameter_set_id"
///     uint8_t pps_seq_parameter_set_id; // @link substring="pps_seq_parameter_set_id" target="#pps_seq_parameter_set_id"
///     uint8_t pps_pic_parameter_set_id; // @link substring="pps_pic_parameter_set_id" target="#pps_pic_parameter_set_id"
///     uint8_t NumDeltaPocsOfRefRpsIdx; // @link substring="NumDeltaPocsOfRefRpsIdx" target="#NumDeltaPocsOfRefRpsIdx"
///     int32_t PicOrderCntVal; // @link substring="PicOrderCntVal" target="#PicOrderCntVal"
///     uint16_t NumBitsForSTRefPicSetInSlice; // @link substring="NumBitsForSTRefPicSetInSlice" target="#NumBitsForSTRefPicSetInSlice"
///     uint16_t reserved;
///     uint8_t[STD_VIDEO_DECODE_H265_REF_PIC_SET_LIST_SIZE] RefPicSetStCurrBefore; // @link substring="RefPicSetStCurrBefore" target="#RefPicSetStCurrBefore"
///     uint8_t[STD_VIDEO_DECODE_H265_REF_PIC_SET_LIST_SIZE] RefPicSetStCurrAfter; // @link substring="RefPicSetStCurrAfter" target="#RefPicSetStCurrAfter"
///     uint8_t[STD_VIDEO_DECODE_H265_REF_PIC_SET_LIST_SIZE] RefPicSetLtCurr; // @link substring="RefPicSetLtCurr" target="#RefPicSetLtCurr"
/// } StdVideoDecodeH265PictureInfo;
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
public record StdVideoDecodeH265PictureInfo(@NotNull MemorySegment segment) implements IStdVideoDecodeH265PictureInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoDecodeH265PictureInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoDecodeH265PictureInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoDecodeH265PictureInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoDecodeH265PictureInfo, Iterable<StdVideoDecodeH265PictureInfo> {
        public long size() {
            return segment.byteSize() / StdVideoDecodeH265PictureInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoDecodeH265PictureInfo at(long index) {
            return new StdVideoDecodeH265PictureInfo(segment.asSlice(index * StdVideoDecodeH265PictureInfo.BYTES, StdVideoDecodeH265PictureInfo.BYTES));
        }

        public StdVideoDecodeH265PictureInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoDecodeH265PictureInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoDecodeH265PictureInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoDecodeH265PictureInfo.BYTES, StdVideoDecodeH265PictureInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoDecodeH265PictureInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoDecodeH265PictureInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoDecodeH265PictureInfo.BYTES,
                (end - start) * StdVideoDecodeH265PictureInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoDecodeH265PictureInfo.BYTES));
        }

        public StdVideoDecodeH265PictureInfo[] toArray() {
            StdVideoDecodeH265PictureInfo[] ret = new StdVideoDecodeH265PictureInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoDecodeH265PictureInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoDecodeH265PictureInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoDecodeH265PictureInfo.BYTES;
            }

            @Override
            public StdVideoDecodeH265PictureInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoDecodeH265PictureInfo ret = new StdVideoDecodeH265PictureInfo(segment.asSlice(0, StdVideoDecodeH265PictureInfo.BYTES));
                segment = segment.asSlice(StdVideoDecodeH265PictureInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoDecodeH265PictureInfo allocate(Arena arena) {
        return new StdVideoDecodeH265PictureInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoDecodeH265PictureInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoDecodeH265PictureInfo.Ptr(segment);
    }

    public static StdVideoDecodeH265PictureInfo clone(Arena arena, StdVideoDecodeH265PictureInfo src) {
        StdVideoDecodeH265PictureInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoDecodeH265PictureInfoFlags flags() {
        return new StdVideoDecodeH265PictureInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoDecodeH265PictureInfo flags(@NotNull StdVideoDecodeH265PictureInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoDecodeH265PictureInfo flags(Consumer<@NotNull StdVideoDecodeH265PictureInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte sps_video_parameter_set_id() {
        return segment.get(LAYOUT$sps_video_parameter_set_id, OFFSET$sps_video_parameter_set_id);
    }

    public StdVideoDecodeH265PictureInfo sps_video_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$sps_video_parameter_set_id, OFFSET$sps_video_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte pps_seq_parameter_set_id() {
        return segment.get(LAYOUT$pps_seq_parameter_set_id, OFFSET$pps_seq_parameter_set_id);
    }

    public StdVideoDecodeH265PictureInfo pps_seq_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$pps_seq_parameter_set_id, OFFSET$pps_seq_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte pps_pic_parameter_set_id() {
        return segment.get(LAYOUT$pps_pic_parameter_set_id, OFFSET$pps_pic_parameter_set_id);
    }

    public StdVideoDecodeH265PictureInfo pps_pic_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$pps_pic_parameter_set_id, OFFSET$pps_pic_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte NumDeltaPocsOfRefRpsIdx() {
        return segment.get(LAYOUT$NumDeltaPocsOfRefRpsIdx, OFFSET$NumDeltaPocsOfRefRpsIdx);
    }

    public StdVideoDecodeH265PictureInfo NumDeltaPocsOfRefRpsIdx(@Unsigned byte value) {
        segment.set(LAYOUT$NumDeltaPocsOfRefRpsIdx, OFFSET$NumDeltaPocsOfRefRpsIdx, value);
        return this;
    }

    public int PicOrderCntVal() {
        return segment.get(LAYOUT$PicOrderCntVal, OFFSET$PicOrderCntVal);
    }

    public StdVideoDecodeH265PictureInfo PicOrderCntVal(int value) {
        segment.set(LAYOUT$PicOrderCntVal, OFFSET$PicOrderCntVal, value);
        return this;
    }

    public @Unsigned short NumBitsForSTRefPicSetInSlice() {
        return segment.get(LAYOUT$NumBitsForSTRefPicSetInSlice, OFFSET$NumBitsForSTRefPicSetInSlice);
    }

    public StdVideoDecodeH265PictureInfo NumBitsForSTRefPicSetInSlice(@Unsigned short value) {
        segment.set(LAYOUT$NumBitsForSTRefPicSetInSlice, OFFSET$NumBitsForSTRefPicSetInSlice, value);
        return this;
    }


    public @Unsigned BytePtr RefPicSetStCurrBefore() {
        return new BytePtr(RefPicSetStCurrBeforeRaw());
    }

    public StdVideoDecodeH265PictureInfo RefPicSetStCurrBefore(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = RefPicSetStCurrBefore();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoDecodeH265PictureInfo RefPicSetStCurrBefore(@Unsigned BytePtr value) {
        MemorySegment s = RefPicSetStCurrBeforeRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment RefPicSetStCurrBeforeRaw() {
        return segment.asSlice(OFFSET$RefPicSetStCurrBefore, SIZE$RefPicSetStCurrBefore);
    }

    public @Unsigned BytePtr RefPicSetStCurrAfter() {
        return new BytePtr(RefPicSetStCurrAfterRaw());
    }

    public StdVideoDecodeH265PictureInfo RefPicSetStCurrAfter(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = RefPicSetStCurrAfter();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoDecodeH265PictureInfo RefPicSetStCurrAfter(@Unsigned BytePtr value) {
        MemorySegment s = RefPicSetStCurrAfterRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment RefPicSetStCurrAfterRaw() {
        return segment.asSlice(OFFSET$RefPicSetStCurrAfter, SIZE$RefPicSetStCurrAfter);
    }

    public @Unsigned BytePtr RefPicSetLtCurr() {
        return new BytePtr(RefPicSetLtCurrRaw());
    }

    public StdVideoDecodeH265PictureInfo RefPicSetLtCurr(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = RefPicSetLtCurr();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoDecodeH265PictureInfo RefPicSetLtCurr(@Unsigned BytePtr value) {
        MemorySegment s = RefPicSetLtCurrRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment RefPicSetLtCurrRaw() {
        return segment.asSlice(OFFSET$RefPicSetLtCurr, SIZE$RefPicSetLtCurr);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoDecodeH265PictureInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("sps_video_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("pps_seq_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("pps_pic_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("NumDeltaPocsOfRefRpsIdx"),
        ValueLayout.JAVA_INT.withName("PicOrderCntVal"),
        ValueLayout.JAVA_SHORT.withName("NumBitsForSTRefPicSetInSlice"),
        ValueLayout.JAVA_SHORT.withName("reserved"),
        MemoryLayout.sequenceLayout(DECODE_H265_REF_PIC_SET_LIST_SIZE, ValueLayout.JAVA_BYTE).withName("RefPicSetStCurrBefore"),
        MemoryLayout.sequenceLayout(DECODE_H265_REF_PIC_SET_LIST_SIZE, ValueLayout.JAVA_BYTE).withName("RefPicSetStCurrAfter"),
        MemoryLayout.sequenceLayout(DECODE_H265_REF_PIC_SET_LIST_SIZE, ValueLayout.JAVA_BYTE).withName("RefPicSetLtCurr")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$sps_video_parameter_set_id = PathElement.groupElement("sps_video_parameter_set_id");
    public static final PathElement PATH$pps_seq_parameter_set_id = PathElement.groupElement("pps_seq_parameter_set_id");
    public static final PathElement PATH$pps_pic_parameter_set_id = PathElement.groupElement("pps_pic_parameter_set_id");
    public static final PathElement PATH$NumDeltaPocsOfRefRpsIdx = PathElement.groupElement("NumDeltaPocsOfRefRpsIdx");
    public static final PathElement PATH$PicOrderCntVal = PathElement.groupElement("PicOrderCntVal");
    public static final PathElement PATH$NumBitsForSTRefPicSetInSlice = PathElement.groupElement("NumBitsForSTRefPicSetInSlice");
    public static final PathElement PATH$RefPicSetStCurrBefore = PathElement.groupElement("RefPicSetStCurrBefore");
    public static final PathElement PATH$RefPicSetStCurrAfter = PathElement.groupElement("RefPicSetStCurrAfter");
    public static final PathElement PATH$RefPicSetLtCurr = PathElement.groupElement("RefPicSetLtCurr");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$sps_video_parameter_set_id = (OfByte) LAYOUT.select(PATH$sps_video_parameter_set_id);
    public static final OfByte LAYOUT$pps_seq_parameter_set_id = (OfByte) LAYOUT.select(PATH$pps_seq_parameter_set_id);
    public static final OfByte LAYOUT$pps_pic_parameter_set_id = (OfByte) LAYOUT.select(PATH$pps_pic_parameter_set_id);
    public static final OfByte LAYOUT$NumDeltaPocsOfRefRpsIdx = (OfByte) LAYOUT.select(PATH$NumDeltaPocsOfRefRpsIdx);
    public static final OfInt LAYOUT$PicOrderCntVal = (OfInt) LAYOUT.select(PATH$PicOrderCntVal);
    public static final OfShort LAYOUT$NumBitsForSTRefPicSetInSlice = (OfShort) LAYOUT.select(PATH$NumBitsForSTRefPicSetInSlice);
    public static final SequenceLayout LAYOUT$RefPicSetStCurrBefore = (SequenceLayout) LAYOUT.select(PATH$RefPicSetStCurrBefore);
    public static final SequenceLayout LAYOUT$RefPicSetStCurrAfter = (SequenceLayout) LAYOUT.select(PATH$RefPicSetStCurrAfter);
    public static final SequenceLayout LAYOUT$RefPicSetLtCurr = (SequenceLayout) LAYOUT.select(PATH$RefPicSetLtCurr);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$sps_video_parameter_set_id = LAYOUT$sps_video_parameter_set_id.byteSize();
    public static final long SIZE$pps_seq_parameter_set_id = LAYOUT$pps_seq_parameter_set_id.byteSize();
    public static final long SIZE$pps_pic_parameter_set_id = LAYOUT$pps_pic_parameter_set_id.byteSize();
    public static final long SIZE$NumDeltaPocsOfRefRpsIdx = LAYOUT$NumDeltaPocsOfRefRpsIdx.byteSize();
    public static final long SIZE$PicOrderCntVal = LAYOUT$PicOrderCntVal.byteSize();
    public static final long SIZE$NumBitsForSTRefPicSetInSlice = LAYOUT$NumBitsForSTRefPicSetInSlice.byteSize();
    public static final long SIZE$RefPicSetStCurrBefore = LAYOUT$RefPicSetStCurrBefore.byteSize();
    public static final long SIZE$RefPicSetStCurrAfter = LAYOUT$RefPicSetStCurrAfter.byteSize();
    public static final long SIZE$RefPicSetLtCurr = LAYOUT$RefPicSetLtCurr.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$sps_video_parameter_set_id = LAYOUT.byteOffset(PATH$sps_video_parameter_set_id);
    public static final long OFFSET$pps_seq_parameter_set_id = LAYOUT.byteOffset(PATH$pps_seq_parameter_set_id);
    public static final long OFFSET$pps_pic_parameter_set_id = LAYOUT.byteOffset(PATH$pps_pic_parameter_set_id);
    public static final long OFFSET$NumDeltaPocsOfRefRpsIdx = LAYOUT.byteOffset(PATH$NumDeltaPocsOfRefRpsIdx);
    public static final long OFFSET$PicOrderCntVal = LAYOUT.byteOffset(PATH$PicOrderCntVal);
    public static final long OFFSET$NumBitsForSTRefPicSetInSlice = LAYOUT.byteOffset(PATH$NumBitsForSTRefPicSetInSlice);
    public static final long OFFSET$RefPicSetStCurrBefore = LAYOUT.byteOffset(PATH$RefPicSetStCurrBefore);
    public static final long OFFSET$RefPicSetStCurrAfter = LAYOUT.byteOffset(PATH$RefPicSetStCurrAfter);
    public static final long OFFSET$RefPicSetLtCurr = LAYOUT.byteOffset(PATH$RefPicSetLtCurr);
}
