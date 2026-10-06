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

/// Represents a pointer to a {@code StdVideoEncodeH264ReferenceListsInfoFlags} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoEncodeH264ReferenceListsInfoFlags {
///     uint32_t ref_pic_list_modification_flag_l0 : 1; // @link substring="ref_pic_list_modification_flag_l0" target="#ref_pic_list_modification_flag_l0"
///     uint32_t ref_pic_list_modification_flag_l1 : 1; // @link substring="ref_pic_list_modification_flag_l1" target="#ref_pic_list_modification_flag_l1"
///     uint32_t reserved : 30;
/// } StdVideoEncodeH264ReferenceListsInfoFlags;
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
public record StdVideoEncodeH264ReferenceListsInfoFlags(@NotNull MemorySegment segment) implements IStdVideoEncodeH264ReferenceListsInfoFlags {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoEncodeH264ReferenceListsInfoFlags}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoEncodeH264ReferenceListsInfoFlags to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoEncodeH264ReferenceListsInfoFlags.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoEncodeH264ReferenceListsInfoFlags, Iterable<StdVideoEncodeH264ReferenceListsInfoFlags> {
        public long size() {
            return segment.byteSize() / StdVideoEncodeH264ReferenceListsInfoFlags.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoEncodeH264ReferenceListsInfoFlags at(long index) {
            return new StdVideoEncodeH264ReferenceListsInfoFlags(segment.asSlice(index * StdVideoEncodeH264ReferenceListsInfoFlags.BYTES, StdVideoEncodeH264ReferenceListsInfoFlags.BYTES));
        }

        public StdVideoEncodeH264ReferenceListsInfoFlags.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoEncodeH264ReferenceListsInfoFlags> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoEncodeH264ReferenceListsInfoFlags value) {
            MemorySegment s = segment.asSlice(index * StdVideoEncodeH264ReferenceListsInfoFlags.BYTES, StdVideoEncodeH264ReferenceListsInfoFlags.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoEncodeH264ReferenceListsInfoFlags.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoEncodeH264ReferenceListsInfoFlags.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoEncodeH264ReferenceListsInfoFlags.BYTES,
                (end - start) * StdVideoEncodeH264ReferenceListsInfoFlags.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoEncodeH264ReferenceListsInfoFlags.BYTES));
        }

        public StdVideoEncodeH264ReferenceListsInfoFlags[] toArray() {
            StdVideoEncodeH264ReferenceListsInfoFlags[] ret = new StdVideoEncodeH264ReferenceListsInfoFlags[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoEncodeH264ReferenceListsInfoFlags> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoEncodeH264ReferenceListsInfoFlags> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoEncodeH264ReferenceListsInfoFlags.BYTES;
            }

            @Override
            public StdVideoEncodeH264ReferenceListsInfoFlags next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoEncodeH264ReferenceListsInfoFlags ret = new StdVideoEncodeH264ReferenceListsInfoFlags(segment.asSlice(0, StdVideoEncodeH264ReferenceListsInfoFlags.BYTES));
                segment = segment.asSlice(StdVideoEncodeH264ReferenceListsInfoFlags.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoEncodeH264ReferenceListsInfoFlags allocate(Arena arena) {
        return new StdVideoEncodeH264ReferenceListsInfoFlags(arena.allocate(LAYOUT));
    }

    public static StdVideoEncodeH264ReferenceListsInfoFlags.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoEncodeH264ReferenceListsInfoFlags.Ptr(segment);
    }

    public static StdVideoEncodeH264ReferenceListsInfoFlags clone(Arena arena, StdVideoEncodeH264ReferenceListsInfoFlags src) {
        StdVideoEncodeH264ReferenceListsInfoFlags ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public boolean ref_pic_list_modification_flag_l0() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$ref_pic_list_modification_flag_l0$reserved, LAYOUT$bitfield$ref_pic_list_modification_flag_l0$reserved);
        return BitfieldUtil.readBit(s, 0);
    }

    public StdVideoEncodeH264ReferenceListsInfoFlags ref_pic_list_modification_flag_l0(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$ref_pic_list_modification_flag_l0$reserved, LAYOUT$bitfield$ref_pic_list_modification_flag_l0$reserved);
        BitfieldUtil.writeBit(s, 0, value);
        return this;
    }

    public boolean ref_pic_list_modification_flag_l1() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$ref_pic_list_modification_flag_l0$reserved, LAYOUT$bitfield$ref_pic_list_modification_flag_l0$reserved);
        return BitfieldUtil.readBit(s, 1);
    }

    public StdVideoEncodeH264ReferenceListsInfoFlags ref_pic_list_modification_flag_l1(boolean value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$ref_pic_list_modification_flag_l0$reserved, LAYOUT$bitfield$ref_pic_list_modification_flag_l0$reserved);
        BitfieldUtil.writeBit(s, 1, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$ref_pic_list_modification_flag_l0$reserved")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$ref_pic_list_modification_flag_l0$reserved = PathElement.groupElement("ref_pic_list_modification_flag_l0$reserved");

    public static final OfInt LAYOUT$bitfield$ref_pic_list_modification_flag_l0$reserved = (OfInt) LAYOUT.select(PATH$bitfield$ref_pic_list_modification_flag_l0$reserved);


    public static final long OFFSET$bitfield$ref_pic_list_modification_flag_l0$reserved = LAYOUT.byteOffset(PATH$bitfield$ref_pic_list_modification_flag_l0$reserved);
}
