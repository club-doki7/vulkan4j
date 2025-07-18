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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapTriangleEXT.html"><code>VkMicromapTriangleEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMicromapTriangleEXT {
///     uint32_t dataOffset; // @link substring="dataOffset" target="#dataOffset"
///     uint16_t subdivisionLevel; // @link substring="subdivisionLevel" target="#subdivisionLevel"
///     uint16_t format; // @link substring="format" target="#format"
/// } VkMicromapTriangleEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapTriangleEXT.html"><code>VkMicromapTriangleEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMicromapTriangleEXT(@NotNull MemorySegment segment) implements IVkMicromapTriangleEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapTriangleEXT.html"><code>VkMicromapTriangleEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMicromapTriangleEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMicromapTriangleEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMicromapTriangleEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMicromapTriangleEXT, Iterable<VkMicromapTriangleEXT> {
        public long size() {
            return segment.byteSize() / VkMicromapTriangleEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMicromapTriangleEXT at(long index) {
            return new VkMicromapTriangleEXT(segment.asSlice(index * VkMicromapTriangleEXT.BYTES, VkMicromapTriangleEXT.BYTES));
        }

        public VkMicromapTriangleEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkMicromapTriangleEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMicromapTriangleEXT value) {
            MemorySegment s = segment.asSlice(index * VkMicromapTriangleEXT.BYTES, VkMicromapTriangleEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMicromapTriangleEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMicromapTriangleEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMicromapTriangleEXT.BYTES,
                (end - start) * VkMicromapTriangleEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMicromapTriangleEXT.BYTES));
        }

        public VkMicromapTriangleEXT[] toArray() {
            VkMicromapTriangleEXT[] ret = new VkMicromapTriangleEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMicromapTriangleEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMicromapTriangleEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMicromapTriangleEXT.BYTES;
            }

            @Override
            public VkMicromapTriangleEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMicromapTriangleEXT ret = new VkMicromapTriangleEXT(segment.asSlice(0, VkMicromapTriangleEXT.BYTES));
                segment = segment.asSlice(VkMicromapTriangleEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMicromapTriangleEXT allocate(Arena arena) {
        return new VkMicromapTriangleEXT(arena.allocate(LAYOUT));
    }

    public static VkMicromapTriangleEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkMicromapTriangleEXT.Ptr(segment);
    }

    public static VkMicromapTriangleEXT clone(Arena arena, VkMicromapTriangleEXT src) {
        VkMicromapTriangleEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int dataOffset() {
        return segment.get(LAYOUT$dataOffset, OFFSET$dataOffset);
    }

    public VkMicromapTriangleEXT dataOffset(@Unsigned int value) {
        segment.set(LAYOUT$dataOffset, OFFSET$dataOffset, value);
        return this;
    }

    public @Unsigned short subdivisionLevel() {
        return segment.get(LAYOUT$subdivisionLevel, OFFSET$subdivisionLevel);
    }

    public VkMicromapTriangleEXT subdivisionLevel(@Unsigned short value) {
        segment.set(LAYOUT$subdivisionLevel, OFFSET$subdivisionLevel, value);
        return this;
    }

    public @Unsigned short format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkMicromapTriangleEXT format(@Unsigned short value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("dataOffset"),
        ValueLayout.JAVA_SHORT.withName("subdivisionLevel"),
        ValueLayout.JAVA_SHORT.withName("format")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$dataOffset = PathElement.groupElement("dataOffset");
    public static final PathElement PATH$subdivisionLevel = PathElement.groupElement("subdivisionLevel");
    public static final PathElement PATH$format = PathElement.groupElement("format");

    public static final OfInt LAYOUT$dataOffset = (OfInt) LAYOUT.select(PATH$dataOffset);
    public static final OfShort LAYOUT$subdivisionLevel = (OfShort) LAYOUT.select(PATH$subdivisionLevel);
    public static final OfShort LAYOUT$format = (OfShort) LAYOUT.select(PATH$format);

    public static final long SIZE$dataOffset = LAYOUT$dataOffset.byteSize();
    public static final long SIZE$subdivisionLevel = LAYOUT$subdivisionLevel.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();

    public static final long OFFSET$dataOffset = LAYOUT.byteOffset(PATH$dataOffset);
    public static final long OFFSET$subdivisionLevel = LAYOUT.byteOffset(PATH$subdivisionLevel);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
}
