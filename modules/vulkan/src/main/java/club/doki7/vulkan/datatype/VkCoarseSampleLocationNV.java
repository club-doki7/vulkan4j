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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCoarseSampleLocationNV.html"><code>VkCoarseSampleLocationNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCoarseSampleLocationNV {
///     uint32_t pixelX; // @link substring="pixelX" target="#pixelX"
///     uint32_t pixelY; // @link substring="pixelY" target="#pixelY"
///     uint32_t sample; // @link substring="sample" target="#sample"
/// } VkCoarseSampleLocationNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCoarseSampleLocationNV.html"><code>VkCoarseSampleLocationNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCoarseSampleLocationNV(@NotNull MemorySegment segment) implements IVkCoarseSampleLocationNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCoarseSampleLocationNV.html"><code>VkCoarseSampleLocationNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCoarseSampleLocationNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCoarseSampleLocationNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCoarseSampleLocationNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCoarseSampleLocationNV, Iterable<VkCoarseSampleLocationNV> {
        public long size() {
            return segment.byteSize() / VkCoarseSampleLocationNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCoarseSampleLocationNV at(long index) {
            return new VkCoarseSampleLocationNV(segment.asSlice(index * VkCoarseSampleLocationNV.BYTES, VkCoarseSampleLocationNV.BYTES));
        }

        public VkCoarseSampleLocationNV.Ptr at(long index, @NotNull Consumer<@NotNull VkCoarseSampleLocationNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCoarseSampleLocationNV value) {
            MemorySegment s = segment.asSlice(index * VkCoarseSampleLocationNV.BYTES, VkCoarseSampleLocationNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCoarseSampleLocationNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCoarseSampleLocationNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCoarseSampleLocationNV.BYTES,
                (end - start) * VkCoarseSampleLocationNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCoarseSampleLocationNV.BYTES));
        }

        public VkCoarseSampleLocationNV[] toArray() {
            VkCoarseSampleLocationNV[] ret = new VkCoarseSampleLocationNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCoarseSampleLocationNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCoarseSampleLocationNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCoarseSampleLocationNV.BYTES;
            }

            @Override
            public VkCoarseSampleLocationNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCoarseSampleLocationNV ret = new VkCoarseSampleLocationNV(segment.asSlice(0, VkCoarseSampleLocationNV.BYTES));
                segment = segment.asSlice(VkCoarseSampleLocationNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCoarseSampleLocationNV allocate(Arena arena) {
        return new VkCoarseSampleLocationNV(arena.allocate(LAYOUT));
    }

    public static VkCoarseSampleLocationNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkCoarseSampleLocationNV.Ptr(segment);
    }

    public static VkCoarseSampleLocationNV clone(Arena arena, VkCoarseSampleLocationNV src) {
        VkCoarseSampleLocationNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int pixelX() {
        return segment.get(LAYOUT$pixelX, OFFSET$pixelX);
    }

    public VkCoarseSampleLocationNV pixelX(@Unsigned int value) {
        segment.set(LAYOUT$pixelX, OFFSET$pixelX, value);
        return this;
    }

    public @Unsigned int pixelY() {
        return segment.get(LAYOUT$pixelY, OFFSET$pixelY);
    }

    public VkCoarseSampleLocationNV pixelY(@Unsigned int value) {
        segment.set(LAYOUT$pixelY, OFFSET$pixelY, value);
        return this;
    }

    public @Unsigned int sample() {
        return segment.get(LAYOUT$sample, OFFSET$sample);
    }

    public VkCoarseSampleLocationNV sample(@Unsigned int value) {
        segment.set(LAYOUT$sample, OFFSET$sample, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("pixelX"),
        ValueLayout.JAVA_INT.withName("pixelY"),
        ValueLayout.JAVA_INT.withName("sample")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$pixelX = PathElement.groupElement("pixelX");
    public static final PathElement PATH$pixelY = PathElement.groupElement("pixelY");
    public static final PathElement PATH$sample = PathElement.groupElement("sample");

    public static final OfInt LAYOUT$pixelX = (OfInt) LAYOUT.select(PATH$pixelX);
    public static final OfInt LAYOUT$pixelY = (OfInt) LAYOUT.select(PATH$pixelY);
    public static final OfInt LAYOUT$sample = (OfInt) LAYOUT.select(PATH$sample);

    public static final long SIZE$pixelX = LAYOUT$pixelX.byteSize();
    public static final long SIZE$pixelY = LAYOUT$pixelY.byteSize();
    public static final long SIZE$sample = LAYOUT$sample.byteSize();

    public static final long OFFSET$pixelX = LAYOUT.byteOffset(PATH$pixelX);
    public static final long OFFSET$pixelY = LAYOUT.byteOffset(PATH$pixelY);
    public static final long OFFSET$sample = LAYOUT.byteOffset(PATH$sample);
}
