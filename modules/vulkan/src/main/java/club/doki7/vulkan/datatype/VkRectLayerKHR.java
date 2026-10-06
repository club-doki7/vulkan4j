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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRectLayerKHR.html"><code>VkRectLayerKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRectLayerKHR {
///     VkOffset2D offset; // @link substring="VkOffset2D" target="VkOffset2D" @link substring="offset" target="#offset"
///     VkExtent2D extent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="extent" target="#extent"
///     uint32_t layer; // @link substring="layer" target="#layer"
/// } VkRectLayerKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRectLayerKHR.html"><code>VkRectLayerKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRectLayerKHR(@NotNull MemorySegment segment) implements IVkRectLayerKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRectLayerKHR.html"><code>VkRectLayerKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRectLayerKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRectLayerKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRectLayerKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRectLayerKHR, Iterable<VkRectLayerKHR> {
        public long size() {
            return segment.byteSize() / VkRectLayerKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRectLayerKHR at(long index) {
            return new VkRectLayerKHR(segment.asSlice(index * VkRectLayerKHR.BYTES, VkRectLayerKHR.BYTES));
        }

        public VkRectLayerKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkRectLayerKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRectLayerKHR value) {
            MemorySegment s = segment.asSlice(index * VkRectLayerKHR.BYTES, VkRectLayerKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRectLayerKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRectLayerKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRectLayerKHR.BYTES,
                (end - start) * VkRectLayerKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRectLayerKHR.BYTES));
        }

        public VkRectLayerKHR[] toArray() {
            VkRectLayerKHR[] ret = new VkRectLayerKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRectLayerKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRectLayerKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRectLayerKHR.BYTES;
            }

            @Override
            public VkRectLayerKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRectLayerKHR ret = new VkRectLayerKHR(segment.asSlice(0, VkRectLayerKHR.BYTES));
                segment = segment.asSlice(VkRectLayerKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRectLayerKHR allocate(Arena arena) {
        return new VkRectLayerKHR(arena.allocate(LAYOUT));
    }

    public static VkRectLayerKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkRectLayerKHR.Ptr(segment);
    }

    public static VkRectLayerKHR clone(Arena arena, VkRectLayerKHR src) {
        VkRectLayerKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkOffset2D offset() {
        return new VkOffset2D(segment.asSlice(OFFSET$offset, LAYOUT$offset));
    }

    public VkRectLayerKHR offset(@NotNull VkOffset2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$offset, SIZE$offset);
        return this;
    }

    public VkRectLayerKHR offset(Consumer<@NotNull VkOffset2D> consumer) {
        consumer.accept(offset());
        return this;
    }

    public @NotNull VkExtent2D extent() {
        return new VkExtent2D(segment.asSlice(OFFSET$extent, LAYOUT$extent));
    }

    public VkRectLayerKHR extent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$extent, SIZE$extent);
        return this;
    }

    public VkRectLayerKHR extent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(extent());
        return this;
    }

    public @Unsigned int layer() {
        return segment.get(LAYOUT$layer, OFFSET$layer);
    }

    public VkRectLayerKHR layer(@Unsigned int value) {
        segment.set(LAYOUT$layer, OFFSET$layer, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkOffset2D.LAYOUT.withName("offset"),
        VkExtent2D.LAYOUT.withName("extent"),
        ValueLayout.JAVA_INT.withName("layer")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$offset = PathElement.groupElement("offset");
    public static final PathElement PATH$extent = PathElement.groupElement("extent");
    public static final PathElement PATH$layer = PathElement.groupElement("layer");

    public static final StructLayout LAYOUT$offset = (StructLayout) LAYOUT.select(PATH$offset);
    public static final StructLayout LAYOUT$extent = (StructLayout) LAYOUT.select(PATH$extent);
    public static final OfInt LAYOUT$layer = (OfInt) LAYOUT.select(PATH$layer);

    public static final long SIZE$offset = LAYOUT$offset.byteSize();
    public static final long SIZE$extent = LAYOUT$extent.byteSize();
    public static final long SIZE$layer = LAYOUT$layer.byteSize();

    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
    public static final long OFFSET$extent = LAYOUT.byteOffset(PATH$extent);
    public static final long OFFSET$layer = LAYOUT.byteOffset(PATH$layer);
}
