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

/// Represents a pointer to a {@code StdVideoDecodeH265ReferenceInfo} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoDecodeH265ReferenceInfo {
///     StdVideoDecodeH265ReferenceInfoFlags flags; // @link substring="StdVideoDecodeH265ReferenceInfoFlags" target="StdVideoDecodeH265ReferenceInfoFlags" @link substring="flags" target="#flags"
///     int32_t PicOrderCntVal; // @link substring="PicOrderCntVal" target="#PicOrderCntVal"
/// } StdVideoDecodeH265ReferenceInfo;
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
public record StdVideoDecodeH265ReferenceInfo(@NotNull MemorySegment segment) implements IStdVideoDecodeH265ReferenceInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoDecodeH265ReferenceInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoDecodeH265ReferenceInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoDecodeH265ReferenceInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoDecodeH265ReferenceInfo, Iterable<StdVideoDecodeH265ReferenceInfo> {
        public long size() {
            return segment.byteSize() / StdVideoDecodeH265ReferenceInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoDecodeH265ReferenceInfo at(long index) {
            return new StdVideoDecodeH265ReferenceInfo(segment.asSlice(index * StdVideoDecodeH265ReferenceInfo.BYTES, StdVideoDecodeH265ReferenceInfo.BYTES));
        }

        public StdVideoDecodeH265ReferenceInfo.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoDecodeH265ReferenceInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoDecodeH265ReferenceInfo value) {
            MemorySegment s = segment.asSlice(index * StdVideoDecodeH265ReferenceInfo.BYTES, StdVideoDecodeH265ReferenceInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoDecodeH265ReferenceInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoDecodeH265ReferenceInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoDecodeH265ReferenceInfo.BYTES,
                (end - start) * StdVideoDecodeH265ReferenceInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoDecodeH265ReferenceInfo.BYTES));
        }

        public StdVideoDecodeH265ReferenceInfo[] toArray() {
            StdVideoDecodeH265ReferenceInfo[] ret = new StdVideoDecodeH265ReferenceInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoDecodeH265ReferenceInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoDecodeH265ReferenceInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoDecodeH265ReferenceInfo.BYTES;
            }

            @Override
            public StdVideoDecodeH265ReferenceInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoDecodeH265ReferenceInfo ret = new StdVideoDecodeH265ReferenceInfo(segment.asSlice(0, StdVideoDecodeH265ReferenceInfo.BYTES));
                segment = segment.asSlice(StdVideoDecodeH265ReferenceInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoDecodeH265ReferenceInfo allocate(Arena arena) {
        return new StdVideoDecodeH265ReferenceInfo(arena.allocate(LAYOUT));
    }

    public static StdVideoDecodeH265ReferenceInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoDecodeH265ReferenceInfo.Ptr(segment);
    }

    public static StdVideoDecodeH265ReferenceInfo clone(Arena arena, StdVideoDecodeH265ReferenceInfo src) {
        StdVideoDecodeH265ReferenceInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoDecodeH265ReferenceInfoFlags flags() {
        return new StdVideoDecodeH265ReferenceInfoFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoDecodeH265ReferenceInfo flags(@NotNull StdVideoDecodeH265ReferenceInfoFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoDecodeH265ReferenceInfo flags(Consumer<@NotNull StdVideoDecodeH265ReferenceInfoFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public int PicOrderCntVal() {
        return segment.get(LAYOUT$PicOrderCntVal, OFFSET$PicOrderCntVal);
    }

    public StdVideoDecodeH265ReferenceInfo PicOrderCntVal(int value) {
        segment.set(LAYOUT$PicOrderCntVal, OFFSET$PicOrderCntVal, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoDecodeH265ReferenceInfoFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("PicOrderCntVal")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$PicOrderCntVal = PathElement.groupElement("PicOrderCntVal");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$PicOrderCntVal = (OfInt) LAYOUT.select(PATH$PicOrderCntVal);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$PicOrderCntVal = LAYOUT$PicOrderCntVal.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$PicOrderCntVal = LAYOUT.byteOffset(PATH$PicOrderCntVal);
}
