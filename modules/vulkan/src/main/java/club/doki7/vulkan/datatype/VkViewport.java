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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkViewport.html"><code>VkViewport</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkViewport {
///     float x; // @link substring="x" target="#x"
///     float y; // @link substring="y" target="#y"
///     float width; // @link substring="width" target="#width"
///     float height; // @link substring="height" target="#height"
///     float minDepth; // @link substring="minDepth" target="#minDepth"
///     float maxDepth; // @link substring="maxDepth" target="#maxDepth"
/// } VkViewport;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkViewport.html"><code>VkViewport</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkViewport(@NotNull MemorySegment segment) implements IVkViewport {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkViewport.html"><code>VkViewport</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkViewport}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkViewport to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkViewport.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkViewport, Iterable<VkViewport> {
        public long size() {
            return segment.byteSize() / VkViewport.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkViewport at(long index) {
            return new VkViewport(segment.asSlice(index * VkViewport.BYTES, VkViewport.BYTES));
        }

        public VkViewport.Ptr at(long index, @NotNull Consumer<@NotNull VkViewport> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkViewport value) {
            MemorySegment s = segment.asSlice(index * VkViewport.BYTES, VkViewport.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkViewport.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkViewport.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkViewport.BYTES,
                (end - start) * VkViewport.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkViewport.BYTES));
        }

        public VkViewport[] toArray() {
            VkViewport[] ret = new VkViewport[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkViewport> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkViewport> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkViewport.BYTES;
            }

            @Override
            public VkViewport next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkViewport ret = new VkViewport(segment.asSlice(0, VkViewport.BYTES));
                segment = segment.asSlice(VkViewport.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkViewport allocate(Arena arena) {
        return new VkViewport(arena.allocate(LAYOUT));
    }

    public static VkViewport.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkViewport.Ptr(segment);
    }

    public static VkViewport clone(Arena arena, VkViewport src) {
        VkViewport ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public float x() {
        return segment.get(LAYOUT$x, OFFSET$x);
    }

    public VkViewport x(float value) {
        segment.set(LAYOUT$x, OFFSET$x, value);
        return this;
    }

    public float y() {
        return segment.get(LAYOUT$y, OFFSET$y);
    }

    public VkViewport y(float value) {
        segment.set(LAYOUT$y, OFFSET$y, value);
        return this;
    }

    public float width() {
        return segment.get(LAYOUT$width, OFFSET$width);
    }

    public VkViewport width(float value) {
        segment.set(LAYOUT$width, OFFSET$width, value);
        return this;
    }

    public float height() {
        return segment.get(LAYOUT$height, OFFSET$height);
    }

    public VkViewport height(float value) {
        segment.set(LAYOUT$height, OFFSET$height, value);
        return this;
    }

    public float minDepth() {
        return segment.get(LAYOUT$minDepth, OFFSET$minDepth);
    }

    public VkViewport minDepth(float value) {
        segment.set(LAYOUT$minDepth, OFFSET$minDepth, value);
        return this;
    }

    public float maxDepth() {
        return segment.get(LAYOUT$maxDepth, OFFSET$maxDepth);
    }

    public VkViewport maxDepth(float value) {
        segment.set(LAYOUT$maxDepth, OFFSET$maxDepth, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_FLOAT.withName("x"),
        ValueLayout.JAVA_FLOAT.withName("y"),
        ValueLayout.JAVA_FLOAT.withName("width"),
        ValueLayout.JAVA_FLOAT.withName("height"),
        ValueLayout.JAVA_FLOAT.withName("minDepth"),
        ValueLayout.JAVA_FLOAT.withName("maxDepth")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$x = PathElement.groupElement("x");
    public static final PathElement PATH$y = PathElement.groupElement("y");
    public static final PathElement PATH$width = PathElement.groupElement("width");
    public static final PathElement PATH$height = PathElement.groupElement("height");
    public static final PathElement PATH$minDepth = PathElement.groupElement("minDepth");
    public static final PathElement PATH$maxDepth = PathElement.groupElement("maxDepth");

    public static final OfFloat LAYOUT$x = (OfFloat) LAYOUT.select(PATH$x);
    public static final OfFloat LAYOUT$y = (OfFloat) LAYOUT.select(PATH$y);
    public static final OfFloat LAYOUT$width = (OfFloat) LAYOUT.select(PATH$width);
    public static final OfFloat LAYOUT$height = (OfFloat) LAYOUT.select(PATH$height);
    public static final OfFloat LAYOUT$minDepth = (OfFloat) LAYOUT.select(PATH$minDepth);
    public static final OfFloat LAYOUT$maxDepth = (OfFloat) LAYOUT.select(PATH$maxDepth);

    public static final long SIZE$x = LAYOUT$x.byteSize();
    public static final long SIZE$y = LAYOUT$y.byteSize();
    public static final long SIZE$width = LAYOUT$width.byteSize();
    public static final long SIZE$height = LAYOUT$height.byteSize();
    public static final long SIZE$minDepth = LAYOUT$minDepth.byteSize();
    public static final long SIZE$maxDepth = LAYOUT$maxDepth.byteSize();

    public static final long OFFSET$x = LAYOUT.byteOffset(PATH$x);
    public static final long OFFSET$y = LAYOUT.byteOffset(PATH$y);
    public static final long OFFSET$width = LAYOUT.byteOffset(PATH$width);
    public static final long OFFSET$height = LAYOUT.byteOffset(PATH$height);
    public static final long OFFSET$minDepth = LAYOUT.byteOffset(PATH$minDepth);
    public static final long OFFSET$maxDepth = LAYOUT.byteOffset(PATH$maxDepth);
}
