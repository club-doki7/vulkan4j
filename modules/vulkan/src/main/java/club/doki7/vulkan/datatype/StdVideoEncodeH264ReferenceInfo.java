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

/// Represents a pointer to a {@code StdVideoEncodeH264ReferenceInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH264ReferenceInfo {
///     StdVideoEncodeH264ReferenceInfoFlags flags; // @link substring="StdVideoEncodeH264ReferenceInfoFlags" target="StdVideoEncodeH264ReferenceInfoFlags" @link substring="flags" target="#flags"
///     StdVideoH264PictureType primary_pic_type; // @link substring="StdVideoH264PictureType" target="StdVideoH264PictureType" @link substring="primary_pic_type" target="#primary_pic_type"
///     uint32_t FrameNum; // @link substring="FrameNum" target="#FrameNum"
///     int32_t PicOrderCnt; // @link substring="PicOrderCnt" target="#PicOrderCnt"
///     uint16_t long_term_pic_num; // @link substring="long_term_pic_num" target="#long_term_pic_num"
///     uint16_t long_term_frame_idx; // @link substring="long_term_frame_idx" target="#long_term_frame_idx"
///     uint8_t temporal_id; // @link substring="temporal_id" target="#temporal_id"
/// } StdVideoEncodeH264ReferenceInfo;
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
public record StdVideoEncodeH264ReferenceInfo(@NotNull MemorySegment segment) implements IStdVideoEncodeH264ReferenceInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH264ReferenceInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH264ReferenceInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH264ReferenceInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH264ReferenceInfo, Iterable<StdVideoEncodeH264ReferenceInfo> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH264ReferenceInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH264ReferenceInfo at(long index) {
            return new StdVideoEncodeH264ReferenceInfo(segment.asSlice(index * StdVideoEncodeH264ReferenceInfo.BYTES, StdVideoEncodeH264ReferenceInfo.BYTES));
        }

        public StdVideoEncodeH264ReferenceInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH264ReferenceInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH264ReferenceInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH264ReferenceInfo.BYTES, StdVideoEncodeH264ReferenceInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH264ReferenceInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH264ReferenceInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH264ReferenceInfo.BYTES,
                (end - start) * StdVideoEncodeH264ReferenceInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH264ReferenceInfo.BYTES));
        }

        public StdVideoEncodeH264ReferenceInfo[] toArray() {
            StdVideoEncodeH264ReferenceInfo[] ret = new StdVideoEncodeH264ReferenceInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH264ReferenceInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH264ReferenceInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH264ReferenceInfo.BYTES;
            }

            @Override
            public StdVideoEncodeH264ReferenceInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH264ReferenceInfo ret = new StdVideoEncodeH264ReferenceInfo(segment.asSlice(0, StdVideoEncodeH264ReferenceInfo.BYTES));
                segment = segment.asSlice(StdVideoEncodeH264ReferenceInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH264ReferenceInfo allocate(Arena arena) {
        return new StdVideoEncodeH264ReferenceInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH264ReferenceInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH264ReferenceInfo.Ptr(segment);
    }

    public static StdVideoEncodeH264ReferenceInfo clone(Arena arena, StdVideoEncodeH264ReferenceInfo src) {
        StdVideoEncodeH264ReferenceInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoEncodeH264ReferenceInfoFlags flags() {
        return new StdVideoEncodeH264ReferenceInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoEncodeH264ReferenceInfo flags(@NotNull StdVideoEncodeH264ReferenceInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoEncodeH264ReferenceInfo flags(Consumer<@NotNull StdVideoEncodeH264ReferenceInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoH264PictureType.class) int primary_pic_type() {
        return segment.get(LAYOUT$primary_pic_type, OFFSET$primary_pic_type);
    }

    public StdVideoEncodeH264ReferenceInfo primary_pic_type(@EnumType(StdVideoH264PictureType.class) int value) {
        segment.set(LAYOUT$primary_pic_type, OFFSET$primary_pic_type, value);
        return this;
    }

    public @Unsigned int FrameNum() {
        return segment.get(LAYOUT$FrameNum, OFFSET$FrameNum);
    }

    public StdVideoEncodeH264ReferenceInfo FrameNum(@Unsigned int value) {
        segment.set(LAYOUT$FrameNum, OFFSET$FrameNum, value);
        return this;
    }

    public int PicOrderCnt() {
        return segment.get(LAYOUT$PicOrderCnt, OFFSET$PicOrderCnt);
    }

    public StdVideoEncodeH264ReferenceInfo PicOrderCnt(int value) {
        segment.set(LAYOUT$PicOrderCnt, OFFSET$PicOrderCnt, value);
        return this;
    }

    public @Unsigned short long_term_pic_num() {
        return segment.get(LAYOUT$long_term_pic_num, OFFSET$long_term_pic_num);
    }

    public StdVideoEncodeH264ReferenceInfo long_term_pic_num(@Unsigned short value) {
        segment.set(LAYOUT$long_term_pic_num, OFFSET$long_term_pic_num, value);
        return this;
    }

    public @Unsigned short long_term_frame_idx() {
        return segment.get(LAYOUT$long_term_frame_idx, OFFSET$long_term_frame_idx);
    }

    public StdVideoEncodeH264ReferenceInfo long_term_frame_idx(@Unsigned short value) {
        segment.set(LAYOUT$long_term_frame_idx, OFFSET$long_term_frame_idx, value);
        return this;
    }

    public @Unsigned byte temporal_id() {
        return segment.get(LAYOUT$temporal_id, OFFSET$temporal_id);
    }

    public StdVideoEncodeH264ReferenceInfo temporal_id(@Unsigned byte value) {
        segment.set(LAYOUT$temporal_id, OFFSET$temporal_id, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoEncodeH264ReferenceInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("primary_pic_type"),
        ValueLayout.JAVA_INT.withName("FrameNum"),
        ValueLayout.JAVA_INT.withName("PicOrderCnt"),
        ValueLayout.JAVA_SHORT.withName("long_term_pic_num"),
        ValueLayout.JAVA_SHORT.withName("long_term_frame_idx"),
        ValueLayout.JAVA_BYTE.withName("temporal_id")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$primary_pic_type = PathElement.groupElement("primary_pic_type");
    public static final PathElement PATH$FrameNum = PathElement.groupElement("FrameNum");
    public static final PathElement PATH$PicOrderCnt = PathElement.groupElement("PicOrderCnt");
    public static final PathElement PATH$long_term_pic_num = PathElement.groupElement("long_term_pic_num");
    public static final PathElement PATH$long_term_frame_idx = PathElement.groupElement("long_term_frame_idx");
    public static final PathElement PATH$temporal_id = PathElement.groupElement("temporal_id");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$primary_pic_type = (OfInt) LAYOUT.select(PATH$primary_pic_type);
    public static final OfInt LAYOUT$FrameNum = (OfInt) LAYOUT.select(PATH$FrameNum);
    public static final OfInt LAYOUT$PicOrderCnt = (OfInt) LAYOUT.select(PATH$PicOrderCnt);
    public static final OfShort LAYOUT$long_term_pic_num = (OfShort) LAYOUT.select(PATH$long_term_pic_num);
    public static final OfShort LAYOUT$long_term_frame_idx = (OfShort) LAYOUT.select(PATH$long_term_frame_idx);
    public static final OfByte LAYOUT$temporal_id = (OfByte) LAYOUT.select(PATH$temporal_id);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$primary_pic_type = LAYOUT$primary_pic_type.byteSize();
    public static final long SIZE$FrameNum = LAYOUT$FrameNum.byteSize();
    public static final long SIZE$PicOrderCnt = LAYOUT$PicOrderCnt.byteSize();
    public static final long SIZE$long_term_pic_num = LAYOUT$long_term_pic_num.byteSize();
    public static final long SIZE$long_term_frame_idx = LAYOUT$long_term_frame_idx.byteSize();
    public static final long SIZE$temporal_id = LAYOUT$temporal_id.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$primary_pic_type = LAYOUT.byteOffset(PATH$primary_pic_type);
    public static final long OFFSET$FrameNum = LAYOUT.byteOffset(PATH$FrameNum);
    public static final long OFFSET$PicOrderCnt = LAYOUT.byteOffset(PATH$PicOrderCnt);
    public static final long OFFSET$long_term_pic_num = LAYOUT.byteOffset(PATH$long_term_pic_num);
    public static final long OFFSET$long_term_frame_idx = LAYOUT.byteOffset(PATH$long_term_frame_idx);
    public static final long OFFSET$temporal_id = LAYOUT.byteOffset(PATH$temporal_id);
}
