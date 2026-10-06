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

/// Represents a pointer to a {@code StdVideoEncodeH265PictureInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH265PictureInfo {
///     StdVideoEncodeH265PictureInfoFlags flags; // @link substring="StdVideoEncodeH265PictureInfoFlags" target="StdVideoEncodeH265PictureInfoFlags" @link substring="flags" target="#flags"
///     StdVideoH265PictureType pic_type; // @link substring="StdVideoH265PictureType" target="StdVideoH265PictureType" @link substring="pic_type" target="#pic_type"
///     uint8_t sps_video_parameter_set_id; // @link substring="sps_video_parameter_set_id" target="#sps_video_parameter_set_id"
///     uint8_t pps_seq_parameter_set_id; // @link substring="pps_seq_parameter_set_id" target="#pps_seq_parameter_set_id"
///     uint8_t pps_pic_parameter_set_id; // @link substring="pps_pic_parameter_set_id" target="#pps_pic_parameter_set_id"
///     uint8_t short_term_ref_pic_set_idx; // @link substring="short_term_ref_pic_set_idx" target="#short_term_ref_pic_set_idx"
///     int32_t PicOrderCntVal; // @link substring="PicOrderCntVal" target="#PicOrderCntVal"
///     uint8_t TemporalId; // @link substring="TemporalId" target="#TemporalId"
///     uint8_t[7] reserved1;
///     StdVideoEncodeH265ReferenceListsInfo const* pRefLists; // optional // @link substring="StdVideoEncodeH265ReferenceListsInfo" target="StdVideoEncodeH265ReferenceListsInfo" @link substring="pRefLists" target="#pRefLists"
///     StdVideoH265ShortTermRefPicSet const* pShortTermRefPicSet; // optional // @link substring="StdVideoH265ShortTermRefPicSet" target="StdVideoH265ShortTermRefPicSet" @link substring="pShortTermRefPicSet" target="#pShortTermRefPicSet"
///     StdVideoEncodeH265LongTermRefPics const* pLongTermRefPics; // optional // @link substring="StdVideoEncodeH265LongTermRefPics" target="StdVideoEncodeH265LongTermRefPics" @link substring="pLongTermRefPics" target="#pLongTermRefPics"
/// } StdVideoEncodeH265PictureInfo;
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
public record StdVideoEncodeH265PictureInfo(@NotNull MemorySegment segment) implements IStdVideoEncodeH265PictureInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH265PictureInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH265PictureInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH265PictureInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH265PictureInfo, Iterable<StdVideoEncodeH265PictureInfo> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH265PictureInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH265PictureInfo at(long index) {
            return new StdVideoEncodeH265PictureInfo(segment.asSlice(index * StdVideoEncodeH265PictureInfo.BYTES, StdVideoEncodeH265PictureInfo.BYTES));
        }

        public StdVideoEncodeH265PictureInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH265PictureInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH265PictureInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH265PictureInfo.BYTES, StdVideoEncodeH265PictureInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH265PictureInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH265PictureInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH265PictureInfo.BYTES,
                (end - start) * StdVideoEncodeH265PictureInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH265PictureInfo.BYTES));
        }

        public StdVideoEncodeH265PictureInfo[] toArray() {
            StdVideoEncodeH265PictureInfo[] ret = new StdVideoEncodeH265PictureInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH265PictureInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH265PictureInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH265PictureInfo.BYTES;
            }

            @Override
            public StdVideoEncodeH265PictureInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH265PictureInfo ret = new StdVideoEncodeH265PictureInfo(segment.asSlice(0, StdVideoEncodeH265PictureInfo.BYTES));
                segment = segment.asSlice(StdVideoEncodeH265PictureInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH265PictureInfo allocate(Arena arena) {
        return new StdVideoEncodeH265PictureInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH265PictureInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH265PictureInfo.Ptr(segment);
    }

    public static StdVideoEncodeH265PictureInfo clone(Arena arena, StdVideoEncodeH265PictureInfo src) {
        StdVideoEncodeH265PictureInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoEncodeH265PictureInfoFlags flags() {
        return new StdVideoEncodeH265PictureInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoEncodeH265PictureInfo flags(@NotNull StdVideoEncodeH265PictureInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoEncodeH265PictureInfo flags(Consumer<@NotNull StdVideoEncodeH265PictureInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoH265PictureType.class) int pic_type() {
        return segment.get(LAYOUT$pic_type, OFFSET$pic_type);
    }

    public StdVideoEncodeH265PictureInfo pic_type(@EnumType(StdVideoH265PictureType.class) int value) {
        segment.set(LAYOUT$pic_type, OFFSET$pic_type, value);
        return this;
    }

    public @Unsigned byte sps_video_parameter_set_id() {
        return segment.get(LAYOUT$sps_video_parameter_set_id, OFFSET$sps_video_parameter_set_id);
    }

    public StdVideoEncodeH265PictureInfo sps_video_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$sps_video_parameter_set_id, OFFSET$sps_video_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte pps_seq_parameter_set_id() {
        return segment.get(LAYOUT$pps_seq_parameter_set_id, OFFSET$pps_seq_parameter_set_id);
    }

    public StdVideoEncodeH265PictureInfo pps_seq_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$pps_seq_parameter_set_id, OFFSET$pps_seq_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte pps_pic_parameter_set_id() {
        return segment.get(LAYOUT$pps_pic_parameter_set_id, OFFSET$pps_pic_parameter_set_id);
    }

    public StdVideoEncodeH265PictureInfo pps_pic_parameter_set_id(@Unsigned byte value) {
        segment.set(LAYOUT$pps_pic_parameter_set_id, OFFSET$pps_pic_parameter_set_id, value);
        return this;
    }

    public @Unsigned byte short_term_ref_pic_set_idx() {
        return segment.get(LAYOUT$short_term_ref_pic_set_idx, OFFSET$short_term_ref_pic_set_idx);
    }

    public StdVideoEncodeH265PictureInfo short_term_ref_pic_set_idx(@Unsigned byte value) {
        segment.set(LAYOUT$short_term_ref_pic_set_idx, OFFSET$short_term_ref_pic_set_idx, value);
        return this;
    }

    public int PicOrderCntVal() {
        return segment.get(LAYOUT$PicOrderCntVal, OFFSET$PicOrderCntVal);
    }

    public StdVideoEncodeH265PictureInfo PicOrderCntVal(int value) {
        segment.set(LAYOUT$PicOrderCntVal, OFFSET$PicOrderCntVal, value);
        return this;
    }

    public @Unsigned byte TemporalId() {
        return segment.get(LAYOUT$TemporalId, OFFSET$TemporalId);
    }

    public StdVideoEncodeH265PictureInfo TemporalId(@Unsigned byte value) {
        segment.set(LAYOUT$TemporalId, OFFSET$TemporalId, value);
        return this;
    }


    public StdVideoEncodeH265PictureInfo pRefLists(@Nullable IStdVideoEncodeH265ReferenceListsInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRefListsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoEncodeH265ReferenceListsInfo.Ptr pRefLists(int assumedCount) {
        MemorySegment s = pRefListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoEncodeH265ReferenceListsInfo.BYTES);
        return new StdVideoEncodeH265ReferenceListsInfo.Ptr(s);
    }

    public @Nullable StdVideoEncodeH265ReferenceListsInfo pRefLists() {
        MemorySegment s = pRefListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoEncodeH265ReferenceListsInfo(s);
    }

    public @Pointer(target=StdVideoEncodeH265ReferenceListsInfo.class) @NotNull MemorySegment pRefListsRaw() {
        return segment.get(LAYOUT$pRefLists, OFFSET$pRefLists);
    }

    public void pRefListsRaw(@Pointer(target=StdVideoEncodeH265ReferenceListsInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRefLists, OFFSET$pRefLists, value);
    }

    public StdVideoEncodeH265PictureInfo pShortTermRefPicSet(@Nullable IStdVideoH265ShortTermRefPicSet value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pShortTermRefPicSetRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265ShortTermRefPicSet.Ptr pShortTermRefPicSet(int assumedCount) {
        MemorySegment s = pShortTermRefPicSetRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265ShortTermRefPicSet.BYTES);
        return new StdVideoH265ShortTermRefPicSet.Ptr(s);
    }

    public @Nullable StdVideoH265ShortTermRefPicSet pShortTermRefPicSet() {
        MemorySegment s = pShortTermRefPicSetRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265ShortTermRefPicSet(s);
    }

    public @Pointer(target=StdVideoH265ShortTermRefPicSet.class) @NotNull MemorySegment pShortTermRefPicSetRaw() {
        return segment.get(LAYOUT$pShortTermRefPicSet, OFFSET$pShortTermRefPicSet);
    }

    public void pShortTermRefPicSetRaw(@Pointer(target=StdVideoH265ShortTermRefPicSet.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pShortTermRefPicSet, OFFSET$pShortTermRefPicSet, value);
    }

    public StdVideoEncodeH265PictureInfo pLongTermRefPics(@Nullable IStdVideoEncodeH265LongTermRefPics value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pLongTermRefPicsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoEncodeH265LongTermRefPics.Ptr pLongTermRefPics(int assumedCount) {
        MemorySegment s = pLongTermRefPicsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoEncodeH265LongTermRefPics.BYTES);
        return new StdVideoEncodeH265LongTermRefPics.Ptr(s);
    }

    public @Nullable StdVideoEncodeH265LongTermRefPics pLongTermRefPics() {
        MemorySegment s = pLongTermRefPicsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoEncodeH265LongTermRefPics(s);
    }

    public @Pointer(target=StdVideoEncodeH265LongTermRefPics.class) @NotNull MemorySegment pLongTermRefPicsRaw() {
        return segment.get(LAYOUT$pLongTermRefPics, OFFSET$pLongTermRefPics);
    }

    public void pLongTermRefPicsRaw(@Pointer(target=StdVideoEncodeH265LongTermRefPics.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pLongTermRefPics, OFFSET$pLongTermRefPics, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoEncodeH265PictureInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("pic_type"),
        ValueLayout.JAVA_BYTE.withName("sps_video_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("pps_seq_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("pps_pic_parameter_set_id"),
        ValueLayout.JAVA_BYTE.withName("short_term_ref_pic_set_idx"),
        ValueLayout.JAVA_INT.withName("PicOrderCntVal"),
        ValueLayout.JAVA_BYTE.withName("TemporalId"),
        MemoryLayout.sequenceLayout(7, ValueLayout.JAVA_BYTE).withName("reserved1"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoEncodeH265ReferenceListsInfo.LAYOUT).withName("pRefLists"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265ShortTermRefPicSet.LAYOUT).withName("pShortTermRefPicSet"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoEncodeH265LongTermRefPics.LAYOUT).withName("pLongTermRefPics")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$pic_type = PathElement.groupElement("pic_type");
    public static final PathElement PATH$sps_video_parameter_set_id = PathElement.groupElement("sps_video_parameter_set_id");
    public static final PathElement PATH$pps_seq_parameter_set_id = PathElement.groupElement("pps_seq_parameter_set_id");
    public static final PathElement PATH$pps_pic_parameter_set_id = PathElement.groupElement("pps_pic_parameter_set_id");
    public static final PathElement PATH$short_term_ref_pic_set_idx = PathElement.groupElement("short_term_ref_pic_set_idx");
    public static final PathElement PATH$PicOrderCntVal = PathElement.groupElement("PicOrderCntVal");
    public static final PathElement PATH$TemporalId = PathElement.groupElement("TemporalId");
    public static final PathElement PATH$pRefLists = PathElement.groupElement("pRefLists");
    public static final PathElement PATH$pShortTermRefPicSet = PathElement.groupElement("pShortTermRefPicSet");
    public static final PathElement PATH$pLongTermRefPics = PathElement.groupElement("pLongTermRefPics");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$pic_type = (OfInt) LAYOUT.select(PATH$pic_type);
    public static final OfByte LAYOUT$sps_video_parameter_set_id = (OfByte) LAYOUT.select(PATH$sps_video_parameter_set_id);
    public static final OfByte LAYOUT$pps_seq_parameter_set_id = (OfByte) LAYOUT.select(PATH$pps_seq_parameter_set_id);
    public static final OfByte LAYOUT$pps_pic_parameter_set_id = (OfByte) LAYOUT.select(PATH$pps_pic_parameter_set_id);
    public static final OfByte LAYOUT$short_term_ref_pic_set_idx = (OfByte) LAYOUT.select(PATH$short_term_ref_pic_set_idx);
    public static final OfInt LAYOUT$PicOrderCntVal = (OfInt) LAYOUT.select(PATH$PicOrderCntVal);
    public static final OfByte LAYOUT$TemporalId = (OfByte) LAYOUT.select(PATH$TemporalId);
    public static final AddressLayout LAYOUT$pRefLists = (AddressLayout) LAYOUT.select(PATH$pRefLists);
    public static final AddressLayout LAYOUT$pShortTermRefPicSet = (AddressLayout) LAYOUT.select(PATH$pShortTermRefPicSet);
    public static final AddressLayout LAYOUT$pLongTermRefPics = (AddressLayout) LAYOUT.select(PATH$pLongTermRefPics);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$pic_type = LAYOUT$pic_type.byteSize();
    public static final long SIZE$sps_video_parameter_set_id = LAYOUT$sps_video_parameter_set_id.byteSize();
    public static final long SIZE$pps_seq_parameter_set_id = LAYOUT$pps_seq_parameter_set_id.byteSize();
    public static final long SIZE$pps_pic_parameter_set_id = LAYOUT$pps_pic_parameter_set_id.byteSize();
    public static final long SIZE$short_term_ref_pic_set_idx = LAYOUT$short_term_ref_pic_set_idx.byteSize();
    public static final long SIZE$PicOrderCntVal = LAYOUT$PicOrderCntVal.byteSize();
    public static final long SIZE$TemporalId = LAYOUT$TemporalId.byteSize();
    public static final long SIZE$pRefLists = LAYOUT$pRefLists.byteSize();
    public static final long SIZE$pShortTermRefPicSet = LAYOUT$pShortTermRefPicSet.byteSize();
    public static final long SIZE$pLongTermRefPics = LAYOUT$pLongTermRefPics.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$pic_type = LAYOUT.byteOffset(PATH$pic_type);
    public static final long OFFSET$sps_video_parameter_set_id = LAYOUT.byteOffset(PATH$sps_video_parameter_set_id);
    public static final long OFFSET$pps_seq_parameter_set_id = LAYOUT.byteOffset(PATH$pps_seq_parameter_set_id);
    public static final long OFFSET$pps_pic_parameter_set_id = LAYOUT.byteOffset(PATH$pps_pic_parameter_set_id);
    public static final long OFFSET$short_term_ref_pic_set_idx = LAYOUT.byteOffset(PATH$short_term_ref_pic_set_idx);
    public static final long OFFSET$PicOrderCntVal = LAYOUT.byteOffset(PATH$PicOrderCntVal);
    public static final long OFFSET$TemporalId = LAYOUT.byteOffset(PATH$TemporalId);
    public static final long OFFSET$pRefLists = LAYOUT.byteOffset(PATH$pRefLists);
    public static final long OFFSET$pShortTermRefPicSet = LAYOUT.byteOffset(PATH$pShortTermRefPicSet);
    public static final long OFFSET$pLongTermRefPics = LAYOUT.byteOffset(PATH$pLongTermRefPics);
}
