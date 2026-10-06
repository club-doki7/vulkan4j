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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClearRect.html"><code>VkClearRect</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkClearRect {
///     VkRect2D rect; // @link substring="VkRect2D" target="VkRect2D" @link substring="rect" target="#rect"
///     uint32_t baseArrayLayer; // @link substring="baseArrayLayer" target="#baseArrayLayer"
///     uint32_t layerCount; // @link substring="layerCount" target="#layerCount"
/// } VkClearRect;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClearRect.html"><code>VkClearRect</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClearRect(@NotNull MemorySegment segment) implements IVkClearRect {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClearRect.html"><code>VkClearRect</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClearRect}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClearRect to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClearRect.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClearRect, Iterable<VkClearRect> {
        public long size() {
            return segment.byteSize() / VkClearRect.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClearRect at(long index) {
            return new VkClearRect(segment.asSlice(index * VkClearRect.BYTES, VkClearRect.BYTES));
        }

        public VkClearRect.Ptr at(long index, @NotNull Consumer<@NotNull VkClearRect> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClearRect value) {
            MemorySegment s = segment.asSlice(index * VkClearRect.BYTES, VkClearRect.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClearRect.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClearRect.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClearRect.BYTES,
                (end - start) * VkClearRect.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClearRect.BYTES));
        }

        public VkClearRect[] toArray() {
            VkClearRect[] ret = new VkClearRect[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClearRect> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClearRect> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClearRect.BYTES;
            }

            @Override
            public VkClearRect next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClearRect ret = new VkClearRect(segment.asSlice(0, VkClearRect.BYTES));
                segment = segment.asSlice(VkClearRect.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClearRect allocate(Arena arena) {
        return new VkClearRect(arena.allocate(LAYOUT));
    }

    public static VkClearRect.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkClearRect.Ptr(segment);
    }

    public static VkClearRect clone(Arena arena, VkClearRect src) {
        VkClearRect ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkRect2D rect() {
        return new VkRect2D(segment.asSlice(OFFSET$rect, LAYOUT$rect));
    }

    public VkClearRect rect(@NotNull VkRect2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$rect, SIZE$rect);
        return this;
    }

    public VkClearRect rect(Consumer<@NotNull VkRect2D> consumer) {
        consumer.accept(rect());
        return this;
    }

    public @Unsigned int baseArrayLayer() {
        return segment.get(LAYOUT$baseArrayLayer, OFFSET$baseArrayLayer);
    }

    public VkClearRect baseArrayLayer(@Unsigned int value) {
        segment.set(LAYOUT$baseArrayLayer, OFFSET$baseArrayLayer, value);
        return this;
    }

    public @Unsigned int layerCount() {
        return segment.get(LAYOUT$layerCount, OFFSET$layerCount);
    }

    public VkClearRect layerCount(@Unsigned int value) {
        segment.set(LAYOUT$layerCount, OFFSET$layerCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkRect2D.LAYOUT.withName("rect"),
        ValueLayout.JAVA_INT.withName("baseArrayLayer"),
        ValueLayout.JAVA_INT.withName("layerCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$rect = PathElement.groupElement("rect");
    public static final PathElement PATH$baseArrayLayer = PathElement.groupElement("baseArrayLayer");
    public static final PathElement PATH$layerCount = PathElement.groupElement("layerCount");

    public static final StructLayout LAYOUT$rect = (StructLayout) LAYOUT.select(PATH$rect);
    public static final OfInt LAYOUT$baseArrayLayer = (OfInt) LAYOUT.select(PATH$baseArrayLayer);
    public static final OfInt LAYOUT$layerCount = (OfInt) LAYOUT.select(PATH$layerCount);

    public static final long SIZE$rect = LAYOUT$rect.byteSize();
    public static final long SIZE$baseArrayLayer = LAYOUT$baseArrayLayer.byteSize();
    public static final long SIZE$layerCount = LAYOUT$layerCount.byteSize();

    public static final long OFFSET$rect = LAYOUT.byteOffset(PATH$rect);
    public static final long OFFSET$baseArrayLayer = LAYOUT.byteOffset(PATH$baseArrayLayer);
    public static final long OFFSET$layerCount = LAYOUT.byteOffset(PATH$layerCount);
}
