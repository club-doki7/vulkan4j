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

/// Represents a pointer to a {@code StdVideoEncodeH265ReferenceInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH265ReferenceInfo {
///     StdVideoEncodeH265ReferenceInfoFlags flags; // @link substring="StdVideoEncodeH265ReferenceInfoFlags" target="StdVideoEncodeH265ReferenceInfoFlags" @link substring="flags" target="#flags"
///     StdVideoH265PictureType pic_type; // @link substring="StdVideoH265PictureType" target="StdVideoH265PictureType" @link substring="pic_type" target="#pic_type"
///     int32_t PicOrderCntVal; // @link substring="PicOrderCntVal" target="#PicOrderCntVal"
///     uint8_t TemporalId; // @link substring="TemporalId" target="#TemporalId"
/// } StdVideoEncodeH265ReferenceInfo;
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
public record StdVideoEncodeH265ReferenceInfo(@NotNull MemorySegment segment) implements IStdVideoEncodeH265ReferenceInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH265ReferenceInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH265ReferenceInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH265ReferenceInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH265ReferenceInfo, Iterable<StdVideoEncodeH265ReferenceInfo> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH265ReferenceInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH265ReferenceInfo at(long index) {
            return new StdVideoEncodeH265ReferenceInfo(segment.asSlice(index * StdVideoEncodeH265ReferenceInfo.BYTES, StdVideoEncodeH265ReferenceInfo.BYTES));
        }

        public StdVideoEncodeH265ReferenceInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH265ReferenceInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH265ReferenceInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH265ReferenceInfo.BYTES, StdVideoEncodeH265ReferenceInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH265ReferenceInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH265ReferenceInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH265ReferenceInfo.BYTES,
                (end - start) * StdVideoEncodeH265ReferenceInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH265ReferenceInfo.BYTES));
        }

        public StdVideoEncodeH265ReferenceInfo[] toArray() {
            StdVideoEncodeH265ReferenceInfo[] ret = new StdVideoEncodeH265ReferenceInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH265ReferenceInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH265ReferenceInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH265ReferenceInfo.BYTES;
            }

            @Override
            public StdVideoEncodeH265ReferenceInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH265ReferenceInfo ret = new StdVideoEncodeH265ReferenceInfo(segment.asSlice(0, StdVideoEncodeH265ReferenceInfo.BYTES));
                segment = segment.asSlice(StdVideoEncodeH265ReferenceInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH265ReferenceInfo allocate(Arena arena) {
        return new StdVideoEncodeH265ReferenceInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH265ReferenceInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH265ReferenceInfo.Ptr(segment);
    }

    public static StdVideoEncodeH265ReferenceInfo clone(Arena arena, StdVideoEncodeH265ReferenceInfo src) {
        StdVideoEncodeH265ReferenceInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoEncodeH265ReferenceInfoFlags flags() {
        return new StdVideoEncodeH265ReferenceInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoEncodeH265ReferenceInfo flags(@NotNull StdVideoEncodeH265ReferenceInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoEncodeH265ReferenceInfo flags(Consumer<@NotNull StdVideoEncodeH265ReferenceInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoH265PictureType.class) int pic_type() {
        return segment.get(LAYOUT$pic_type, OFFSET$pic_type);
    }

    public StdVideoEncodeH265ReferenceInfo pic_type(@EnumType(StdVideoH265PictureType.class) int value) {
        segment.set(LAYOUT$pic_type, OFFSET$pic_type, value);
        return this;
    }

    public int PicOrderCntVal() {
        return segment.get(LAYOUT$PicOrderCntVal, OFFSET$PicOrderCntVal);
    }

    public StdVideoEncodeH265ReferenceInfo PicOrderCntVal(int value) {
        segment.set(LAYOUT$PicOrderCntVal, OFFSET$PicOrderCntVal, value);
        return this;
    }

    public @Unsigned byte TemporalId() {
        return segment.get(LAYOUT$TemporalId, OFFSET$TemporalId);
    }

    public StdVideoEncodeH265ReferenceInfo TemporalId(@Unsigned byte value) {
        segment.set(LAYOUT$TemporalId, OFFSET$TemporalId, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoEncodeH265ReferenceInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("pic_type"),
        ValueLayout.JAVA_INT.withName("PicOrderCntVal"),
        ValueLayout.JAVA_BYTE.withName("TemporalId")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$pic_type = PathElement.groupElement("pic_type");
    public static final PathElement PATH$PicOrderCntVal = PathElement.groupElement("PicOrderCntVal");
    public static final PathElement PATH$TemporalId = PathElement.groupElement("TemporalId");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$pic_type = (OfInt) LAYOUT.select(PATH$pic_type);
    public static final OfInt LAYOUT$PicOrderCntVal = (OfInt) LAYOUT.select(PATH$PicOrderCntVal);
    public static final OfByte LAYOUT$TemporalId = (OfByte) LAYOUT.select(PATH$TemporalId);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$pic_type = LAYOUT$pic_type.byteSize();
    public static final long SIZE$PicOrderCntVal = LAYOUT$PicOrderCntVal.byteSize();
    public static final long SIZE$TemporalId = LAYOUT$TemporalId.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$pic_type = LAYOUT.byteOffset(PATH$pic_type);
    public static final long OFFSET$PicOrderCntVal = LAYOUT.byteOffset(PATH$PicOrderCntVal);
    public static final long OFFSET$TemporalId = LAYOUT.byteOffset(PATH$TemporalId);
}
