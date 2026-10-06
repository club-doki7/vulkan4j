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

/// Represents a pointer to a {@code NvSciSyncFence} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct NvSciSyncFence {
///     uint64_t[6] payload; // @link substring="payload" target="#payload"
/// } NvSciSyncFence;
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
public record NvSciSyncFenceVKREF(@NotNull MemorySegment segment) implements INvSciSyncFenceVKREF {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link NvSciSyncFenceVKREF}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// INvSciSyncFenceVKREF to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code NvSciSyncFenceVKREF.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements INvSciSyncFenceVKREF, Iterable<NvSciSyncFenceVKREF> {
        public long size() {
            return segment.byteSize() / NvSciSyncFenceVKREF.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull NvSciSyncFenceVKREF at(long index) {
            return new NvSciSyncFenceVKREF(segment.asSlice(index * NvSciSyncFenceVKREF.BYTES, NvSciSyncFenceVKREF.BYTES));
        }

        public NvSciSyncFenceVKREF.Ptr at(long index, @NotNull Consumer<@NotNull NvSciSyncFenceVKREF> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull NvSciSyncFenceVKREF value) {
            MemorySegment s = segment.asSlice(index * NvSciSyncFenceVKREF.BYTES, NvSciSyncFenceVKREF.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * NvSciSyncFenceVKREF.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * NvSciSyncFenceVKREF.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * NvSciSyncFenceVKREF.BYTES,
                (end - start) * NvSciSyncFenceVKREF.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * NvSciSyncFenceVKREF.BYTES));
        }

        public NvSciSyncFenceVKREF[] toArray() {
            NvSciSyncFenceVKREF[] ret = new NvSciSyncFenceVKREF[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<NvSciSyncFenceVKREF> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<NvSciSyncFenceVKREF> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= NvSciSyncFenceVKREF.BYTES;
            }

            @Override
            public NvSciSyncFenceVKREF next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NvSciSyncFenceVKREF ret = new NvSciSyncFenceVKREF(segment.asSlice(0, NvSciSyncFenceVKREF.BYTES));
                segment = segment.asSlice(NvSciSyncFenceVKREF.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static NvSciSyncFenceVKREF allocate(Arena arena) {
        return new NvSciSyncFenceVKREF(arena.allocate(LAYOUT));
    }

    public static NvSciSyncFenceVKREF.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new NvSciSyncFenceVKREF.Ptr(segment);
    }

    public static NvSciSyncFenceVKREF clone(Arena arena, NvSciSyncFenceVKREF src) {
        NvSciSyncFenceVKREF ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned LongPtr payload() {
        return new LongPtr(payloadRaw());
    }

    public NvSciSyncFenceVKREF payload(@NotNull Consumer<LongPtr> consumer) {
        @Unsigned LongPtr ptr = payload();
        consumer.accept(ptr);
        return this;
    }

    public NvSciSyncFenceVKREF payload(@Unsigned LongPtr value) {
        MemorySegment s = payloadRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment payloadRaw() {
        return segment.asSlice(OFFSET$payload, SIZE$payload);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(6, ValueLayout.JAVA_LONG).withName("payload")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$payload = PathElement.groupElement("payload");

    public static final SequenceLayout LAYOUT$payload = (SequenceLayout) LAYOUT.select(PATH$payload);

    public static final long SIZE$payload = LAYOUT$payload.byteSize();

    public static final long OFFSET$payload = LAYOUT.byteOffset(PATH$payload);
}
