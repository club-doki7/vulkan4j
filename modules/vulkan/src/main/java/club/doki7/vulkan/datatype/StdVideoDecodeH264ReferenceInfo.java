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

/// Represents a pointer to a {@code StdVideoDecodeH264ReferenceInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoDecodeH264ReferenceInfo {
///     StdVideoDecodeH264ReferenceInfoFlags flags; // @link substring="StdVideoDecodeH264ReferenceInfoFlags" target="StdVideoDecodeH264ReferenceInfoFlags" @link substring="flags" target="#flags"
///     uint16_t FrameNum; // @link substring="FrameNum" target="#FrameNum"
///     uint16_t reserved;
///     int32_t[STD_VIDEO_DECODE_H264_FIELD_ORDER_COUNT_LIST_SIZE] PicOrderCnt; // @link substring="PicOrderCnt" target="#PicOrderCnt"
/// } StdVideoDecodeH264ReferenceInfo;
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
public record StdVideoDecodeH264ReferenceInfo(@NotNull MemorySegment segment) implements IStdVideoDecodeH264ReferenceInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoDecodeH264ReferenceInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoDecodeH264ReferenceInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoDecodeH264ReferenceInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoDecodeH264ReferenceInfo, Iterable<StdVideoDecodeH264ReferenceInfo> {
        public long size() {
            return segment.byteSize() / StdVideoDecodeH264ReferenceInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoDecodeH264ReferenceInfo at(long index) {
            return new StdVideoDecodeH264ReferenceInfo(segment.asSlice(index * StdVideoDecodeH264ReferenceInfo.BYTES, StdVideoDecodeH264ReferenceInfo.BYTES));
        }

        public StdVideoDecodeH264ReferenceInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoDecodeH264ReferenceInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoDecodeH264ReferenceInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoDecodeH264ReferenceInfo.BYTES, StdVideoDecodeH264ReferenceInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoDecodeH264ReferenceInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoDecodeH264ReferenceInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoDecodeH264ReferenceInfo.BYTES,
                (end - start) * StdVideoDecodeH264ReferenceInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoDecodeH264ReferenceInfo.BYTES));
        }

        public StdVideoDecodeH264ReferenceInfo[] toArray() {
            StdVideoDecodeH264ReferenceInfo[] ret = new StdVideoDecodeH264ReferenceInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoDecodeH264ReferenceInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoDecodeH264ReferenceInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoDecodeH264ReferenceInfo.BYTES;
            }

            @Override
            public StdVideoDecodeH264ReferenceInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoDecodeH264ReferenceInfo ret = new StdVideoDecodeH264ReferenceInfo(segment.asSlice(0, StdVideoDecodeH264ReferenceInfo.BYTES));
                segment = segment.asSlice(StdVideoDecodeH264ReferenceInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoDecodeH264ReferenceInfo allocate(Arena arena) {
        return new StdVideoDecodeH264ReferenceInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoDecodeH264ReferenceInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoDecodeH264ReferenceInfo.Ptr(segment);
    }

    public static StdVideoDecodeH264ReferenceInfo clone(Arena arena, StdVideoDecodeH264ReferenceInfo src) {
        StdVideoDecodeH264ReferenceInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoDecodeH264ReferenceInfoFlags flags() {
        return new StdVideoDecodeH264ReferenceInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoDecodeH264ReferenceInfo flags(@NotNull StdVideoDecodeH264ReferenceInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoDecodeH264ReferenceInfo flags(Consumer<@NotNull StdVideoDecodeH264ReferenceInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned short FrameNum() {
        return segment.get(LAYOUT$FrameNum, OFFSET$FrameNum);
    }

    public StdVideoDecodeH264ReferenceInfo FrameNum(@Unsigned short value) {
        segment.set(LAYOUT$FrameNum, OFFSET$FrameNum, value);
        return this;
    }


    public IntPtr PicOrderCnt() {
        return new IntPtr(PicOrderCntRaw());
    }

    public StdVideoDecodeH264ReferenceInfo PicOrderCnt(@NotNull Consumer<IntPtr> consumer) {
        IntPtr ptr = PicOrderCnt();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoDecodeH264ReferenceInfo PicOrderCnt(IntPtr value) {
        MemorySegment s = PicOrderCntRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment PicOrderCntRaw() {
        return segment.asSlice(OFFSET$PicOrderCnt, SIZE$PicOrderCnt);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoDecodeH264ReferenceInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_SHORT.withName("FrameNum"),
        ValueLayout.JAVA_SHORT.withName("reserved"),
        MemoryLayout.sequenceLayout(DECODE_H264_FIELD_ORDER_COUNT_LIST_SIZE, ValueLayout.JAVA_INT).withName("PicOrderCnt")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$FrameNum = PathElement.groupElement("FrameNum");
    public static final PathElement PATH$PicOrderCnt = PathElement.groupElement("PicOrderCnt");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfShort LAYOUT$FrameNum = (OfShort) LAYOUT.select(PATH$FrameNum);
    public static final SequenceLayout LAYOUT$PicOrderCnt = (SequenceLayout) LAYOUT.select(PATH$PicOrderCnt);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$FrameNum = LAYOUT$FrameNum.byteSize();
    public static final long SIZE$PicOrderCnt = LAYOUT$PicOrderCnt.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$FrameNum = LAYOUT.byteOffset(PATH$FrameNum);
    public static final long OFFSET$PicOrderCnt = LAYOUT.byteOffset(PATH$PicOrderCnt);
}
