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

/// Represents a pointer to a {@code StdVideoAV1GlobalMotion} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoAV1GlobalMotion {
///     uint8_t[STD_VIDEO_AV1_NUM_REF_FRAMES] GmType; // @link substring="GmType" target="#GmType"
///     int32_t[STD_VIDEO_AV1_GLOBAL_MOTION_PARAMS][STD_VIDEO_AV1_NUM_REF_FRAMES] gm_params; // @link substring="gm_params" target="#gm_params"
/// } StdVideoAV1GlobalMotion;
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
public record StdVideoAV1GlobalMotion(@NotNull MemorySegment segment) implements IStdVideoAV1GlobalMotion {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoAV1GlobalMotion}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoAV1GlobalMotion to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoAV1GlobalMotion.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoAV1GlobalMotion, Iterable<StdVideoAV1GlobalMotion> {
        public long size() {
            return segment.byteSize() / StdVideoAV1GlobalMotion.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoAV1GlobalMotion at(long index) {
            return new StdVideoAV1GlobalMotion(segment.asSlice(index * StdVideoAV1GlobalMotion.BYTES, StdVideoAV1GlobalMotion.BYTES));
        }

        public StdVideoAV1GlobalMotion.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoAV1GlobalMotion> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoAV1GlobalMotion value) {
            MemorySegment s = segment.asSlice(index * StdVideoAV1GlobalMotion.BYTES, StdVideoAV1GlobalMotion.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoAV1GlobalMotion.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoAV1GlobalMotion.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoAV1GlobalMotion.BYTES,
                (end - start) * StdVideoAV1GlobalMotion.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoAV1GlobalMotion.BYTES));
        }

        public StdVideoAV1GlobalMotion[] toArray() {
            StdVideoAV1GlobalMotion[] ret = new StdVideoAV1GlobalMotion[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoAV1GlobalMotion> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoAV1GlobalMotion> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoAV1GlobalMotion.BYTES;
            }

            @Override
            public StdVideoAV1GlobalMotion next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoAV1GlobalMotion ret = new StdVideoAV1GlobalMotion(segment.asSlice(0, StdVideoAV1GlobalMotion.BYTES));
                segment = segment.asSlice(StdVideoAV1GlobalMotion.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoAV1GlobalMotion allocate(Arena arena) {
        return new StdVideoAV1GlobalMotion(arena.allocate(LAYOUT));
    }

    public static StdVideoAV1GlobalMotion.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoAV1GlobalMotion.Ptr(segment);
    }

    public static StdVideoAV1GlobalMotion clone(Arena arena, StdVideoAV1GlobalMotion src) {
        StdVideoAV1GlobalMotion ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned BytePtr GmType() {
        return new BytePtr(GmTypeRaw());
    }

    public StdVideoAV1GlobalMotion GmType(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = GmType();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1GlobalMotion GmType(@Unsigned BytePtr value) {
        MemorySegment s = GmTypeRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment GmTypeRaw() {
        return segment.asSlice(OFFSET$GmType, SIZE$GmType);
    }

    public IntPtr gm_params() {
        return new IntPtr(gm_paramsRaw());
    }

    public StdVideoAV1GlobalMotion gm_params(@NotNull Consumer<IntPtr> consumer) {
        IntPtr ptr = gm_params();
        consumer.accept(ptr);
        return this;
    }

    public StdVideoAV1GlobalMotion gm_params(IntPtr value) {
        MemorySegment s = gm_paramsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment gm_paramsRaw() {
        return segment.asSlice(OFFSET$gm_params, SIZE$gm_params);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(AV1_NUM_REF_FRAMES, ValueLayout.JAVA_BYTE).withName("GmType"),
        MemoryLayout.sequenceLayout(AV1_NUM_REF_FRAMES, MemoryLayout.sequenceLayout(AV1_GLOBAL_MOTION_PARAMS, ValueLayout.JAVA_INT)).withName("gm_params")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$GmType = PathElement.groupElement("GmType");
    public static final PathElement PATH$gm_params = PathElement.groupElement("gm_params");

    public static final SequenceLayout LAYOUT$GmType = (SequenceLayout) LAYOUT.select(PATH$GmType);
    public static final SequenceLayout LAYOUT$gm_params = (SequenceLayout) LAYOUT.select(PATH$gm_params);

    public static final long SIZE$GmType = LAYOUT$GmType.byteSize();
    public static final long SIZE$gm_params = LAYOUT$gm_params.byteSize();

    public static final long OFFSET$GmType = LAYOUT.byteOffset(PATH$GmType);
    public static final long OFFSET$gm_params = LAYOUT.byteOffset(PATH$gm_params);
}
