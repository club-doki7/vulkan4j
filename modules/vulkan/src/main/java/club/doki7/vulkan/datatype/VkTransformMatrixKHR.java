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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTransformMatrixKHR.html"><code>VkTransformMatrixKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkTransformMatrixKHR {
///     float[4][3] matrix; // @link substring="matrix" target="#matrix"
/// } VkTransformMatrixKHR;
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
///
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTransformMatrixKHR.html"><code>VkTransformMatrixKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkTransformMatrixKHR(@NotNull MemorySegment segment) implements IVkTransformMatrixKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTransformMatrixKHR.html"><code>VkTransformMatrixKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkTransformMatrixKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkTransformMatrixKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkTransformMatrixKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkTransformMatrixKHR, Iterable<VkTransformMatrixKHR> {
        public long size() {
            return segment.byteSize() / VkTransformMatrixKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkTransformMatrixKHR at(long index) {
            return new VkTransformMatrixKHR(segment.asSlice(index * VkTransformMatrixKHR.BYTES, VkTransformMatrixKHR.BYTES));
        }

        public VkTransformMatrixKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkTransformMatrixKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkTransformMatrixKHR value) {
            MemorySegment s = segment.asSlice(index * VkTransformMatrixKHR.BYTES, VkTransformMatrixKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkTransformMatrixKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkTransformMatrixKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkTransformMatrixKHR.BYTES,
                (end - start) * VkTransformMatrixKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkTransformMatrixKHR.BYTES));
        }

        public VkTransformMatrixKHR[] toArray() {
            VkTransformMatrixKHR[] ret = new VkTransformMatrixKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkTransformMatrixKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkTransformMatrixKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkTransformMatrixKHR.BYTES;
            }

            @Override
            public VkTransformMatrixKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkTransformMatrixKHR ret = new VkTransformMatrixKHR(segment.asSlice(0, VkTransformMatrixKHR.BYTES));
                segment = segment.asSlice(VkTransformMatrixKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkTransformMatrixKHR allocate(Arena arena) {
        return new VkTransformMatrixKHR(arena.allocate(LAYOUT));
    }

    public static VkTransformMatrixKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkTransformMatrixKHR.Ptr(segment);
    }

    public static VkTransformMatrixKHR clone(Arena arena, VkTransformMatrixKHR src) {
        VkTransformMatrixKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public FloatPtr matrix() {
        return new FloatPtr(matrixRaw());
    }

    public VkTransformMatrixKHR matrix(@NotNull Consumer<FloatPtr> consumer) {
        FloatPtr ptr = matrix();
        consumer.accept(ptr);
        return this;
    }

    public VkTransformMatrixKHR matrix(FloatPtr value) {
        MemorySegment s = matrixRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment matrixRaw() {
        return segment.asSlice(OFFSET$matrix, SIZE$matrix);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(3, MemoryLayout.sequenceLayout(4, ValueLayout.JAVA_FLOAT)).withName("matrix")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$matrix = PathElement.groupElement("matrix");

    public static final SequenceLayout LAYOUT$matrix = (SequenceLayout) LAYOUT.select(PATH$matrix);

    public static final long SIZE$matrix = LAYOUT$matrix.byteSize();

    public static final long OFFSET$matrix = LAYOUT.byteOffset(PATH$matrix);
}
