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

/// Represents a pointer to a {@code StdVideoEncodeH264PictureInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH264PictureInfo {
///     StdVideoEncodeH264PictureInfoFlags flags; // @link substring="StdVideoEncodeH264PictureInfoFlags" target="StdVideoEncodeH264PictureInfoFlags" @link substring="flags" target="#flags"
///     uint8_t seq_parameter_set_id; // @link substring="seq_parameter_set_id" target="#seq_parameter_set_id"
///     uint8_t pic_parameter_set_id; // @link substring="pic_parameter_set_id" target="#pic_parameter_set_id"
///     uint16_t idr_pic_id; // @link substring="idr_pic_id" target="#idr_pic_id"
///     StdVideoH264PictureType primary_pic_type; // @link substring="StdVideoH264PictureType" target="StdVideoH264PictureType" @link substring="primary_pic_type" target="#primary_pic_type"
///     uint32_t frame_num; // @link substring="frame_num" target="#frame_num"
///     int32_t PicOrderCnt; // @link substring="PicOrderCnt" target="#PicOrderCnt"
///     uint8_t temporal_id; // @link substring="temporal_id" target="#temporal_id"
///     uint8_t[3] reserved1;
///     StdVideoEncodeH264ReferenceListsInfo const* pRefLists; // optional // @link substring="StdVideoEncodeH264ReferenceListsInfo" target="StdVideoEncodeH264ReferenceListsInfo" @link substring="pRefLists" target="#pRefLists"
/// } StdVideoEncodeH264PictureInfo;
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
public record StdVideoEncodeH264PictureInfo(@NotNull MemorySegment segment) implements IStdVideoEncodeH264PictureInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH264PictureInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH264PictureInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH264PictureInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH264PictureInfo, Iterable<StdVideoEncodeH264PictureInfo> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH264PictureInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH264PictureInfo at(long index) {
            return new StdVideoEncodeH264PictureInfo(segment.asSlice(index * StdVideoEncodeH264PictureInfo.BYTES, StdVideoEncodeH264PictureInfo.BYTES));
        }

        public StdVideoEncodeH264PictureInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH264PictureInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH264PictureInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH264PictureInfo.BYTES, StdVideoEncodeH264PictureInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH264PictureInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH264PictureInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH264PictureInfo.BYTES,
                (end - start) * StdVideoEncodeH264PictureInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH264PictureInfo.BYTES));
        }

        public StdVideoEncodeH264PictureInfo[] toArray() {
            StdVideoEncodeH264PictureInfo[] ret = new StdVideoEncodeH264PictureInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH264PictureInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH264PictureInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH264PictureInfo.BYTES;
            }

            @Override
            public StdVideoEncodeH264PictureInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH264PictureInfo ret = new StdVideoEncodeH264PictureInfo(segment.asSlice(0, StdVideoEncodeH264PictureInfo.BYTES));
                segment = segment.asSlice(StdVideoEncodeH264PictureInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH264PictureInfo allocate(Arena arena) {
        return new StdVideoEncodeH264PictureInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH264PictureInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH264PictureInfo.Ptr(segment);
    }

    public static StdVideoEncodeH264PictureInfo clone(Arena arena, StdVideoEncodeH264PictureInfo src) {
        StdVideoEncodeH264PictureInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoEncodeH264PictureInfoFlags flags() {
        return new StdVideoEncodeH264PictureInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoEncodeH264PictureInfo flags(@NotNull StdVideoEncodeH264PictureInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoEncodeH264PictureInfo flags(Consumer<@NotNull StdVideoEncodeH264PictureInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @Unsigned byte seq_parameter_set_id() {
        return segment.get(LAYOUT$seq_parameter_set_id, OFFSET$seq_parameter_set_id);
    }

    public StdVideoEncodeH264PictureInfo seq_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$seq_parameter_set_id, OFFSET$seq_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte pic_parameter_set_id() {
        return segment.get(LAYOUT$pic_parameter_set_id, OFFSET$pic_parameter_set_id);
    }

    public StdVideoEncodeH264PictureInfo pic_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$pic_parameter_set_id, OFFSET$pic_parameter_set_id, value);
        return this;
    }

    public @Unsigned short idr_pic_id() {
        return segment.get(LAYOUT$idr_pic_id, OFFSET$idr_pic_id);
    }

    public StdVideoEncodeH264PictureInfo idr_pic_id(@Unsigned short value) {
        segment.set(LAYOUT$idr_pic_id, OFFSET$idr_pic_id, value);
        return this;
    }

    public @EnumType(StdVideoH264PictureType.class) int primary_pic_type() {
        return segment.get(LAYOUT$primary_pic_type, OFFSET$primary_pic_type);
    }

    public StdVideoEncodeH264PictureInfo primary_pic_type(@EnumType(StdVideoH264PictureType.class) int value) {
        segment.set(LAYOUT$primary_pic_type, OFFSET$primary_pic_type, value);
        return this;
    }

    public @Unsigned int frame_num() {
        return segment.get(LAYOUT$frame_num, OFFSET$frame_num);
    }

    public StdVideoEncodeH264PictureInfo frame_num(@Unsigned int value) {
        segment.set(LAYOUT$frame_num, OFFSET$frame_num, value);
        return this;
    }

    public int PicOrderCnt() {
        return segment.get(LAYOUT$PicOrderCnt, OFFSET$PicOrderCnt);
    }

    public StdVideoEncodeH264PictureInfo PicOrderCnt(int value) {
        segment.set(LAYOUT$PicOrderCnt, OFFSET$PicOrderCnt, value);
        return this;
    }

    public @Unsigned byte temporal_id() {
        return segment.get(LAYOUT$temporal_id, OFFSET$temporal_id);
    }

    public StdVideoEncodeH264PictureInfo temporal_id(@Unsigned byte value) {
        segment.set(LAYOUT$temporal_id, OFFSET$temporal_id, value);
        return this;
    }


    public StdVideoEncodeH264PictureInfo pRefLists(@Nullable IStdVideoEncodeH264ReferenceListsInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRefListsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoEncodeH264ReferenceListsInfo.Ptr pRefLists(int assumedCount) {
        MemorySegment s = pRefListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoEncodeH264ReferenceListsInfo.BYTES);
        return new StdVideoEncodeH264ReferenceListsInfo.Ptr(s);
    }

    public @Nullable StdVideoEncodeH264ReferenceListsInfo pRefLists() {
        MemorySegment s = pRefListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoEncodeH264ReferenceListsInfo(s);
    }

    public @Pointer(target=StdVideoEncodeH264ReferenceListsInfo.class) @NotNull MemorySegment pRefListsRaw() {
        return segment.get(LAYOUT$pRefLists, OFFSET$pRefLists);
    }

    public void pRefListsRaw(@Pointer(target=StdVideoEncodeH264ReferenceListsInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRefLists, OFFSET$pRefLists, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoEncodeH264PictureInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_BYTE.withName("seq_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("pic_parameter_set_id"),
        ValueLayout.JAVA_SHORT.withName("idr_pic_id"),
        ValueLayout.JAVA_INT.withName("primary_pic_type"),
        ValueLayout.JAVA_INT.withName("frame_num"),
        ValueLayout.JAVA_INT.withName("PicOrderCnt"),
        ValueLayout.JAVA_BYTE.withName("temporal_id"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_BYTE).withName("reserved1"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoEncodeH264ReferenceListsInfo.LAYOUT).withName("pRefLists")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$seq_parameter_set_id = PathElement.groupElement("seq_parameter_set_id");
    public static final PathElement PATH$pic_parameter_set_id = PathElement.groupElement("pic_parameter_set_id");
    public static final PathElement PATH$idr_pic_id = PathElement.groupElement("idr_pic_id");
    public static final PathElement PATH$primary_pic_type = PathElement.groupElement("primary_pic_type");
    public static final PathElement PATH$frame_num = PathElement.groupElement("frame_num");
    public static final PathElement PATH$PicOrderCnt = PathElement.groupElement("PicOrderCnt");
    public static final PathElement PATH$temporal_id = PathElement.groupElement("temporal_id");
    public static final PathElement PATH$pRefLists = PathElement.groupElement("pRefLists");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfByte LAYOUT$seq_parameter_set_id = (OfByte) LAYOUT.select(PATH$seq_parameter_set_id);
    public static final OfByte LAYOUT$pic_parameter_set_id = (OfByte) LAYOUT.select(PATH$pic_parameter_set_id);
    public static final OfShort LAYOUT$idr_pic_id = (OfShort) LAYOUT.select(PATH$idr_pic_id);
    public static final OfInt LAYOUT$primary_pic_type = (OfInt) LAYOUT.select(PATH$primary_pic_type);
    public static final OfInt LAYOUT$frame_num = (OfInt) LAYOUT.select(PATH$frame_num);
    public static final OfInt LAYOUT$PicOrderCnt = (OfInt) LAYOUT.select(PATH$PicOrderCnt);
    public static final OfByte LAYOUT$temporal_id = (OfByte) LAYOUT.select(PATH$temporal_id);
    public static final AddressLayout LAYOUT$pRefLists = (AddressLayout) LAYOUT.select(PATH$pRefLists);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$seq_parameter_set_id = LAYOUT$seq_parameter_set_id.byteSize();
    public static final long SIZE$pic_parameter_set_id = LAYOUT$pic_parameter_set_id.byteSize();
    public static final long SIZE$idr_pic_id = LAYOUT$idr_pic_id.byteSize();
    public static final long SIZE$primary_pic_type = LAYOUT$primary_pic_type.byteSize();
    public static final long SIZE$frame_num = LAYOUT$frame_num.byteSize();
    public static final long SIZE$PicOrderCnt = LAYOUT$PicOrderCnt.byteSize();
    public static final long SIZE$temporal_id = LAYOUT$temporal_id.byteSize();
    public static final long SIZE$pRefLists = LAYOUT$pRefLists.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$seq_parameter_set_id = LAYOUT.byteOffset(PATH$seq_parameter_set_id);
    public static final long OFFSET$pic_parameter_set_id = LAYOUT.byteOffset(PATH$pic_parameter_set_id);
    public static final long OFFSET$idr_pic_id = LAYOUT.byteOffset(PATH$idr_pic_id);
    public static final long OFFSET$primary_pic_type = LAYOUT.byteOffset(PATH$primary_pic_type);
    public static final long OFFSET$frame_num = LAYOUT.byteOffset(PATH$frame_num);
    public static final long OFFSET$PicOrderCnt = LAYOUT.byteOffset(PATH$PicOrderCnt);
    public static final long OFFSET$temporal_id = LAYOUT.byteOffset(PATH$temporal_id);
    public static final long OFFSET$pRefLists = LAYOUT.byteOffset(PATH$pRefLists);
}
