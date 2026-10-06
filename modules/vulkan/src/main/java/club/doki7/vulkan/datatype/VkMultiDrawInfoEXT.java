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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMultiDrawInfoEXT.html"><code>VkMultiDrawInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMultiDrawInfoEXT {
///     uint32_t firstVertex; // @link substring="firstVertex" target="#firstVertex"
///     uint32_t vertexCount; // @link substring="vertexCount" target="#vertexCount"
/// } VkMultiDrawInfoEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMultiDrawInfoEXT.html"><code>VkMultiDrawInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMultiDrawInfoEXT(@NotNull MemorySegment segment) implements IVkMultiDrawInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMultiDrawInfoEXT.html"><code>VkMultiDrawInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMultiDrawInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMultiDrawInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMultiDrawInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMultiDrawInfoEXT, Iterable<VkMultiDrawInfoEXT> {
        public long size() {
            return segment.byteSize() / VkMultiDrawInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMultiDrawInfoEXT at(long index) {
            return new VkMultiDrawInfoEXT(segment.asSlice(index * VkMultiDrawInfoEXT.BYTES, VkMultiDrawInfoEXT.BYTES));
        }

        public VkMultiDrawInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkMultiDrawInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMultiDrawInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkMultiDrawInfoEXT.BYTES, VkMultiDrawInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMultiDrawInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMultiDrawInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMultiDrawInfoEXT.BYTES,
                (end - start) * VkMultiDrawInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMultiDrawInfoEXT.BYTES));
        }

        public VkMultiDrawInfoEXT[] toArray() {
            VkMultiDrawInfoEXT[] ret = new VkMultiDrawInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMultiDrawInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMultiDrawInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMultiDrawInfoEXT.BYTES;
            }

            @Override
            public VkMultiDrawInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMultiDrawInfoEXT ret = new VkMultiDrawInfoEXT(segment.asSlice(0, VkMultiDrawInfoEXT.BYTES));
                segment = segment.asSlice(VkMultiDrawInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMultiDrawInfoEXT allocate(Arena arena) {
        return new VkMultiDrawInfoEXT(arena.allocate(LAYOUT));
    }

    public static VkMultiDrawInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkMultiDrawInfoEXT.Ptr(segment);
    }

    public static VkMultiDrawInfoEXT clone(Arena arena, VkMultiDrawInfoEXT src) {
        VkMultiDrawInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int firstVertex() {
        return segment.get(LAYOUT$firstVertex, OFFSET$firstVertex);
    }

    public VkMultiDrawInfoEXT firstVertex(@Unsigned int value) {
        segment.set(LAYOUT$firstVertex, OFFSET$firstVertex, value);
        return this;
    }

    public @Unsigned int vertexCount() {
        return segment.get(LAYOUT$vertexCount, OFFSET$vertexCount);
    }

    public VkMultiDrawInfoEXT vertexCount(@Unsigned int value) {
        segment.set(LAYOUT$vertexCount, OFFSET$vertexCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("firstVertex"),
        ValueLayout.JAVA_INT.withName("vertexCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$firstVertex = PathElement.groupElement("firstVertex");
    public static final PathElement PATH$vertexCount = PathElement.groupElement("vertexCount");

    public static final OfInt LAYOUT$firstVertex = (OfInt) LAYOUT.select(PATH$firstVertex);
    public static final OfInt LAYOUT$vertexCount = (OfInt) LAYOUT.select(PATH$vertexCount);

    public static final long SIZE$firstVertex = LAYOUT$firstVertex.byteSize();
    public static final long SIZE$vertexCount = LAYOUT$vertexCount.byteSize();

    public static final long OFFSET$firstVertex = LAYOUT.byteOffset(PATH$firstVertex);
    public static final long OFFSET$vertexCount = LAYOUT.byteOffset(PATH$vertexCount);
}
